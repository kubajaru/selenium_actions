package core.elements.table;

import core.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class representing header of table
 */
public class TableHead extends BaseElement {
    public TableHead(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to get header cell with provided index
     *
     * @param index index of header cell
     * @return Header cell
     */
    public WebElement getHeader(int index) {
        return browser.getDriver().findElements(getLocator()).get(index);
    }
}
