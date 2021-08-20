package core.elements.table;

import core.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Class representing body of table element
 */
public class TableBody extends BaseElement {
    public TableBody(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to get the contents of body from the locator passed in constructor
     *
     * @return List of WebElements
     */
    public List<WebElement> getContents() {
        return browser.getDriver().findElements(getLocator());
    }
}
