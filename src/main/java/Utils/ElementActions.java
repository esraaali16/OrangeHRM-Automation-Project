package Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class ElementActions {


    private ElementActions()
    {

    }

    @Step("Sending data: {data} to the element {locator}")
    public static void sendKeys(WebDriver driver, By locator, String data)
    {
        Waits.waitForElementVisible(driver, locator);
        driver.findElement(locator).sendKeys(data);
        Logs.info("Data entered: ",data , "in the field", locator.toString());
    }

    @Step("Clicking on element: {locator}")
    public static void clickElement(WebDriver driver, By locator)
    {
        Waits.waitForElementClickable(driver, locator);
        driver.findElement(locator).click();
        Logs.info("Clicked on the element: ",locator.toString());
    }

    public static void  clearTextBox(WebDriver driver, By locator)
    {
        Waits.waitForElementClickable(driver, locator);
        driver.findElement(locator).clear();
        Logs.info("Clear text box: ",locator.toString());
    }

    @Step("Get text from the element:{locator}")
    public static String getText(WebDriver driver,By locator)
    {
        Waits.waitForElementVisible(driver, locator);
        Logs.info("Getting text from the element: ", locator.toString(),"Text: ",driver.findElement(locator).getText());
        return driver.findElement(locator).getText();
    }

    public static void Actions(WebDriver driver,By locator)
    {
        Waits.waitForElementClickable(driver,locator);
        Actions actions = new Actions(driver);
        actions.click().moveToElement(driver.findElement(locator)).click().build().perform();
    }

    public static List<WebElement> findElements(WebDriver driver, By locator)
    {
        Waits.waitForElementVisible(driver,locator);
        return driver.findElements(locator);
    }


}
