package Tests;

import Drivers.DriverManager;
import Pages.ClaimPage;
import Pages.LoginPage;
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
public class ClaimTest {

    private WebDriver driver;
    JsonUtils testData;
    LoginPage loginPage;
    ClaimPage claimPage;

    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        claimPage = new ClaimPage(driver);
    }

    @Test
    public void assignClaim() throws InterruptedException {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        claimPage.clickOnClaimButton()
                 .clickOnAssignClaimButton()
                 .enterEmployeeName(testData.getJsonData("claimData.employeeName"))
                 .selectEmployeeName()
                 .selectEvent()
                 .selectCurrency()
                 .clickOnCreateButton();
        Assert.assertTrue(claimPage.getTextOfSuccessfulMessage().contains(testData.getJsonData("claimDate.successMessage")));
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
