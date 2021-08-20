package core.elements.dropdown;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing option of dropdown list.
 */
public class DropdownOptions extends BaseElement {
    public DropdownOptions(By locator, String elementName) {
        super(locator, elementName);
    }
}
