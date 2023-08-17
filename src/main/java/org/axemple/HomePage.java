package org.axemple;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private static final String tShirt = "T-shirt";

    @FindBy(id = "search_query_top")
    private WebElement searchHomePage;

    @FindBy(name = "submit_search")
    private WebElement buttonSubmit;

    @FindBy(css = "h5[itemprop='name'] a[title='Faded Short Sleeve T-shirts']")
    private WebElement firstTShirtSell;

    @FindBy(css = "a[title='Women']")
    private WebElement womanButton;

    @FindBy(xpath = "//a[@title='Women']")
    private WebElement textWoman;

    public HomePage search(){
        searchHomePage.click();
        return this;
    }

    public HomePage writeTextTShirt(){
        searchHomePage.sendKeys(tShirt);
        return this;
    }

    public HomePage submit(){
        buttonSubmit.click();
        return this;
    }

    public String firstSellWithTShirt(){
        return firstTShirtSell.getText();
    }

    public HomePage submitWomanButton(){
        womanButton.click();
        return this;
    }

    public String  getTextWomen() {return textWoman.getText();}
}

