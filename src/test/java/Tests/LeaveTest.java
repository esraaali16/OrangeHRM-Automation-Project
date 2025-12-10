package Tests;

import Drivers.DriverManager;
import Listeners.TestNGListeners;
import Pages.LeavePage;
import Pages.LoginPage;
import Utils.BrowserActions;
import Utils.JsonUtils;
import Utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestNGListeners.class)
public class LeaveTest {

    private WebDriver driver;
    LoginPage loginPage;
    LeavePage leavePage;
    JsonUtils testData;


    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        leavePage = new LeavePage(driver);
    }

    @Test
    public void searchLeave() throws InterruptedException {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        leavePage.clickOnLeaveButton()
                 .selectShowLeaveWithStatus()
                 .selectLeaveType()
                 .enterEmployeeName(testData.getJsonData("leaveData.employeeName"))
                 .selectEmployeeName()
                 .selectSubUnit()
                 .clickOnSearchButton();
        Assert.assertTrue(leavePage.getTextOfSearchMessage().contains(testData.getJsonData("leaveData.searchMessage")));

    }

    @AfterClass
    public void terDown()
    {
        driver.quit();
    }

}
