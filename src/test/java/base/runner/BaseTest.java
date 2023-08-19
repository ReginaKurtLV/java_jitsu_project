package base.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import Page.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;


@Listeners(ScreenShot.class)
public abstract class BaseTest {
    protected static WebDriver driver;
    protected HomePage dashboardPage;

    @BeforeMethod
    protected void setUp() {

// loading settings from config.properties
        Properties properties = new Properties();
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

// retrieves driver, timeout, browser window size and URL
        String driverPath = properties.getProperty("driverPath");
        int implicitWait = Integer.parseInt(properties.getProperty("implicitWait"));
        String browserWindowSize = properties.getProperty("browserWindowSize");
        String URL = properties.getProperty("URL");

//Check if a browser parameter is specified as a system property.
// If we change browser write in terminal 'mvn test -Dbrowser=firefox'
        String browser = System.getProperty("browser");
        if (browser != null) {
            browser = browser.toLowerCase();
            if ("chrome".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        } else {
            WebDriverManager.chromedriver().setup();
/*
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setHeadless(true);
*/
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
//sizes window
        if (browserWindowSize.equalsIgnoreCase("maximize")) {
            driver.manage().window().maximize();
        }

        driver.get(URL);
        dashboardPage = new HomePage(driver);
    }

    @AfterMethod
    protected void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }
}
