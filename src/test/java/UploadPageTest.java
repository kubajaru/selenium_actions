import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.UploadPage;

import java.io.File;
import java.io.IOException;

public class UploadPageTest extends BaseTest {

    @Test(description = "Scenario: Upload file  \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/upload \n" +
            "And: Page created \n" +
            "When: Uploading file test.txt\n" +
            "Then: Upload should be successful")
    @Parameters({"url", "filePath"})
    public void testUploadFile(String url, String filePath) throws IOException {
        browser.navigate(url);
        UploadPage page = new UploadPage("Upload page");
        File file = new File("notworking.txt");
        file.createNewFile();
        Assert.assertTrue(page.uploadFile(file.getAbsolutePath()), "File not uploaded correctly!");
    }
}