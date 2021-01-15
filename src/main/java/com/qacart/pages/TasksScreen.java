package com.qacart.pages;

import com.qacart.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.testng.Assert;

public class TasksScreen extends Base {
    @iOSXCUITFindBy(accessibility = "logout")
    @AndroidFindBy(accessibility = "logout")
    public MobileElement logoutButton;

    public boolean isLogoutDisplayed(){
        return logoutButton.isDisplayed();
    }
}
