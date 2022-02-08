import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;
    public MainPage mainPage;
    public SignInPage signInPage;
    public SpotifyPage spotifyPage;
    public AccountPage accountPage;
    public PropertyReader propertyReader;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        signInPage = new SignInPage(driver);
        spotifyPage = new SpotifyPage(driver);
        accountPage = new AccountPage(driver);
        propertyReader = new PropertyReader();
        }

        @After
    public void quit() {
        driver.quit();
    }
}
