package com.qacart.base;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    public static AppiumDriver<MobileElement> driver;
    public static JSONObject userTestData;
    public static ExtentReports extentReports;
    public static ExtentTest logger;

    public Base(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @BeforeSuite
    public void beforeSuite(){
        extentReports = new ExtentReports("Reports/index.html", true);
        File extentConfig = new File("/Users/ebrusoysal/IdeaProjects/QAcart_App_Framework/extent-reports.xml");
        extentReports.loadConfig(extentConfig);
        extentReports.addSystemInfo("Tester", "Ebru");
        extentReports.addSystemInfo("User Name", "soysale");
    }

    @AfterSuite
    public void afterSuite(){
        extentReports.flush();
    }

    @BeforeClass
    public void beforeClass() throws FileNotFoundException {
        File testDataFile = new File("src/main/resources/testData.json");
        FileInputStream testDataInputStream = new FileInputStream(testDataFile);
        JSONTokener tokener = new JSONTokener(testDataInputStream);
        userTestData = new JSONObject(tokener);
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
        if(platformName.equalsIgnoreCase("android")) {
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.APP, properties.getProperty("androidApp"));
            driver = new AndroidDriver<MobileElement>(appiumServerURL, caps);
        }
        else if(platformName.equalsIgnoreCase("ios")) {
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.APP, properties.getProperty("iosApp"));
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            driver = new IOSDriver<MobileElement>(appiumServerURL, caps);
        }

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        File screenShot = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File("ScreenShots/" + result.getName() + ".png"));
        if(result.getStatus() == ITestResult.FAILURE){
            logger.log(LogStatus.FAIL, result.getName() + "   --->   " + result.getThrowable());
            logger.log(LogStatus.INFO, logger.addScreenCapture("../ScreenShots/" + result.getName() + ".png"));
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            logger.log(LogStatus.PASS, result.getName());
            logger.log(LogStatus.INFO, logger.addScreenCapture("../ScreenShots/" + result.getName() + ".png"));
        }
        extentReports.endTest(logger);
    }
}
