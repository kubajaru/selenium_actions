import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.TinyMCEPage;

public class TinyMCEPageTest extends BaseTest {

    @Test(description = "Scenario: Write to editor \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/tinymce \n" +
            "And: Page created \n" +
            "And: Content equal to Your content goes here. \n" +
            "When: Writing to the editor value test\n" +
            "Then: Content of editor should be equal to test")
    @Parameters({"url", "initialValue", "testValue"})
    public void testSendValue(String url, String initialValue, String testValue) {
        browser.navigate(url);
        TinyMCEPage page = new TinyMCEPage("Tiny MCE page");
        Assert.assertEquals(page.getEditorContent(), initialValue);
        page.writeToEditor(testValue);
        Assert.assertEquals(page.getEditorContent(), testValue);
    }
}