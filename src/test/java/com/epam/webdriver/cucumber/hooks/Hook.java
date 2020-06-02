package com.epam.webdriver.cucumber.hooks;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.utils.PropertyLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook extends BaseHook {

    private static final String BASE_URL = PropertyLoader.loadProperty("base.url");

    private BaseHook baseHook;

    public Hook() {
    }

    public Hook(BaseHook baseHook) {
        this.baseHook = baseHook;
    }

    @Before
    public void setUp() {
        baseHook.driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);
    }

    @After
    public void tearDown() {
        DriverSingleton.closeDriver();
    }

}
