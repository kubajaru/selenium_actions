package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Class representing Browser
 */
public class Browser {
    private static Browser instance;
    private static RemoteWebDriver driver;

    /**
     * Method to open new Chrome browser with the chrome driver.
     *
     * @return Instance of Browser
     */
    public static Browser getInstance() {
        if (instance == null) {
            try {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox");
                options.setHeadless(true);
                driver = new ChromeDriver(options);

            } catch (Exception e) {
                e.printStackTrace();
            }
            instance = new Browser();
        }
        return instance;
    }

    /**
     * Method to get the driver
     *
     * @return WebDriver
     */
    public RemoteWebDriver getDriver() {
        return driver;
    }

    /**
     * Method to navigate to the passed url
     *
     * @param url Url to which browser should navigate
     */
    public void navigate(String url) {
        driver.get(url);
    }

    /**
     * Method to safely close browser and dispose driver
     */
    public static void exit() {
        try {
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            instance = null;
        }
    }

    /**
     * Method to check if browser is still opened
     *
     * @return true if it is alive
     */
    public boolean isBrowserAlive() {
        return instance != null;
    }

}
