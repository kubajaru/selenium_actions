package page;

import core.elements.Label;
import core.elements.Slider;
import enums.Directions;
import org.openqa.selenium.By;

/**
 * Class representing page with slider
 */
public class SliderPage extends BasePage {
    private static final By pageLocator = By.id("content");
    private final Slider slider = new Slider(By.cssSelector("input[type='range']"), "Slider");
    private final Label sliderValue = new Label(By.cssSelector("span#range"), "Slider value label");

    /**
     * Constructor of page taking locator to find element and its name.
     *
     * @param name Name of the page. Used by the logger.
     */
    public SliderPage(String name) {
        super(pageLocator, name);
    }

    /**
     * Method to move slider right by the passed number of steps.
     *
     * @param endValue Value to which we should move slider
     * @return true if slider was moved correctly.
     */
    public boolean moveSliderRight(int endValue) {
        int initialValue = Integer.parseInt(sliderValue.getElement(10).getText());
        if (slider.moveSlider(Directions.RIGHT, initialValue, endValue)) {
            return Integer.parseInt(sliderValue.getElement(10).getText()) == endValue;
        } else {
            return false;
        }
    }


}
