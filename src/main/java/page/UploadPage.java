package page;

import core.elements.Button;
import core.elements.Div;
import core.elements.Input;
import org.openqa.selenium.By;

/**
 * Class representing page with upload functionality.
 */
public class UploadPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final Input input = new Input(By.id("file-upload"), "Choose file");
    private final Button button = new Button(By.id("file-submit"), "Upload file");
    private final Div div = new Div(By.id("uploaded-files"), "Uploaded files prompt");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public UploadPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to upload file using path to the file.
     *
     * @param path Path to the file that should be uploaded.
     * @return True if uploaded correctly.
     */
    public boolean uploadFile(String path) {
        input.sendKeys(path);
        button.click();
        return path.endsWith(div.getElement(5).getText());
    }
}
