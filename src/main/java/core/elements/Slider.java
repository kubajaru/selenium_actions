package core.elements;

import core.BaseElement;
import enums.Directions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Slider extends BaseElement {
    /**
     * Constructor of element taking locator to find element and its name.
     *
     * @param locator     Locator to find element.
     * @param elementName Name of the element. Used by the logger.
     */
    public Slider(By locator, String elementName) {
        super(locator, elementName);
    }

    /**
     * Method to move the slider by passed offset.
     */
    private void moveSlideRightOneStep() {
        this.sendKeys(Keys.RIGHT);
    }

    public boolean moveSlider(Directions direction, int initialValue, int endValue) {
        double max = Double.parseDouble(getElement(2).getAttribute("max"));
        double min = Double.parseDouble(getElement(2).getAttribute("min"));
        double step = Double.parseDouble(getElement(2).getAttribute("step"));

        if (endValue > max) return false;

        if (endValue < min) return false;


        if (initialValue < max && direction == Directions.RIGHT) {
            for (int i = 0; i < (endValue / step) - (initialValue / step); i++) {
                moveSlideRightOneStep();
            }
            return true;
        }
        return false;
    }
}
