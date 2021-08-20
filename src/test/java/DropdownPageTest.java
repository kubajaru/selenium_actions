import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DropdownPage;

public class DropdownPageTest extends BaseTest {

    @Test(description = "Scenario: Select option from dropdown \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/dropdown \n" +
            "And: Page created \n" +
            "When: Selecting option with index 1 \n" +
            "Then: Option should be selected")
    @Parameters({"url", "index"})
    public void testSelectOption(String url, String index) {
        browser.navigate(url);
        DropdownPage page = new DropdownPage("Dropdown page");
        Assert.assertTrue(page.selectOption(Integer.parseInt(index)), "Option not selected correctly!");
    }
}