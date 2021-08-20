package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing text field
 */
public class TextField extends BaseElement {
    public TextField(By locator, String elementName) {
        super(locator, elementName);
    }
}
