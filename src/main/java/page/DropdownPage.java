package page;

import core.elements.dropdown.DropdownList;
import org.openqa.selenium.By;

/**
 * Class representing page with dropdown.
 */
public class DropdownPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final DropdownList dropdownList = new DropdownList(By.cssSelector("select#dropdown"), "Dropdown list");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public DropdownPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to select option from the dropdown.
     *
     * @param index Index of the option in the dropdown.
     * @return True if option is selected correctly.
     */
    public boolean selectOption(int index) {
        return dropdownList.clickOption(index);
    }
}
