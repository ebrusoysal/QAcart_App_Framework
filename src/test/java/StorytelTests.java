import com.storytel.base.Base;
import com.storytel.pages.*;
import org.testng.annotations.Test;

public class StorytelTests extends Base {

    @Test
    public void storytelFlow() throws InterruptedException {
        CommonActions commonActions = new CommonActions();
        WelcomeScreen welcomeScreen = new WelcomeScreen();
        CountrySelectionScreen countrySelectionScreen = new CountrySelectionScreen();
        LanguageSelectionScreen languageSelectionScreen = new LanguageSelectionScreen();
        BookTipsScreen bookTipsScreen = new BookTipsScreen();
        BookPreviewScreen bookPreviewScreen = new BookPreviewScreen();
        CreateAccountScreen createAccountScreen = new CreateAccountScreen();
        AgreementScreen agreementScreen = new AgreementScreen();
        WelcomeToStorytel welcomeToStorytel = new WelcomeToStorytel();
        SearchScreen searchScreen = new SearchScreen();
        AuthorScreen authorScreen = new AuthorScreen();

        welcomeScreen.swipeStories(3);
        welcomeScreen.tryItOut.click();
        commonActions.isDisplayed(countrySelectionScreen.pageTitle);
        commonActions.scrollToAnElement(countrySelectionScreen.iceland);
        countrySelectionScreen.iceland.click();
        countrySelectionScreen.doneButton.click();
        commonActions.isDisplayed(languageSelectionScreen.pageTitle);
        languageSelectionScreen.icelandic.click();
        languageSelectionScreen.doneButton.click();
        commonActions.isDisplayed(bookTipsScreen.pageTitle);
        commonActions.scrollToAnElement(bookTipsScreen.feelgood1Book);
        bookTipsScreen.swipeTo7thBook();
        commonActions.isEqual(bookPreviewScreen.bookTitle.getText(), bookTipsScreen.bookTitle);
        bookPreviewScreen.likeButton.click();
        commonActions.isDisplayed(createAccountScreen.pageTitle);
        createAccountScreen.createValidAccount();
        commonActions.isDisplayed(agreementScreen.pageTitle);
        agreementScreen.acceptButton.click();
        commonActions.isDisplayed(agreementScreen.popUp);
        agreementScreen.popUpNoButton.click();
        commonActions.isDisplayed(welcomeToStorytel.pageTitle);
        commonActions.clickBackButton();
        bookPreviewScreen.likeButton.click();
        commonActions.isEqual(bookPreviewScreen.snackBarText.getText(), "Saved to your bookshelf");
        bookPreviewScreen.backButton.click();
        commonActions.isDisplayed(bookTipsScreen.pageTitle);
        bookTipsScreen.sideMenu.click();
        bookTipsScreen.search.click();
        searchScreen.searchBook("Harry");
        commonActions.scrollToAnElement(searchScreen.searchedBook);
        searchScreen.searchedBook.click();
        bookPreviewScreen.author.click();
        authorScreen.filter.click();
        authorScreen.ebookFilter.click();
        authorScreen.doneButton.click();
        commonActions.isEqual(authorScreen.message.getText(), "Oops! It seems you've filtered a bit too much.");
    }
}
