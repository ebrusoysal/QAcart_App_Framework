package com.storytel.pages;

import com.storytel.base.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BookPreviewScreen extends Base {
    @AndroidFindBy(id = "grit.storytel.app:id/textViewBookName")
    public MobileElement bookTitle;

    @AndroidFindBy(id = "grit.storytel.app:id/btnBookshelfToggle")
    public MobileElement likeButton;

    @AndroidFindBy(id = "grit.storytel.app:id/snackbar_text")
    public MobileElement snackBarText;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    public MobileElement backButton;

    @AndroidFindBy(id = "grit.storytel.app:id/bAuthor")
    public MobileElement author;

}
