package shop.project;
import org.axemple.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    private static final String textTShirt = "Faded Short Sleeve T-shirts";
    private static final String textWomen = "WOMEN";

    @Test
    public void searchTShirtTest(){
        HomePage tShirt = new HomePage(driver);

        tShirt.search()
                .writeTextTShirt()
                .submit();
        Assert.assertEquals(textTShirt, tShirt.firstSellWithTShirt());
    }

    @Test
    public void pushButtonWomen(){
        HomePage womenButton = new HomePage(driver);

        womenButton.submitWomanButton();
        Assert.assertEquals(textWomen, womenButton.getTextWomen());
    }
}
