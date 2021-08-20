import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.SliderPage;

public class SliderPageTest extends BaseTest {

    @Test(description = "Scenario: Move slider to right by 2 steps \n" +
            "Given: Navigated to http://the-internet.herokuapp.com/horizontal_slider \n" +
            "And: Page created \n" +
            "When: Moving slider to right by 2 steps\n" +
            "Then: Value of slider should be equal to 1")
    @Parameters({"url"})
    public void testMoveSliderRight(String url) {
        browser.navigate(url);
        SliderPage page = new SliderPage("Slider page");
        Assert.assertTrue(page.moveSliderRight(2), "Slider was not moved correctly!");
        Assert.assertTrue(page.moveSliderRight(4), "Slider was not moved correctly!");
    }
}