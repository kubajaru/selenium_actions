import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DynamicControlsPage;

public class DynamicControlsPageTest extends BaseTest {
    @Test(description = "Scenario: Change visibility of checkbox \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/dynamic_controls \n" +
            "And: Page created \n" +
            "When: Changing visibility of checkbox \n" +
            "Then: Checkbox should not be visible")
    @Parameters({"url", "timeLimit"})
    public void testSwapCheckbox(String url, String timeLimit) {
        browser.navigate(url);
        DynamicControlsPage page = new DynamicControlsPage("Dynamic controls page");
        Assert.assertFalse(page.isCheckboxGone(Integer.parseInt(timeLimit)));
        page.changeCheckboxVisibility();
        Assert.assertTrue(page.isCheckboxGone(Integer.parseInt(timeLimit)));
    }
}
