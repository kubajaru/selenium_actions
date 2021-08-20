package page;

import core.elements.Button;
import core.elements.Checkbox;
import core.elements.Label;
import org.openqa.selenium.By;

/**
 * Class representing page with async controls.
 */
public class DynamicControlsPage extends BasePage {
    private static final By pageLocator = By.id("checkbox-example");
    private final Button swapButton = new Button(By.cssSelector("form[id='checkbox-example'] button"), "Swap button");
    private Checkbox checkbox = new Checkbox(By.id("checkbox"), "Checkbox");
    private Label prompt;
    private final By promptLocator = By.id("message");
    private final By checkboxLocator = By.id("checkbox");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public DynamicControlsPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to change the state of the checkbox. Working like a switch.
     */
    public void changeCheckboxVisibility() {
        swapButton.click();

        if (prompt == null) {
            prompt = new Label(promptLocator, "Checkbox gone prompt");
            checkbox = null;
        } else {
            prompt = null;
            checkbox = new Checkbox(checkboxLocator, "Checkbox");
        }
    }

    /**
     * Method to check if checkbox is gone from the page.
     *
     * @return True if checkbox is gone.
     */
    public boolean isCheckboxGone(int timeLimit) {
        if (prompt == null) {
            return !checkbox.isPresent(timeLimit);
        } else {
            return prompt.isPresent(timeLimit);
        }

    }
}
