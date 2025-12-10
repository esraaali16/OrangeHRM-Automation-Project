package Tests;


import Drivers.DriverManager;
import Pages.LoginPage;
import Utils.BrowserActions;
import Utils.JsonUtils;
import Utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import Listeners.TestNGListeners;


@Listeners(TestNGListeners.class)
public class LoginTest {

    private WebDriver driver;
    LoginPage loginPage;
    JsonUtils testData;

    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(DriverManager.getDriver());
    }

    @Test
    public void successfulLogin()
    {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                 .enterUserName(testData.getJsonData("login-data.username"))
                 .enterPassword(testData.getJsonData("login-data.password"))
                 .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
