package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformancePage {


    private final WebDriver driver;
    private final By PerformanceButton = By.xpath("//span[text()='Performance']");
    private final By ConfigureDropDown = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent']");
    private final By KPIS = By.xpath("//a[text()='KPIs']");
    private final By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By KeyPerformanceIndicator = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By JobTitleDropDown = By.xpath("//label[text()='Job Title']/following::div[@class='oxd-select-text oxd-select-text--active']");
    private final By JobTitleOption = By.xpath("//div[@role='option']//span[text()='QA Engineer']");
    private final By MinimumRating = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By SaveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By SuccessfulAddMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");

    public PerformancePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public PerformancePage clickOnPerformanceButton()
    {
        ElementActions.clickElement(driver,PerformanceButton);
        return this;
    }

    public PerformancePage clickOnConfigureDropDown()
    {
        ElementActions.clickElement(driver,ConfigureDropDown);
        return this;
    }

    public PerformancePage clickOnKPIS()
    {
        ElementActions.clickElement(driver,KPIS);
        return this;
    }

    public PerformancePage clickOnAddButton()
    {
        ElementActions.clickElement(driver,AddButton);
        return this;
    }

    public PerformancePage enterKeyPerformanceIndicator(String KeyPerformance)
    {
        ElementActions.sendKeys(driver,KeyPerformanceIndicator,KeyPerformance);
        return this;
    }

    public PerformancePage selectOnJobTitleDropDown()
    {
        ElementActions.clickElement(driver,JobTitleDropDown);
        ElementActions.clickElement(driver,JobTitleOption);
        return this;
    }

    public PerformancePage enterMinimumRating(String minRating)
    {
        ElementActions.clickElement(driver,MinimumRating);
        ElementActions.clearTextBox(driver,MinimumRating);
        ElementActions.sendKeys(driver,MinimumRating,minRating);
        return this;
    }


    public PerformancePage clickOnSaveButton()
    {
        ElementActions.clickElement(driver,SaveButton);
        return this;
    }

    public String getTextOfSuccessfulMessage()
    {
        return ElementActions.getText(driver,SuccessfulAddMessage);
    }
}
