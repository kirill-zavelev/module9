package com.epam.webdriver.utils;

import com.epam.webdriver.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenShotCreator {

    private Logger logger = LogManager.getLogger("logger");

    public void saveScreenshot() {

        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver()
                .getWebDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + DateUtils.getCurrentTimeAsString() +
                            ".png"));
        }
        catch (IOException ioe) {
            logger.error("Failed to save screenshot: " + ioe.getLocalizedMessage());
        }
    }
}
