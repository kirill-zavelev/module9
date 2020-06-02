package com.epam.webdriver.cucumber.driver;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {

    private static final int TIME_OUT_IN_SECONDS = 10;

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static void setUpDriver() {
        WebDriver driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        webDriverThreadLocal.set(driver);
    }

    public static WebDriver getDriver() {
        return webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        DriverSingleton.closeDriver();
    }
}
