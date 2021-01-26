package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchScreen extends Base {
    @AndroidFindBy(id = "grit.storytel.app:id/autoCompleteTextView")
    public MobileElement searchField;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='The Adventures of Harry Stevenson']")
    public MobileElement searchedBook;

    public void searchBook(String text) {
        searchField.click();
        searchField.sendKeys(text);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("grit.storytel.app:id/recyclerView"))));
        driver.hideKeyboard();
    }
}
