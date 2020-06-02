package com.epam.webdriver.cucumber.hooks;

import com.epam.webdriver.base.BaseTest;
import com.epam.webdriver.cucumber.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class DriverHooks {

    @Before
    public void setupDriver() {
        DriverManager.setUpDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
