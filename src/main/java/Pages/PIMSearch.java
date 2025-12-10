package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMSearch {

    private final WebDriver driver;
    private final By PIMButton = By.xpath("//span[text()='PIM']");
    private final By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By EmployeeName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By EmployeeIdTextBox = By.xpath("(//input[@class='oxd-input oxd-input--active'])[1]");
    private final By SearchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By EmployeeIdResult = By.xpath("//div[contains(text(),'EMP123')]");


    public PIMSearch(WebDriver driver)
    {
        this.driver = driver;
    }

    public PIMSearch clickOnPIMButton()
    {
        ElementActions.clickElement(driver,PIMButton);
        return this;
    }

    public ADDPIMPage clickOnAddButton()
    {
        ElementActions.clickElement(driver,AddButton);
        return new ADDPIMPage(driver);
    }

    public PIMSearch enterEmployeeName(String employeeName)
    {
        ElementActions.sendKeys(driver,EmployeeName,employeeName);
        return this;
    }

    public PIMSearch enterEmployeeID(String EmployeeId)
    {

        ElementActions.sendKeys(driver,EmployeeIdTextBox,EmployeeId);
        return this;
    }

    public PIMSearch clickOnSearchButton()
    {
        ElementActions.clickElement(driver,SearchButton);
        return this;
    }

    public String assertSearchResult()
    {
        return ElementActions.getText(driver,EmployeeIdResult);
    }

}
