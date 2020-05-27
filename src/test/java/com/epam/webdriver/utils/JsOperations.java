package com.epam.webdriver.utils;

import com.epam.webdriver.driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsOperations {

    private static final WebDriver DRIVER = DriverSingleton.getDriver().getWebDriver();

    public static void highLightText(WebElement element) {
        ((JavascriptExecutor) DRIVER).executeScript
                ("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
