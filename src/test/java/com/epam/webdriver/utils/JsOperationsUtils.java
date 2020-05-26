package com.epam.webdriver.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JsOperationsUtils {

    public final JavascriptExecutor jsExecutor;

    public JsOperationsUtils(JavascriptExecutor jsExecutor) {
        this.jsExecutor = jsExecutor;
    }

    public void highLightText(WebElement element) {
        jsExecutor.executeScript
                ("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
}
