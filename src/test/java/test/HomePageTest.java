package test;
import base.runner.BaseTest;
import Page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    public static final String PROMOTION_PAGE_TEXT = "Revolutionize Your Human Resource Management Experience!";
    public static final String FREE_DEMO_PAGE_TEXT = "Manage Your People and Operations in One Place";

    @Test
    public void freeTestButtonTest(){
        HomePage testFreeButton = new HomePage(driver);

        testFreeButton.freeButtonSubmit();
        Assert.assertEquals(PROMOTION_PAGE_TEXT, testFreeButton.getTextFree());
    }

    @Test
    public void bookFreedomButtonTest(){
        HomePage testFreedomButton = new HomePage(driver);

        testFreedomButton.bookFreeDemoButtonClick();
        Assert.assertEquals(FREE_DEMO_PAGE_TEXT, testFreedomButton.getTextFreeDemoPage());
    }
}
