package page;

import core.SwapElementsAction;
import core.elements.Column;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Class representing Drag and Drop page.
 */
public class DragAndDropPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final Column columnA = new Column(By.id("column-a"), "BoxA");
    private final Column columnB = new Column(By.id("column-b"), "BoxB");
    private final String initialBoxAValue;
    private final String initialBoxBValue;

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public DragAndDropPage(String name) {
        super(pageLocator, name);
        initialBoxAValue = columnA.getValue();
        logger.info(String.format("Initial value: %s for box A", initialBoxAValue));
        initialBoxBValue = columnB.getValue();
        logger.info(String.format("Initial value: %s for box B", initialBoxBValue));
    }

    /**
     * Method to swap boxes using drag and drop functionality.
     *
     * @param driver WebDriver responsible for performing to drag and drop action.
     * @return True if boxes were swapped correctly.
     */
    public boolean swapBoxes(WebDriver driver) {
        SwapElementsAction.swapElements(driver, columnA, columnB);
        logger.info(String.format("End value: %s for box A", columnA.getValue()));
        logger.info(String.format("End value: %s for box B", columnB.getValue()));

        return initialBoxAValue.equals(columnB.getValue()) && initialBoxBValue.equals(columnA.getValue());
    }
}
