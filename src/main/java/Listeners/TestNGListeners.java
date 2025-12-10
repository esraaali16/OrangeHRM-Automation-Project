package Listeners;

import Utils.Logs;
import Utils.ScreenShotsUtils;
import org.apache.commons.io.FileUtils;
import org.testng.*;

import java.io.File;


import static Utils.PropertiesUtils.loadProperties;

public class TestNGListeners implements IExecutionListener, ITestListener, IInvokedMethodListener
{
    File allureResult = new File("test-outputs/allure-results");
    File logs = new File("test-outputs/Logs");
    File screenshots = new File("test-outputs/Screenshots");

    @Override
    public void onExecutionStart()
    {
        Logs.info("Test Execution Started");
        loadProperties();
        try {
            FileUtils.cleanDirectory(allureResult);
            FileUtils.cleanDirectory(logs);
            FileUtils.cleanDirectory(screenshots);
        } catch (Exception exception) {
            Logs.error(exception.getMessage());
        }
    }

    @Override
    public void onExecutionFinish()
    {
        Logs.info("Test Execution Finished");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
       Logs.info("Test case" +  result.getName() +  "passed");
        ScreenShotsUtils.takeScreenShots("passed-" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        Logs.info("Test case" +  result.getName() +  "failed");
        ScreenShotsUtils.takeScreenShots("failed-" + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        Logs.info("Test case" +  result.getName() +  "skipped");
        ScreenShotsUtils.takeScreenShots("skipped-" + result.getMethod().getMethodName());
    }
}
