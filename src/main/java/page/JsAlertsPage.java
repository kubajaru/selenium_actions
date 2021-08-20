package page;

import core.Browser;
import core.elements.Button;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class representing page with js alerts
 */
public class JsAlertsPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final Browser browser = Browser.getInstance();
    private final Button button = new Button(By.cssSelector("button[onclick='jsConfirm()']"), "JS confirm button");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public JsAlertsPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to open js alert.
     */
    public void openJsAlert() {
        button.getElement(10).click();
    }

    /**
     * Method to check if alert is present.
     *
     * @return true if alert is present.
     */
    public boolean isAlertPresent() {
        Alert alert = ExpectedConditions.alertIsPresent().apply(browser.getDriver());
        return alert != null;
    }


}
