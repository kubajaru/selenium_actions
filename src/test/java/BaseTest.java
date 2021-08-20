import core.Browser;
import core.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * Base of all tests. Starts and stops the browser. Logs start and end of test with the name of test class.
 */
public class BaseTest {
    private static final Logger logger = Logger.getInstance();
    protected static Browser browser = Browser.getInstance();

    @BeforeClass
    public void init() {
        browser = Browser.getInstance();
    }

    @BeforeTest
    public void beforeTest() {
        logger.logTestName(this.getClass().getName());
    }

    @AfterTest
    public void afterTest() {
        logger.logTestEnd(this.getClass().getName());
    }

    @AfterClass
    public void dispose() {
        if (browser.isBrowserAlive()) {
            browser.exit();
        }
    }
}
