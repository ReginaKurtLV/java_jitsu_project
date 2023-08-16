package shop.project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver createChromeDriver() {

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
