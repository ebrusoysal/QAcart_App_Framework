package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LanguageSelectionScreen extends Base {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select languages']")
    public MobileElement pageTitle;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Icelandic']")
    public MobileElement icelandic;

    @AndroidFindBy(id = "grit.storytel.app:id/buttonDone")
    public MobileElement doneButton;
}
