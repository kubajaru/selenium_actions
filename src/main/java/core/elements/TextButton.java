package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing clickable text
 */
public class TextButton extends BaseElement {
    public TextButton(By locator, String elementName) {
        super(locator, elementName);
    }
}
