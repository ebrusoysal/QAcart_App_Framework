package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.Random;

public class CreateAccountScreen extends Base {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create account']")
    public MobileElement pageTitle;

    @AndroidFindBy(id = "grit.storytel.app:id/edit_text_email")
    public MobileElement email;

    @AndroidFindBy(id = "grit.storytel.app:id/edit_text_password")
    public MobileElement password;

    @AndroidFindBy(id = "grit.storytel.app:id/button_sign_in")
    public MobileElement continueButton;

    public void createValidAccount() {
        email.sendKeys(generateRandomString() + "@gmail.com");
        password.sendKeys(generateRandomString());
        continueButton.click();
    }
}
