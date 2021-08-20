package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

public class Frame extends BaseElement {
    /**
     * Constructor of element taking locator to find element and its name.
     *
     * @param locator     Locator to find element.
     * @param elementName Name of the element. Used by the logger.
     */
    public Frame(By locator, String elementName) {
        super(locator, elementName);
    }
}
