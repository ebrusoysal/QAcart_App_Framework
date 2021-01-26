package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomeToStorytel extends Base {
    @AndroidFindBy(xpath = "//*[@text='Welcome to Storytel!']")
    public MobileElement pageTitle;
}

