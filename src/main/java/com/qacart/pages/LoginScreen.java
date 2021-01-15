package com.qacart.pages;

import com.qacart.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginScreen extends Base {

    @iOSXCUITFindBy(accessibility = "email")
    @AndroidFindBy(accessibility = "email")
    public MobileElement emailField;

    @iOSXCUITFindBy(accessibility = "password")
    @AndroidFindBy(accessibility = "password")
    public MobileElement passwordField;

    @iOSXCUITFindBy(accessibility = "loginButton")
    @AndroidFindBy(accessibility = "loginButton")
    public MobileElement login;

    @iOSXCUITFindBy(accessibility = "signupButton")
    @AndroidFindBy(accessibility = "signupButton")
    public MobileElement signup;

    @iOSXCUITFindBy(accessibility = "errorMessage")
    @AndroidFindBy(accessibility = "errorMessage")
    public MobileElement error;

    public TasksScreen performLogin(String param1, String param2) {
        emailField.sendKeys(param1);
        passwordField.sendKeys(param2);
        login.click();
        return new TasksScreen();
    }
}
