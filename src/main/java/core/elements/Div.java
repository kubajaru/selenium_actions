package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing div tag
 */
public class Div extends BaseElement {
    public Div(By locator, String elementName) {
        super(locator, elementName);
    }

    public boolean isNotVisible() {
        return !browser.getDriver().findElement(getLocator()).isDisplayed();
    }
}
