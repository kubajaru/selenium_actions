package page;

import core.elements.table.Table;
import enums.SortBy;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing page containing data tables.
 */
public class DataTablesPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final Table table = new Table(By.cssSelector("table#table2"), "Example 2 table");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public DataTablesPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to sort the table using different options
     *
     * @param options Pass in enum to choose by what criteria table should be sorted.
     * @return List of Strings containing sorted contents of table.
     */
    public List<String> sortTable(SortBy options) {
        if (options == SortBy.LastNameAlphabetic) {
            return table.sortByLastName();
        }
        return new ArrayList<>();
    }

}
