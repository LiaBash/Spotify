import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends TestBase{
    private final WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-username")
    private WebElement emailInput;
    @FindBy(id = "login-password")
    private WebElement passwordInput;
    @FindBy(xpath = "//p[@class=\"Type__TypeElement-goli3j-0 VNztd sc-furwcr jOnzgW\"]")
    private WebElement rememberButton;
    @FindBy(xpath = "//p[@class=\"Type__TypeElement-goli3j-0 dmuHFl sc-dkPtRN giKhHg\"]")
    private WebElement inButton;
    @FindBy(xpath = "//p[@class='Type__TypeElement-goli3j-0 craHza sc-fotOHu gGrrEB']")
    private WebElement badAuthMessage;


    @Step("refreshPage")
    public SignInPage refreshPage(){
       driver.navigate().refresh();
       return this;
    }

    @Step("setCreds")
    public SignInPage setCreds(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("rememberMe")
    public SignInPage rememberMe() {
        rememberButton.click();
        return this;
    }

    @Step("clickIn")
    public SignInPage clickIn() {
        inButton.click();
        return this;
    }
}
