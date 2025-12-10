package Pages;

import Utils.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecruitmentPage {

    private final WebDriver driver;
    private final By RecruitmentButton = By.xpath("//span[text()='Recruitment']");
    private final By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By FirstName = By.name("firstName");
    private final By MiddleName = By.name("middleName");
    private final By LastName = By.name("lastName");
    private final By VacancyDropDown = By.xpath("//label[text()='Vacancy']/following::div[@class='oxd-select-text-input'][1]");
    private final By VacancyOption = By.xpath("//div[@role='option']//span[text()='Software Engineer']");
    private final By EmailTextBox = By.xpath("//input[@placeholder='Type here']");
    private final By ContactNumber = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By SaveButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By SuccessfulAddMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");

    private final By CandidateName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By CandidateNameOption = By.xpath("//*[contains(@class,'oxd-autocomplete-option')]");
    private final By SearchButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");
    private final By SearchResult = By.xpath("//div[@class='oxd-table-card']//div[@role='row']");




    public RecruitmentPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public RecruitmentPage clickOnRecruitmentButton()
    {
        ElementActions.clickElement(driver,RecruitmentButton);
        return this;
    }

    public RecruitmentPage clickOnAddButton()
    {
        ElementActions.clickElement(driver,AddButton);
        return this;
    }

    public RecruitmentPage enterFirstName(String firstName)
    {
        ElementActions.sendKeys(driver,FirstName,firstName);
        return this;
    }

    public RecruitmentPage enterMiddleName(String middleName)
    {
        ElementActions.sendKeys(driver,MiddleName,middleName);
        return this;
    }

    public RecruitmentPage enterLastName(String lastName)
    {
        ElementActions.sendKeys(driver,LastName,lastName);
        return this;
    }

    public RecruitmentPage selectVacancy()
    {
        ElementActions.clickElement(driver,VacancyDropDown);
        ElementActions.clickElement(driver,VacancyOption);
        return this;
    }

    public RecruitmentPage enterEmail(String email)
    {
        ElementActions.sendKeys(driver,EmailTextBox,email);
        return this;
    }

    public RecruitmentPage enterContactNumber(String contactNumber)
    {
        ElementActions.sendKeys(driver,ContactNumber,contactNumber);
        return this;
    }

    public RecruitmentPage clickOnSaveButton()
    {
        ElementActions.clickElement(driver,SaveButton);
        return this;
    }

    public String getTextOfSuccessfulMessage()
    {
        return ElementActions.getText(driver,SuccessfulAddMessage);
    }

    public RecruitmentPage enterCandidateName(String candidateName)
    {
        ElementActions.sendKeys(driver,CandidateName,candidateName);
        return this;
    }

    public RecruitmentPage selectCandidateName() throws InterruptedException {
        Thread.sleep(1500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CandidateNameOption));
        driver.findElement(CandidateName).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(CandidateName).sendKeys(Keys.ENTER);
        return this;
    }

    public RecruitmentPage clickOnSearchButton()
    {
        ElementActions.clickElement(driver,SearchButton);
        return this;
    }

    public String getTextOfSearchResult()
    {
        return ElementActions.getText(driver,SearchResult);
    }
}
