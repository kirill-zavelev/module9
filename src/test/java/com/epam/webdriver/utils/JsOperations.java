package com.epam.webdriver.utils;

import com.epam.webdriver.decorator.DriverDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsOperations {

    private final WebDriver driver;

    public JsOperations(DriverDecorator driver) {
        this.driver = driver.getWebDriver();
    }

    public void highLightText(WebElement element) {
        ((JavascriptExecutor) driver).executeScript
                ("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
