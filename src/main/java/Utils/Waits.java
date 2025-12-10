package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {

    private Waits()
    {

    }

    public static WebElement waitForElementPresent(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Logs.info("wait for element to be present",locator.toString());
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementVisible(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = waitForElementPresent(driver,locator);
        Logs.info("wait for element to be visible",locator.toString());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementClickable(WebDriver driver, By locator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = waitForElementVisible(driver, locator);
        Logs.info("wait for element to be clickable",locator.toString());
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
