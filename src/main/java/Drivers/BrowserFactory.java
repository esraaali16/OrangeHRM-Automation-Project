package Drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;


public class BrowserFactory {

    public static WebDriver getBrowser(String browserName)
    {
        switch (browserName.toLowerCase())
        {
            case "edge":
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--remote-allow-origin=*");
                Map<String, Object> prefs = new HashMap<>();
                      prefs.put("profile.default_content_setting_values.notifications",false);
                      prefs.put("credentials_enable_service",false);
                      prefs.put("profile.password_manager_enabled",false);
                      prefs.put("autofill.profile_enabled",false);
                      options.setExperimentalOption("prefs",prefs);
                      options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new EdgeDriver(options);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--disable-infobars");
                firefoxOptions.addArguments("--disable-extensions");
                firefoxOptions.addArguments("--remote-allow-origin=*");
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new FirefoxDriver(firefoxOptions);
            default:
                ChromeOptions ChromeOptions = new ChromeOptions();
                ChromeOptions.addArguments("--start-maximized");
                ChromeOptions.addArguments("--disable-notifications");
                ChromeOptions.addArguments("--disable-infobars");
                ChromeOptions.addArguments("--disable-extensions");
                ChromeOptions.addArguments("--remote-allow-origin=*");
                Map<String, Object> ChromePrefs = new HashMap<>();
                ChromePrefs.put("profile.default_content_setting_values.notifications",false);
                ChromePrefs.put("credentials_enable_service",false);
                ChromePrefs.put("profile.password_manager_enabled",false);
                ChromePrefs.put("autofill.profile_enabled",false);
                ChromeOptions.setExperimentalOption("prefs",ChromePrefs);
                ChromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                return new ChromeDriver(ChromeOptions);
        }
    }
}
