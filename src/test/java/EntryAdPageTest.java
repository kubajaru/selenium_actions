import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.EntryAdPage;

public class EntryAdPageTest extends BaseTest {

    @Test(description = "Scenario: Close entry ad \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/entry_ad \n" +
            "And: Page created \n" +
            "When: Clicking on close ad button \n" +
            "Then: Ad should be closed")
    @Parameters({"url"})
    public void testCloseAd(String url) {
        browser.navigate(url);
        EntryAdPage page = new EntryAdPage("Entry ad page");
        Assert.assertTrue(page.closeAd(), "Ad not closed correctly!");
    }
}