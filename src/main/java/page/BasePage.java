package page;

import core.Logger;
import core.elements.Label;
import org.openqa.selenium.By;

/**
 * Class representing the base for all pages.
 */
public class BasePage {
    protected static final Logger logger = Logger.getInstance();
    private final By locator;
    private final String name;

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param locator Locator to find element.
     * @param name    Name of the page. Used by the logger.
     */
    BasePage(By locator, String name) {
        this.locator = locator;
        this.name = name;
        checkPageOpen();
    }

    /**
     * Method to check if page is opened.
     */
    private void checkPageOpen() {
        Label elem = new Label(locator, name);
        try {
            elem.waitForIsElementPresent(10);
        } catch (Throwable e) {
            System.err.println("Page was not opened");
        }
    }
}
