package Tests;

import Drivers.DriverManager;
import Pages.BuzzPage;
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
public class BuzzTest {

    private WebDriver driver;
    JsonUtils testData;
    LoginPage loginPage;
    BuzzPage buzzPage;

    @BeforeClass
    public void setup()
    {
        testData = new JsonUtils("testData");
        String browserName = PropertiesUtils.getPropertyValue("browserType");
        driver = DriverManager.createDriver(browserName);
        loginPage = new LoginPage(driver);
        buzzPage = new BuzzPage(driver);
    }

    @Test
    public void postPost()
    {
        loginPage.navigateToURL(PropertiesUtils.getPropertyValue("baseURL"))
                .enterUserName(testData.getJsonData("login-data.username"))
                .enterPassword(testData.getJsonData("login-data.password"))
                .clickOnLoginButton();
        Assert.assertEquals(BrowserActions.getCurrentURL(driver),PropertiesUtils.getPropertyValue("homeURL"));

        buzzPage.clickOnBuzzButton()
                .writePost(testData.getJsonData("buzzData.post"))
                .clickOnPostButton();
        Assert.assertTrue(buzzPage.getTextOfSuccessfulMessage().contains(testData.getJsonData("buzzData.successMessage")));
    }

    @Test(dependsOnMethods = {"postPost"})
    public void likePost()
    {
        buzzPage.clickOnLikeIcon();
        Assert.assertTrue(buzzPage.getTextOfLikeCount().contains(testData.getJsonData("buzzData.likeCount")));
    }

    @Test(dependsOnMethods = {"postPost"})
    public void writeComment()
    {
        buzzPage.clickOnCommentIcon()
                .writeComment(testData.getJsonData("buzzData.comment"));
        Assert.assertTrue(buzzPage.getTextOfSuccessfulMessage().contains(testData.getJsonData("buzzData.successMessage")));
    }

   @Test(dependsOnMethods = {"postPost"})
   public void deletePost()
   {
       buzzPage.clickOnPostSetting()
               .clickOnDeletePost()
               .clickOnYesButton();
       Assert.assertTrue(buzzPage.getTextOfDeletedMessage().contains(testData.getJsonData("buzzData.deletedMessage")));

   }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
