package core.elements.dropdown;

import core.BaseElement;
import org.openqa.selenium.By;

/**
 * Class representing dropdown list.
 */
public class DropdownList extends BaseElement {
    private final DropdownOptions dropdownOptions = new DropdownOptions(By.cssSelector("select#dropdown > option"), "Dropdown options");

    public DropdownList(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to click option with passed index.
     *
     * @param index Index of option in the dropdown.
     * @return True if selected correctly.
     */
    public boolean clickOption(int index) {
        logger.info(String.format("Clicking option number %d", index));
        dropdownOptions.getElements().get(index).click();
        return dropdownOptions.getElements().get(index).isSelected();
    }
}
