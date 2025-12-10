package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ADDPIMPage {

    private final WebDriver driver;
    private final By PIMButton = By.xpath("//span[text()='PIM']");
    private final By FirstNameTextBox = By.name("firstName");
    private final By MiddleNameTextBox = By.name("middleName");
    private final By LastNameTextBox = By.name("lastName");
    private final By EmployeeIdTextBox = By.xpath("//label[text()='Employee Id']/following::input[1]");
    private final By SaveButton = By.cssSelector("button[type='submit']");
    private final By SuccessfulAddPIMMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");



    public ADDPIMPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public PIMSearch clickOnPIMButton()
    {
        ElementActions.clickElement(driver,PIMButton);
        return new PIMSearch(driver);
    }

    public ADDPIMPage enterFirstName(String FirstName)
    {
        ElementActions.sendKeys(driver,FirstNameTextBox,FirstName);
        return this;
    }

    public ADDPIMPage enterMiddleName(String MiddleName)
    {
        ElementActions.sendKeys(driver,MiddleNameTextBox,MiddleName);
        return this;
    }

    public ADDPIMPage enterLastName(String LastName)
    {
        ElementActions.sendKeys(driver,LastNameTextBox,LastName);
        return this;
    }

    public ADDPIMPage enterEmployeeId(String EmployeeId)
    {
        ElementActions.clickElement(driver,EmployeeIdTextBox);
        ElementActions.sendKeys(driver,EmployeeIdTextBox,Keys.CONTROL + "a");
        driver.findElement(EmployeeIdTextBox).sendKeys(Keys.DELETE);
        ElementActions.sendKeys(driver,EmployeeIdTextBox,EmployeeId);
        return this;
    }

    public ADDPIMPage clickOnSaveButton()
    {
        ElementActions.clickElement(driver,SaveButton);
        return this;
    }

    public String assertEmployeeAddedSuccessfully()
    {
        return ElementActions.getText(driver,SuccessfulAddPIMMessage);
    }

}
