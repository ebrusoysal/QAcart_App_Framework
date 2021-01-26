package com.storytel.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.Random;

public class Base {
    public static AppiumDriver<MobileElement> driver;
    public static JSONObject userTestData;
    public static ExtentReports extentReports;
    public static ExtentTest logger;
    public static WebDriverWait wait;

    public Base() {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @BeforeSuite
    public void beforeSuite() {
        extentReports = new ExtentReports("Reports/index.html", true);
        File extentConfig = new File("extent-reports.xml");
        extentReports.loadConfig(extentConfig);
        extentReports.addSystemInfo("Tester", "Ebru");
        extentReports.addSystemInfo("User Name", "soysale");
    }

    @AfterSuite
    public void afterSuite() {
        extentReports.flush();
    }

    @BeforeClass
    public String generateRandomString() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String alphanumeric = alphabet + numbers;
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 10;
        for(int i=0; i<length; i++) {
            int index = random.nextInt(alphanumeric.length());
            char randomChar = alphanumeric.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    @Parameters({"platformName", "deviceName"})
    @BeforeMethod
    public void LaunchApp(String platformName, String deviceName, Method method) throws IOException {
        logger = extentReports.startTest(method.getName());
        logger.log(LogStatus.INFO, "Platform Name: " + platformName + " --> Device Name: " + deviceName);

        File config = new File("src/main/resources/config.properties");
        FileInputStream inputStream = new FileInputStream(config);
        Properties properties = new Properties();
        properties.load(inputStream);

        URL appiumServerURL = new URL(properties.getProperty("appiumURL"));

        DesiredCapabilities caps = new DesiredCapabilities();
        if (platformName.equalsIgnoreCase("android")) {
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability("appPackage", properties.getProperty("appPackage"));
            caps.setCapability("appActivity", properties.getProperty("appActivity"));
            driver = new AndroidDriver<MobileElement>(appiumServerURL, caps);
        } else if (platformName.equalsIgnoreCase("ios")) {
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability("appPackage", properties.getProperty("appPackage"));
            caps.setCapability("appActivity", properties.getProperty("appActivity"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            driver = new IOSDriver<MobileElement>(appiumServerURL, caps);
        }
        wait = new WebDriverWait(driver, 7);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("ScreenShots/" + result.getName() + ".png"));
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(LogStatus.FAIL, result.getName() + "   --->   " + result.getThrowable());
            logger.log(LogStatus.INFO, logger.addScreenCapture("../ScreenShots/" + result.getName() + ".png"));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(LogStatus.PASS, result.getName());
            logger.log(LogStatus.INFO, logger.addScreenCapture("../ScreenShots/" + result.getName() + ".png"));
        }
        extentReports.endTest(logger);
    }
}
