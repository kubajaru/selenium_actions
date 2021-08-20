package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing label
 */
public class Label extends BaseElement {
    public Label(By locator, String elementName) {
        super(locator, elementName);
    }
}
