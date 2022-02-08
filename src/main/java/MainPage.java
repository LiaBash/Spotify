import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends TestBase{

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@class=\"Qt5xfSWikz6CLU8Vobxs jzic9t5dn38QUOYlDka0\"]")
    private WebElement loginButton;

    @Step("open")
    public MainPage open() {
        driver.get(PropertyReader.baseUrl);
        return this;
    }

    @Step("clickLoginButton")
    public MainPage clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;

    }


}
