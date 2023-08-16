package org.axemple;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

        protected WebDriver driver;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void wait2(By locator) {
        waitForElementToBeClickable(locator, 2);
    }
    public void wait5 (By locator) {
        waitForElementToBeClickable(locator, 5);
    }
    public void wait10 (By locator) {
        waitForElementToBeClickable(locator, 10);
    }
}

