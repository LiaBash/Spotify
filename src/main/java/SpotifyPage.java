import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class SpotifyPage extends TestBase{
    private WebDriver driver;

    public SpotifyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class=\"odcjv30UQnjaTv4sylc0\"]")
    private WebElement userName;
    @FindBy(xpath = "//span[contains(@class, 'ellipsis-one-line')][contains(text(), 'Аккаунт')]")
    private WebElement accountButton;
    @FindBy(xpath = "//button[@class=\"onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon\"]")
    private WebElement cookieButton;


    @Step("clickCookieButton")
    public SpotifyPage clickCookieButton() throws Exception{
        try{
        cookieButton.click();}catch (Exception e){
            System.out.println("no message");
        }
        return this;
    }

    @Step("clickUserName")
    public SpotifyPage clickUserName() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.click();
        return this;
    }

    @Step("clickAccountButton")
    public SpotifyPage clickAccountButton(int index) {
        accountButton.click();
        ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        return this;
    }

}
