package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class WelcomeScreen extends Base {
    @AndroidFindBy(id = "grit.storytel.app:id/carousel_description")
    public MobileElement swipeList;

    @AndroidFindBy(id = "grit.storytel.app:id/create_account_preview")
    public MobileElement tryItOut;

    public void swipeStories(int swipeCount) {
        Point p = wait.until(ExpectedConditions.visibilityOf(swipeList)).getLocation();
        TouchAction t = new TouchAction(driver);

        for (int i = 0; i < swipeCount; i++) {
            t.press(PointOption.point(p.x + 300, p.y));
            t.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)));
            t.moveTo(PointOption.point(p.x + 100, p.y));
            t.release();
            t.perform();
        }
    }

}
