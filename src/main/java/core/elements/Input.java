package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing input tag.
 */
public class Input extends BaseElement {
    public Input(By locator, String elementName) {
        super(locator, elementName);
    }
}
