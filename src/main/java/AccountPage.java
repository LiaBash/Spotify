import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends TestBase {
    private final WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href=\"/ru-ru/account/change-password/\"]")
    private WebElement passwordChanges;
    @FindBy(id = "old_password")
    private WebElement oldPasswordField;
    @FindBy(id = "new_password")
    private WebElement newPasswordField;
    @FindBy(id = "new_password_confirmation")
    private WebElement secondNewPasswordField;
    @FindBy(xpath = "//div[@class=\"ButtonLegacy__ButtonLegacyInner-o653de-0 fCIVwR encore-bright-accent-set\"]")
    private WebElement changePasswordButton;
    @FindBy(xpath = "//span[@class=\"svelte-kdyqkb\"]")
    private WebElement profileButton;
    @FindBy(xpath = "//a[@class=\"mh-subtle svelte-11h1c9\"]")
    private WebElement escButton;

    @Step("clickPasswordChanges")
    public AccountPage clickPasswordChanges(){
        passwordChanges.click();
        return this;
    }

    @Step("setPasswordChanges")
    public AccountPage setPasswordChanges(String oldPassword, String newPassword, String secondNewPassword){
        oldPasswordField.sendKeys(oldPassword);
        newPasswordField.sendKeys(newPassword);
        secondNewPasswordField.sendKeys(secondNewPassword);
        return this;
    }

    @Step("clickChangePasswordButton")
    public AccountPage clickChangePasswordButton(){
        changePasswordButton.click();
        return this;
    }

    @Step("clickEsc")
    public AccountPage clickEsc(){
        profileButton.click();
        escButton.click();
        return this;
    }
}
