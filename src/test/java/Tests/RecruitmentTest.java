package Tests;

import Drivers.DriverManager;
import Pages.LoginPage;
import Pages.RecruitmentPage;
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
public class RecruitmentTest {

    private WebDriver driver;
    JsonUtils testData;
    LoginPage loginPage;
    RecruitmentPage recruitmentPage;

    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        recruitmentPage = new RecruitmentPage(driver);
    }

    @Test
    public void addCandidate()
    {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        recruitmentPage.clickOnRecruitmentButton()
                       .clickOnAddButton()
                       .enterFirstName(testData.getJsonData("recruitmentData.firstName"))
                       .enterMiddleName(testData.getJsonData("recruitmentData.middleName"))
                       .enterLastName(testData.getJsonData("recruitmentData.lastName"))
                       .selectVacancy()
                       .enterEmail(testData.getJsonData("recruitmentData.email"))
                       .enterContactNumber(testData.getJsonData("recruitmentData.contactNumber"))
                       .clickOnSaveButton();
        Assert.assertTrue(recruitmentPage.getTextOfSuccessfulMessage().contains(testData.getJsonData("recruitmentData.successMessage")));
    }

    @Test(dependsOnMethods = {"addCandidate"})
    public void searchCandidates() throws InterruptedException {
        recruitmentPage.clickOnRecruitmentButton()
                       .enterCandidateName(testData.getJsonData("recruitmentData.firstName"))
                       .selectCandidateName()
                       .clickOnSearchButton();
        Assert.assertTrue(recruitmentPage.getTextOfSearchResult().contains(testData.getJsonData("recruitmentData.firstName")));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
