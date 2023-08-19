package Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Form_submitForm_action_request")
    private WebElement submitForm;
    @FindBy(xpath = "//h1[contains(text(),'Revolutionize Your Human Resource Management Exper')]")
    private WebElement getText;
    @FindBy(css = "div[class='d-flex web-menu-btn'] ")
    private WebElement buttonFreeDemo;
    @FindBy(css = "div[class='demo-page-slider-content'] h1")
    private WebElement getTextFreeDemoPage;


    public HomePage freeButtonSubmit() {
        submitForm.click();
        return this;
    }

    public String getTextFree() {
        return getText.getText();
    }

    public HomePage bookFreeDemoButtonClick() {
        buttonFreeDemo.click();
        return this;
    }

    public String getTextFreeDemoPage(){

        return getTextFreeDemoPage.getText();
    }




}

