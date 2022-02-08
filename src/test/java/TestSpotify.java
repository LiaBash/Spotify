import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestSpotify extends TestBase {

    public final String ERROR_MESSAGE_XPATH = "//p[@class='Type__TypeElement-goli3j-0 craHza sc-fotOHu gGrrEB']";
    public final String ERROR_MESSAGE2_XPATH = "//div[@class='Wrapper-sc-62m9tu-0 dupjdh encore-negative-set']";

    @Test
    public void test() throws Exception {
        mainPage
                .open()
                .clickLoginButton();
        signInPage
                .setCreds(PropertyReader.login, PropertyReader.password)
                .rememberMe()
                .clickIn();
        spotifyPage
                .clickCookieButton()
                .clickUserName()
                .clickAccountButton(1);
        accountPage
                .clickPasswordChanges()
                .setPasswordChanges(PropertyReader.password, PropertyReader.newPassword, PropertyReader.newPassword)
                .clickChangePasswordButton()
                .clickEsc();
        mainPage
                .open()
                .clickLoginButton();
        signInPage
                .setCreds(PropertyReader.login, PropertyReader.password)
                .rememberMe()
                .clickIn();

        //  Assert.assertEquals(signInPage.getMessageElement(),MESSAGE);
        Assert.assertTrue(driver.findElement(By.xpath(ERROR_MESSAGE_XPATH)).isDisplayed());

        signInPage
                .refreshPage()
                .setCreds(PropertyReader.login, PropertyReader.newPassword)
                .rememberMe()
                .clickIn();
        spotifyPage
                .clickCookieButton()
                .clickUserName()
                .clickAccountButton(2);
        accountPage
                .clickPasswordChanges()
                .setPasswordChanges(PropertyReader.newPassword, PropertyReader.password, PropertyReader.password);

        Assert.assertFalse(driver.findElement(By.xpath(ERROR_MESSAGE2_XPATH)).isDisplayed());

        accountPage.clickChangePasswordButton()
                .clickEsc();
    }
}
