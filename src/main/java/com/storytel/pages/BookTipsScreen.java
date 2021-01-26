package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class BookTipsScreen extends Base {
    public String bookTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Book tips']")
    public MobileElement pageTitle;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Feelgood\"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]")
    public MobileElement feelgood1Book;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Feelgood\"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]")
    public MobileElement feelgood2Book;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Feelgood\"]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[1]")
    public MobileElement selectedBook;

    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    public MobileElement sideMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Search']")
    public MobileElement search;

    public void swipeTo7thBook() {
        Dimension size = driver.manage().window().getSize();
        int startX = feelgood2Book.getLocation().x + 10;
        int endX = feelgood1Book.getLocation().x;
        int startY = feelgood1Book.getLocation().y;
        TouchAction t = new TouchAction(driver);

        for (int i = 0; i < 6; i++) {
                t.longPress(PointOption.point(startX, startY));
                t.moveTo(PointOption.point(endX, startY));
                t.release();
                t.perform();
            }
        bookTitle = selectedBook.getAttribute("content-desc");
        feelgood1Book.click();
    }

}
