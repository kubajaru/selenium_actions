package core.elements.table;

import core.BaseElement;
import enums.TableColumns;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing Table element
 */
public class Table extends BaseElement {
    private final TableHead tableHead = new TableHead(By.cssSelector("table#table2 > thead th"), "Table header");
    private final TableBody tableBody = new TableBody(By.cssSelector("table#table2 > tbody > tr"), "Table body");

    public Table(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to sort the data from the table by last name in alphabetic order.
     *
     * @return List of Strings, where one element of list if one row in table separated by spaces.
     */
    public List<String> sortByLastName() {
        tableHead.getHeader(TableColumns.LastName.indexOfColumn).click();
        List<String> output = new ArrayList<>();
        tableBody.getContents().forEach(webElement -> {
            StringBuilder sb = new StringBuilder();
            sb.append(webElement.findElement(By.cssSelector("tr > td.last-name")).getText()).append(" ");
            sb.append(webElement.findElement(By.cssSelector("tr > td.first-name")).getText()).append(" ");
            sb.append(webElement.findElement(By.cssSelector("tr > td.email")).getText()).append(" ");
            sb.append(webElement.findElement(By.cssSelector("tr > td.dues")).getText()).append(" ");
            sb.append(webElement.findElement(By.cssSelector("tr > td.web-site")).getText());
            output.add(sb.toString());
        });
        return output;
    }
}
