import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.DragAndDropPage;

public class DragAndDropPageTest extends BaseTest {

    @Test(description = "Scenario: Swap boxes \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/drag_and_drop \n" +
            "And: Page created \n" +
            "When: boxes swapped \n" +
            "Then: Boxes on the page should be swapped")
    @Parameters({"url"})
    public void testSwapBoxes(String url) {
        browser.navigate(url);
        DragAndDropPage page = new DragAndDropPage("Drag and Drop page");
        Assert.assertTrue(page.swapBoxes(browser.getDriver()), "Boxes not swapped correctly!");
    }
}