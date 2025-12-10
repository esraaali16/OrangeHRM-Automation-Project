package Pages;

import Utils.BrowserActions;
import Utils.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final By userNameTextBox = By.name("username");
    private final By passwordTextBox = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    @Step("Navigate to the login page")
    public LoginPage navigateToURL(String URL)
    {
        BrowserActions.navigateToURL(driver, URL);
        return this;
    }

    @Step("Enter Username: {username}")
    public LoginPage enterUserName(String username)
    {
        ElementActions.sendKeys(driver,userNameTextBox,username);
        return this;
    }

    @Step("Enter password: {password}")
    public LoginPage enterPassword(String password)
    {
        ElementActions.sendKeys(driver,passwordTextBox,password);
        return this;
    }

    @Step("Click on login button")
    public LoginPage clickOnLoginButton()
    {
       ElementActions.clickElement(driver,loginButton);
       return this;
    }
}
