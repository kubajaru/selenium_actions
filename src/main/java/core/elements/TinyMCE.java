package core.elements;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing TinyMCE editor
 */
public class TinyMCE extends BaseElement {
    private TextField textField;
    private final By textFieldLocator = By.cssSelector("body#tinymce p");
    private final Frame frame = new Frame(By.cssSelector("iframe#mce_0_ifr"), "Frame");


    /**
     * Constructor of class Tiny MCE
     *
     * @param locator     Locator of whole editor
     * @param elementName Name of the whole editor
     */
    public TinyMCE(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to switch from the default content to the frame with editor. Name of the frame is passed in the
     * constructor.
     */
    private void switchToFrame() {
        browser.getDriver().switchTo().frame(frame.getElement(5));
        textField = new TextField(textFieldLocator, "Text field of editor");
    }

    /**
     * Method to switch back to the default contents of the DOM.
     */
    private void switchToDefault() {
        browser.getDriver().switchTo().defaultContent();
        textField = null;
    }

    /**
     * Method to clear the text field.
     */
    public void clear() {
        this.switchToFrame();
        textField.getElement(2).clear();
        this.switchToDefault();
    }

    /**
     * Method to input in the text field the value passed as parameter.
     *
     * @param value Value to be inputted into text editor.
     */
    public void sendValue(String value) {
        this.switchToFrame();
        textField.sendKeys(value);
        this.switchToDefault();
    }

    /**
     * Method to get the current value of editor's text field.
     *
     * @return Current value of editor's text field.
     */
    public String getValue() {
        this.switchToFrame();
        String result = textField.getElement(2).getText();
        this.switchToDefault();
        return result;
    }
}
