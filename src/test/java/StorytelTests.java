import com.storytel.base.Base;
import com.storytel.pages.*;
import org.testng.annotations.Test;

public class StorytelTests extends Base {
    CommonActions commonActions;
    WelcomeScreen welcomeScreen;
    CountrySelectionScreen countrySelectionScreen;
    LanguageSelectionScreen languageSelectionScreen;
    BookTipsScreen bookTipsScreen;
    BookPreviewScreen bookPreviewScreen;
    CreateAccountScreen createAccountScreen;
    AgreementScreen agreementScreen;
    WelcomeToStorytel welcomeToStorytel;
    SearchScreen searchScreen;
    AuthorScreen authorScreen;


    @Test
    public void storytelFlow() {
        commonActions = new CommonActions();
        welcomeScreen = new WelcomeScreen();
        countrySelectionScreen = new CountrySelectionScreen();
        languageSelectionScreen = new LanguageSelectionScreen();
        bookTipsScreen = new BookTipsScreen();
        bookPreviewScreen = new BookPreviewScreen();
        createAccountScreen = new CreateAccountScreen();
        agreementScreen = new AgreementScreen();
        welcomeToStorytel = new WelcomeToStorytel();
        searchScreen = new SearchScreen();
        authorScreen = new AuthorScreen();

        userViewsWelcomeSwipeScreensAndProceeds();
        userSelectsIcelandCountryAndProceeds();
        userSelectsOnlyEnglishLanguageAndProceeds();
        userViewsFeelgoodBookSectionAndSelects7thBook();
        userLikesTheBook();
        userCreatesAccount();
        userSavesTheBookToBookshelf();
        userSearchBooksHavingHarryOnItsNameAndSelectsIt();
        userFiltersBookOptions();
    }

    public void userViewsWelcomeSwipeScreensAndProceeds() {
        welcomeScreen.swipeStories(3);
        welcomeScreen.tryItOut.click();
        commonActions.isDisplayed(countrySelectionScreen.pageTitle);
    }

    public void userSelectsIcelandCountryAndProceeds() {
        commonActions.scrollToAnElement(countrySelectionScreen.iceland);
        countrySelectionScreen.iceland.click();
        countrySelectionScreen.doneButton.click();
        commonActions.isDisplayed(languageSelectionScreen.pageTitle);
    }

    public void userSelectsOnlyEnglishLanguageAndProceeds() {
        languageSelectionScreen.icelandic.click();
        languageSelectionScreen.doneButton.click();
        commonActions.isDisplayed(bookTipsScreen.pageTitle);
    }

    public void userViewsFeelgoodBookSectionAndSelects7thBook() {
        commonActions.scrollToAnElement(bookTipsScreen.feelgood1Book);
        bookTipsScreen.swipeTo7thBook();
        commonActions.isEqual(bookPreviewScreen.bookTitle.getText(), bookTipsScreen.bookTitle);
    }

    public void userLikesTheBook() {
        bookPreviewScreen.likeButton.click();
        commonActions.isDisplayed(createAccountScreen.pageTitle);
    }

    public void userCreatesAccount() {
        createAccountScreen.createValidAccount();
        commonActions.isDisplayed(agreementScreen.pageTitle);
        agreementScreen.acceptButton.click();
        commonActions.isDisplayed(agreementScreen.popUp);
        agreementScreen.popUpNoButton.click();
        commonActions.isDisplayed(welcomeToStorytel.pageTitle);
    }

    public void userSavesTheBookToBookshelf() {
        commonActions.clickBackButton();
        bookPreviewScreen.likeButton.click();
        commonActions.isEqual(bookPreviewScreen.snackBarText.getText(), "Saved to your bookshelf");
    }

    public void userSearchBooksHavingHarryOnItsNameAndSelectsIt() {
        bookPreviewScreen.backButton.click();
        commonActions.isDisplayed(bookTipsScreen.pageTitle);
        bookTipsScreen.sideMenu.click();
        bookTipsScreen.search.click();
        searchScreen.searchBook("Harry");
        commonActions.scrollToAnElement(searchScreen.searchedBook);
        searchScreen.searchedBook.click();
    }

    public void userFiltersBookOptions() {
        bookPreviewScreen.author.click();
        authorScreen.filter.click();
        authorScreen.ebookFilter.click();
        authorScreen.doneButton.click();
        commonActions.isEqual(authorScreen.message.getText(), "Oops! It seems you've filtered a bit too much.");
    }

}
