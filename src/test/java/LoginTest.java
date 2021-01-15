import com.qacart.base.Base;
import com.qacart.pages.LoginScreen;
import com.qacart.pages.TasksScreen;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends Base {
    LoginScreen loginScreen;
    TasksScreen tasksScreen;

    @Test
    public void TC001_Login_With_Valid_Credentials() {
        String email = userTestData.getJSONObject("validUser").getString("email");
        String password = userTestData.getJSONObject("validUser").getString("password");

        loginScreen = new LoginScreen();
        tasksScreen = loginScreen.performLogin(email, password);
        Assert.assertTrue(tasksScreen.isLogoutDisplayed());
//        Assert.assertEquals("true", "false");
    }

}
