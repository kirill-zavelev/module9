package com.epam.webdriver.cucumber;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    @Before
    public void setupDriver() {
        DriverSingleton.getDriver();
    }

    @After
    public void quitDriver() {
        DriverSingleton.closeDriver();
    }

}
