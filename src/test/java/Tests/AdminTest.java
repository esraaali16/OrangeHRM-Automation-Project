package Tests;

import Drivers.DriverManager;
import Pages.AdminPage;
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
import Listeners.TestNGListeners;

@Listeners(TestNGListeners.class)
public class AdminTest  {

    private WebDriver driver;
    LoginPage loginPage;
    AdminPage adminPage;
    JsonUtils testData;

    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);
    }


    @Test
    public void addUser() throws InterruptedException {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        adminPage.clickOnAdminButton()
                 .clickOnAddButton()
                 .selectUserRole()
                 .enterEmployeeName(testData.getJsonData("admin-data.employeeName"))
                 .selectEmployeeName()
                 .selectStatus()
                 .enterUserName(testData.getJsonData("admin-data.userName"))
                 .enterPassword(testData.getJsonData("admin-data.password"))
                 .enterConfirmPassword(testData.getJsonData("admin-data.confirmPassword"))
                 .clickOnSaveButton();
        Assert.assertTrue(adminPage.getTextOfSuccessfulMessage().contains(testData.getJsonData("admin-data.successMessage")));
    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
