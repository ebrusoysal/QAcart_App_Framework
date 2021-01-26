package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class CountrySelectionScreen extends Base {
    @AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Iceland']")
    public  MobileElement iceland;

    @AndroidFindBy(id = "grit.storytel.app:id/buttonDone")
    public MobileElement doneButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Your country']")
    public MobileElement pageTitle;


}
