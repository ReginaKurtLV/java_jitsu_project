package test;
import base.runner.BaseTest;
import Page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.Constants.PROMOTION_PAGE_TEXT;


public class HomePageTest extends BaseTest {

    @Test
    public void FreeTestButton(){
        HomePage testFreeButton = new HomePage(driver);

        testFreeButton.freeButtonSubmit();
        Assert.assertEquals(PROMOTION_PAGE_TEXT, testFreeButton.getTextFree());
    }
}
