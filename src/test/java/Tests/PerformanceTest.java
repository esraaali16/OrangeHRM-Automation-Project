package Tests;

import Drivers.DriverManager;
import Pages.LoginPage;
import Pages.PerformancePage;
import Pages.RecruitmentPage;
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
public class PerformanceTest {

    private WebDriver driver;
    JsonUtils testData;
    LoginPage loginPage;
    PerformancePage performancePage;


    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        performancePage = new PerformancePage(driver);
    }


    @Test
    public void addKPIS()
    {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        performancePage.clickOnPerformanceButton()
                       .clickOnConfigureDropDown()
                       .clickOnKPIS()
                       .clickOnAddButton()
                       .enterKeyPerformanceIndicator(testData.getJsonData("performanceData.keyPerformance"))
                       .selectOnJobTitleDropDown()
                       .enterMinimumRating(testData.getJsonData("performanceData.minimumRating"))
                       .clickOnSaveButton();
        Assert.assertTrue(performancePage.getTextOfSuccessfulMessage().contains(testData.getJsonData("performanceData.successMessage")));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
