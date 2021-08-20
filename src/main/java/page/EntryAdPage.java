package page;

import core.elements.Div;
import core.elements.TextButton;
import org.openqa.selenium.By;

/**
 * Class representing page with entry ad.
 */
public class EntryAdPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final TextButton textButton = new TextButton(By.cssSelector("div.modal-footer p"), "Text button");
    private final Div div = new Div(By.id("modal"), "Ad popup");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public EntryAdPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to close an entry ad.
     *
     * @return True if ad is closed.
     */
    public boolean closeAd() {
        textButton.click();
        return div.isNotVisible();
    }
}
