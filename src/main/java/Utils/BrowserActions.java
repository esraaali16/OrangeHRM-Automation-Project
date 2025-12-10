package Utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class BrowserActions {


    private BrowserActions()
    {

    }

    @Step("Navigate to URL: {url}")
    public static void navigateToURL(WebDriver driver, String url)
    {
        driver.get(url);
        Logs.info("Navigated to url", url);
    }

    @Step("Getting current URL")
    public static String getCurrentURL(WebDriver driver)
    {
        Logs.info("Current url: ", driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step("Getting page title")
    public static String getPageTitle(WebDriver driver)
    {
        Logs.info("Page title: ", driver.getTitle());
        return driver.getTitle();
    }
}
