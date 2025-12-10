package Drivers;

import Utils.Logs;
import Utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.fail;

public class DriverManager {
    private static WebDriver driver;

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
        super();
    }

    @Step("Create driver on: {browserName}")
    public static WebDriver createDriver(String browserName) {
        WebDriver driver = BrowserFactory.getBrowser(browserName);
        Logs.info("Driver created on : ", PropertiesUtils.getPropertyValue(browserName));
        setDriver(driver);
        return getDriver();
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            Logs.error("Driver is null");
            fail("Driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver)
    {
        driverThreadLocal.set(driver);
    }
}



