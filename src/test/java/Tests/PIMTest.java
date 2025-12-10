package Tests;

import Drivers.DriverManager;
import Pages.ADDPIMPage;
import Pages.LoginPage;
import Pages.PIMSearch;
import Utils.BrowserActions;
import Utils.JsonUtils;
import Utils.PropertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Listeners.TestNGListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestNGListeners.class)
public class PIMTest {

    private WebDriver driver;
    LoginPage loginPage;
    JsonUtils testData;
    ADDPIMPage addpimPage;
    PIMSearch pimSearch;

    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        addpimPage = new ADDPIMPage(driver);
        pimSearch = new PIMSearch(driver);
    }

    @Test
    public void addPIMUser()
    {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        addpimPage.clickOnPIMButton()
                   .clickOnAddButton()
                   .enterFirstName(testData.getJsonData("addEmployee.firstName"))
                   .enterMiddleName(testData.getJsonData("addEmployee.middleName"))
                   .enterLastName(testData.getJsonData("addEmployee.lastName"))
                   .enterEmployeeId(testData.getJsonData("addEmployee.employeeId"))
                   .clickOnSaveButton();
        Assert.assertTrue(addpimPage.assertEmployeeAddedSuccessfully().contains(testData.getJsonData("addEmployee.successMessage")));
    }


    @Test(dependsOnMethods = {"addPIMUser"})
    public void searchForEmployee()
    {
        pimSearch.clickOnPIMButton()
                 .enterEmployeeName(testData.getJsonData("addEmployee.firstName"))
                 .enterEmployeeID(testData.getJsonData("addEmployee.employeeId"))
                 .clickOnSearchButton();
        Assert.assertTrue(pimSearch.assertSearchResult().contains(testData.getJsonData("addEmployee.employeeIdResult")));
    }



    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
