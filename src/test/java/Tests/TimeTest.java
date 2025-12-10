package Tests;

import Drivers.DriverManager;
import Pages.LoginPage;
import Pages.TimePage;
import Utils.BrowserActions;
import Utils.JsonUtils;
import Utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import Listeners.TestNGListeners;
import org.testng.annotations.Test;


@Listeners(TestNGListeners.class)
public class TimeTest {

    private WebDriver driver;
    JsonUtils testData;
    LoginPage loginPage;
    TimePage timePage;

    @BeforeClass
    private void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        timePage = new TimePage(driver);
    }

    @Test
    public void checkIn()
    {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        timePage.clickOnTimeButton()
                .clickOnAttendanceDropDown()
                .clickOnPunchInOut()
                .clickOnInButton();
        Assert.assertTrue(timePage.getTextOfSuccessMessage().contains(testData.getJsonData("timeData.successMessage")));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
