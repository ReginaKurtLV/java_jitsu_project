package shop.project;

import org.axemple.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import shop.project.BaseTest;

public class HomePageTest extends BaseTest {

    @Test
    public void searchTShirtTest(){
        HomePage tShirt = new HomePage(driver);
        tShirt.search()
                .writeTextTShirt()
                .submit();
        Assert.assertEquals("Faded Short Sleeve T-shirts", tShirt.firstSellWithTShirt());
    }
}
