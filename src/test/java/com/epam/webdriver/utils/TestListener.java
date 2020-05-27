package com.epam.webdriver.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger("logger");

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {
        ScreenShotCreator.saveScreenshot();
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {
        LOGGER.info("Test started");
    }

    public void onFinish(ITestContext context) {
        LOGGER.info("Test finished");
    }

    public void onTestFailure(ITestResult result) {
        ScreenShotCreator.saveScreenshot();
    }
}
