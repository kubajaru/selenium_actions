import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test(description = "Scenario: Sign in  \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/login \n" +
            "And: Page created \n" +
            "When: Signing in with username: tomsmith and password: SuperSecretPassword!\n" +
            "Then: Sign in should be successful")
    @Parameters({"url", "username", "password"})
    public void testLoginSuccessful(String url, String username, String password) {
        browser.navigate(url);
        LoginPage loginPage = new LoginPage("Login page");
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isLoginSuccessful());
    }
}
