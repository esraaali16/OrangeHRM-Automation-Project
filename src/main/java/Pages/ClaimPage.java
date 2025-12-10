package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ClaimPage {

    private final WebDriver driver;
    private final By ClaimButton = By.xpath("//span[text()='Claim']");
    private final By AssignClaimButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By EmployeeNameOption = By.xpath("//*[contains(@class,'oxd-autocomplete-option')]");
    private final By EventDropDown = By.xpath("//label[text()='Event']/following::div[contains(@class,'oxd-select-text')]");
    private final By EventOption = By.xpath("//div[@role='option']//span[text()='Travel Allowance']");
    private final By CurrencyDropDown = By.xpath("//label[text()='Currency']/following::div[contains(@class,'oxd-select-text')]");
    private final By CurrencyOption = By.xpath("//div[@role='option']//span[text()='Egyptian Pound']");
    private final By CreateButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By SuccessfulAddMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");


    public ClaimPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public ClaimPage clickOnClaimButton()
    {
        ElementActions.clickElement(driver,ClaimButton);
        return this;
    }

    public ClaimPage clickOnAssignClaimButton()
    {
        ElementActions.clickElement(driver,AssignClaimButton);
        return this;
    }

    public ClaimPage enterEmployeeName(String employeeName)
    {
        ElementActions.sendKeys(driver,EmployeeName,employeeName);
        return this;
    }

    public ClaimPage selectEmployeeName() throws InterruptedException {
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeNameOption));
        driver.findElement(EmployeeName).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(EmployeeName).sendKeys(Keys.ENTER);
        return this;
    }

    public ClaimPage selectEvent()
    {
        ElementActions.clickElement(driver,EventDropDown);
        ElementActions.clickElement(driver,EventOption);
        return this;
    }

    public ClaimPage selectCurrency()
    {
        ElementActions.clickElement(driver,CurrencyDropDown);
        ElementActions.clickElement(driver,CurrencyOption);
        return this;
    }

    public ClaimPage clickOnCreateButton()
    {
        ElementActions.clickElement(driver,CreateButton);
        return this;
    }

    public String getTextOfSuccessfulMessage()
    {
        return ElementActions.getText(driver,SuccessfulAddMessage);
    }

}
