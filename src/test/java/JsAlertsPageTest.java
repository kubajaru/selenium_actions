import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.JsAlertsPage;

public class JsAlertsPageTest extends BaseTest {

    @Test(description = "Scenario: Open js alert  \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/javascript_alerts \n" +
            "And: Page created \n" +
            "When: Opening js alert\n" +
            "Then: Alert should be present")
    @Parameters({"url"})
    public void testOpenJsAlert(String url) {
        browser.navigate(url);
        JsAlertsPage page = new JsAlertsPage("Js Alert page");
        page.openJsAlert();
        Assert.assertTrue(page.isAlertPresent(), "Alert was not opened correctly!");

    }
}