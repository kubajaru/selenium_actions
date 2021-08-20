package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing column
 */
public class Column extends BaseElement {
    public Column(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to get the value of the header inside the column.
     *
     * @return Value of header
     */
    public String getValue() {
        return this.getElement(5).findElement(By.tagName("header")).getText();
    }
}
