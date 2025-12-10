package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LeavePage {

    private final WebDriver driver;
    private final By LeaveButton = By.xpath("//span[text()='Leave']");
    private final By ShowLeaveWithStatus = By.xpath("//label[text()='Show Leave with Status']/following::div[@class='oxd-select-text oxd-select-text--active']");
    private final By LeaveOptions = By.xpath("//div[@role='option']//span[text()='Rejected']");
    private final By LeaveType = By.xpath("//label[text()='Leave Type']/following::div[@class='oxd-select-text oxd-select-text--active']");
    private final By LeaveTypeOption = By.xpath("//div[@role='option']//span[text()='CAN - Bereavement']");
    private final By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By EmployeeNameOption = By.xpath("//*[contains(@class,'oxd-autocomplete-option')]");
    private final By SubUnit = By.xpath("//label[text()='Sub Unit']/following::div[@class='oxd-select-text oxd-select-text--active']");
    private final By SunUnitOption = By.xpath("//div[@role='option']//span[text()='Administration']");
    private final By SearchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By SearchMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");


    public LeavePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LeavePage clickOnLeaveButton()
    {
        ElementActions.clickElement(driver,LeaveButton);
        return this;
    }

    public LeavePage selectShowLeaveWithStatus()
    {
        ElementActions.clickElement(driver,ShowLeaveWithStatus);
        ElementActions.clickElement(driver,LeaveOptions);
        return this;
    }

    public LeavePage selectLeaveType()
    {
        ElementActions.clickElement(driver,LeaveType);
        ElementActions.clickElement(driver,LeaveTypeOption);
        return this;
    }

    public LeavePage enterEmployeeName(String data)
    {
        ElementActions.sendKeys(driver,EmployeeName,data);
        return this;
    }

    public LeavePage selectEmployeeName() throws InterruptedException {
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeNameOption));
        driver.findElement(EmployeeName).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(EmployeeName).sendKeys(Keys.ENTER);
        return this;
    }

    public LeavePage selectSubUnit()
    {
        ElementActions.clickElement(driver,SubUnit);
        ElementActions.clickElement(driver,SunUnitOption);
        return this;
    }

    public LeavePage clickOnSearchButton()
    {
        ElementActions.clickElement(driver,SearchButton);
        return this;
    }

    public String getTextOfSearchMessage()
    {
        return ElementActions.getText(driver,SearchMessage);
    }
}
