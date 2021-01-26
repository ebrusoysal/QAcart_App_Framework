package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AgreementScreen extends Base {
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Notendaskilmálar']")
    public MobileElement pageTitle;

    @AndroidFindBy(id = "grit.storytel.app:id/button_positive")
    public MobileElement acceptButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Marketing Consent']")
    public MobileElement popUp;

    @AndroidFindBy(id = "grit.storytel.app:id/button_negative")
    public MobileElement popUpNoButton;
}
