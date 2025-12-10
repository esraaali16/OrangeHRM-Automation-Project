package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimePage {

    private final WebDriver driver;
    private final By TimeButton = By.xpath("//span[text()='Time']");
    private final By AttendanceDropDown = By.xpath("(//li[@class='oxd-topbar-body-nav-tab --parent'])[1]");
    private final By PunchInOut = By.xpath("//a[text()='Punch In/Out']");
    private final By InButton = By.xpath("//button[normalize-space()='In']");
    private final By SuccessfulMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");


    public TimePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public TimePage clickOnTimeButton()
    {
        ElementActions.clickElement(driver,TimeButton);
        return this;
    }

    public TimePage clickOnAttendanceDropDown()
    {
        ElementActions.clickElement(driver,AttendanceDropDown);
        return this;
    }

    public TimePage clickOnPunchInOut()
    {
        ElementActions.clickElement(driver,PunchInOut);
        return this;
    }

    public TimePage clickOnInButton()
    {
        ElementActions.clickElement(driver,InButton);
        return this;
    }


    public String getTextOfSuccessMessage()
    {
        return ElementActions.getText(driver,SuccessfulMessage);
    }
}
