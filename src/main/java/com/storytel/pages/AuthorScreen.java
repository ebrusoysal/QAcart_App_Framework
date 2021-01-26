package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AuthorScreen extends Base {
    @AndroidFindBy(id = "grit.storytel.app:id/buttonFilter")
    public MobileElement filter;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@text='Ebook']")
    public MobileElement ebookFilter;

    @AndroidFindBy(id = "grit.storytel.app:id/buttonDone")
    public MobileElement doneButton;

    @AndroidFindBy(id = "grit.storytel.app:id/textViewNoResult")
    public MobileElement message;
}
