package com.epam.webdriver.cucumber.hooks;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.utils.PropertyLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    private static final String BASE_URL = PropertyLoader.loadProperty("base.url");

    private DriverDecorator driver;

    @Before
    public void setUp() {
        driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

}
