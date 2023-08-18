package base.runner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;


public class ScreenShot implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        captureScreenshot(result.getName(), BaseTest.driver);
    }
    private void captureScreenshot(String screenshotName, WebDriver driver) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File targetFile = new File("screenshots/" + screenshotName + ".png");
            try {
                FileUtils.copyFile(sourceFile, targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

