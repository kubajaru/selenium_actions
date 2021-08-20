package core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Class representing base for all elements.
 */
public class BaseElement {
    protected static Browser browser = Browser.getInstance();
    protected static final Logger logger = Logger.getInstance();
    protected RemoteWebElement element;
    private final By locator;
    private final String name;

    /**
     * Constructor of element taking locator to find element and its name.
     *
     * @param locator     Locator to find element.
     * @param elementName Name of the element. Used by the logger.
     */
    public BaseElement(By locator, String elementName) {
        this.locator = locator;
        name = elementName;
        logger.info(String.format("Created element %s", elementName));
    }

    /**
     * Method to get the element in form of WebElement
     *
     * @param timeout How much time it should look for the web element.
     * @return Web element representing element.
     */
    public RemoteWebElement getElement(int timeout) {
        waitForIsElementPresent(timeout);
        return element;
    }

    /**
     * Method to wait for the element to be present in the DOM.
     *
     * @param timeout How much time it should look for the web element.
     */
    public void waitForIsElementPresent(int timeout) {
        this.isPresent(timeout);
        assertTrue(element.isDisplayed(), "Element is not presented");
    }

    /**
     * Method to get locator of the element.
     *
     * @return By locator of the element
     */
    public By getLocator() {
        return locator;
    }

    /**
     * Method to perform click on the element.
     */
    public void click() {
        waitForIsElementPresent(10);
        logger.info(String.format("Click on %s element", name));
        element.click();
    }

    /**
     * Method to send String value to the element.
     *
     * @param value Value to be sent to element.
     */
    public void sendKeys(String value) {
        logger.info(String.format("Send <%s> value to %s element", value, name));
        browser.getDriver()
                .findElement(locator)
                .sendKeys(value);
    }

    /**
     * Method to send String value to the element.
     *
     * @param value Value of the key to be sent to element.
     */
    public void sendKeys(Keys value) {
        logger.info(String.format("Send <%s> value to %s element", value, name));
        browser.getDriver()
                .findElement(locator)
                .sendKeys(value);
    }

    /**
     * Method to get list of elements if the object represents more than one list.
     *
     * @return List of WebElements
     */
    public List<WebElement> getElements() {
        return browser.getDriver().findElements(locator);
    }

    /**
     * Method to check if the element is present in the DOM.
     *
     * @param timeout How much time it should look for the element.
     * @return True if present.
     */
    public boolean isPresent(int timeout) {
        WebDriverWait wait = new WebDriverWait(Browser.getInstance().getDriver(), timeout);
        browser.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            wait.until((ExpectedCondition<Boolean>) driver -> {
                try {
                    List<WebElement> list = driver.findElements(locator);
                    for (WebElement el : list) {
                        if (el instanceof RemoteWebElement && el.isDisplayed()) {
                            element = (RemoteWebElement) el;
                            return element.isDisplayed();
                        }
                    }
                    element = (RemoteWebElement) driver.findElement(locator);
                } catch (Exception e) {
                    logger.warn(String.format("Element %s is not presented", name));
                    return false;
                }
                return element.isDisplayed();
            });
        } catch (Exception e) {
            return false;
        }
        try {
            browser.getDriver().manage()
                    .timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
            return element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
