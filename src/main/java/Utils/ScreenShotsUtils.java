package Utils;

import Drivers.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;


public class ScreenShotsUtils {

    public static final String SCREENSHOTS_PATH = "test-outputs/Screenshots/";
    public ScreenShotsUtils()
    {
        super();
    }


    public static void takeScreenShots(String ScreenShotName) {
        try {
            File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenshotFile = new File(SCREENSHOTS_PATH + ScreenShotName + ".png");
            FileUtils.copyFile(screenshot,screenshotFile);
        } catch (Exception e) {
            Logs.error("Failed to take Screenshots:" + e.getMessage());
        }

    }
}
