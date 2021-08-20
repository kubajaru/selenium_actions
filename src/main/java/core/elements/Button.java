package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing Button
 */
public class Button extends BaseElement {
    public Button(By locator, String elementName) {
        super(locator, elementName);
    }
}
