package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class AdminPage {

    private final WebDriver driver;
    private final By AdminButtonClick = By.xpath("//span[text()='Admin']");
    private final By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By UserRoleDropDown = By.xpath("//label[text()='User Role']/following::div[@class='oxd-select-text-input'][1]");
    private final By UserRoleAdminOption = By.xpath("//div[@role='option']//span[text()='Admin']");
    private final By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By EmployeeNameOption = By.xpath("//*[contains(@class,'oxd-autocomplete-option')]");
    private final By StatusDropDown = By.xpath("//label[text()='Status']/following::div[contains(@class,'oxd-select-text')][1]");
    private final By StatusOption = By.xpath("//div[@role='option']//span[text()='Enabled']");
    private final By UserNameTextBox = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By PasswordTextBox = By.xpath("(//input[@type='password'])[1]");
    private final By ConfirmPasswordTextBox = By.xpath("(//input[@type='password'])[2]");
    private final By SaveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By SuccessfulAddMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");



    public AdminPage (WebDriver driver)
    {
        this.driver = driver;
    }

    public AdminPage clickOnAdminButton()
    {
        ElementActions.clickElement(driver,AdminButtonClick);
        return this;
    }

    public AdminPage clickOnAddButton()
    {
        ElementActions.clickElement(driver,AddButton);
        return this;
    }

    public AdminPage selectUserRole()
    {
        ElementActions.clickElement(driver,UserRoleDropDown);
        ElementActions.clickElement(driver,UserRoleAdminOption);
        return this;
    }

    public AdminPage enterEmployeeName(String data)
    {
        ElementActions.sendKeys(driver,EmployeeName,data);
        return this;
    }

    public AdminPage selectEmployeeName() throws InterruptedException {
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeNameOption));
        driver.findElement(EmployeeName).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(EmployeeName).sendKeys(Keys.ENTER);
        return this;
    }

    public AdminPage selectStatus()
    {
        ElementActions.clickElement(driver,StatusDropDown);
        ElementActions.clickElement(driver,StatusOption);
        return this;
    }

    public AdminPage enterUserName(String userName)
    {
        ElementActions.sendKeys(driver,UserNameTextBox,userName);
        return this;
    }

    public AdminPage enterPassword(String password)
    {
        ElementActions.sendKeys(driver,PasswordTextBox,password);
        return this;
    }

    public AdminPage enterConfirmPassword(String confirmPassword)
    {
        ElementActions.sendKeys(driver,ConfirmPasswordTextBox,confirmPassword);
        return this;
    }

    public AdminPage clickOnSaveButton()
    {
        ElementActions.clickElement(driver,SaveButton);
        return this;
    }


    public String getTextOfSuccessfulMessage()
    {
        return ElementActions.getText(driver,SuccessfulAddMessage);
    }

}
