package page;

import core.elements.Button;
import core.elements.TextField;
import org.openqa.selenium.By;

/**
 * Class representing page with login.
 */
public class LoginPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final TextField usernameTextField = new TextField(By.id("username"), "Username field");
    private final TextField passwordTextField = new TextField(By.id("password"), "Password field");
    private final Button loginButton = new Button(By.cssSelector("button[type='submit']"), "Login button");
    private final Button logoutButton = new Button(By.cssSelector("a[href='/logout']"), "Logout button");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public LoginPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to sign in using passed username and password.
     *
     * @param username String send to username text field.
     * @param password String send to password text field.
     */
    public void login(String username, String password) {
        usernameTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }

    /**
     * Method to check if sign in successful.
     *
     * @return True if successful.
     */
    public boolean isLoginSuccessful() {
        return logoutButton.isPresent(10);
    }
}
