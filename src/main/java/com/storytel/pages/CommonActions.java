package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CommonActions extends Base {

    public void scrollToAnElement(MobileElement element) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.15);
        TouchAction t = new TouchAction(driver);

        for (int i = 0; i < 10; i++) {
            try {
                t.longPress((PointOption.point(startX, startY)));
                t.moveTo(PointOption.point(startX, endY));
                t.release();
                t.perform();
                element.isDisplayed();
                break;
            } catch (NoSuchElementException ex) {
                System.out.printf("Element not available. Scrolling (%s) times...%n", i + 1);
            }
        }
    }

    public void clickBackButton() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public void isDisplayed(MobileElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
    }

    public void isEqual(String actualValue, String expectedValue) {
        Assert.assertEquals(actualValue, expectedValue);
    }

}
