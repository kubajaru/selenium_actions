package page;

import core.elements.TinyMCE;
import org.openqa.selenium.By;

/**
 * Class representing page with TinyMCE editor.
 */
public class TinyMCEPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final TinyMCE editor = new TinyMCE(By.cssSelector("div[role='application']"), "Editor");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public TinyMCEPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to write passed value to the editor.
     *
     * @param value Value to be written to the editor.
     */
    public void writeToEditor(String value) {
        editor.clear();
        editor.sendValue(value);
    }

    /**
     * Method to get content of the editor.
     *
     * @return Content of the editor.
     */
    public String getEditorContent() {
        return editor.getValue();
    }
}
