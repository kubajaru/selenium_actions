import enums.SortBy;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DataTablesPage;

import java.util.List;

public class DataTablesPageTest extends BaseTest {

    @Test(description = "Scenario: Sort table by last name \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/tables#edit \n" +
            "And: Page created \n" +
            "When: Page is sorted by last name \n" +
            "Then: Result should be in alphabetic order by last name \n")
    @Parameters({"url", "person1", "person2", "person3", "person4"})
    public void testSortByLastName(String url, String person1, String person2, String person3, String person4) {
        browser.navigate(url);
        DataTablesPage page = new DataTablesPage("Data tables page");
        List<String> sortedValues = page.sortTable(SortBy.LastNameAlphabetic);
        Assert.assertEquals(sortedValues.get(0), person1);
        Assert.assertEquals(sortedValues.get(1), person2);
        Assert.assertEquals(sortedValues.get(2), person3);
        Assert.assertEquals(sortedValues.get(3), person4);
    }
}
