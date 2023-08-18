package Page;
import Page.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "Form_submitForm_action_request")
    private WebElement submitForm;

    @FindBy(xpath = "//h1[contains(text(),'Revolutionize Your Human Resource Management Exper')]")
    private WebElement getText;

    public void freeButtonSubmit (){
        submitForm.click();
    }

    public String  getTextFree() {return getText.getText();}

}

