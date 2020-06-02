package com.epam.webdriver.page;

import com.epam.webdriver.cucumber.driver.DriverManager;
import com.epam.webdriver.decorator.DriverDecorator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    private static final int TIME_OUT_IN_SECONDS = 10;

    protected final DriverManager driver;
    protected final WebDriverWait wait;

    protected AbstractPage() {
        this.driver = driver;
        this.wait = new WebDriverWait(driver.getDriver(), TIME_OUT_IN_SECONDS);
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickElementWhenItDisplayed(List<WebElement> elements) {

        try {
            elements.forEach(button -> {
                if (button.isDisplayed()) {
                    button.click();
                }
            });
        } catch (StaleElementReferenceException sere) {
            clickElementWhenItDisplayed(elements);
        }

    }

    protected void sendKeysWhenInputIntractable(WebElement element, String text) {
        if (element.isDisplayed()) {
            element.clear();
            element.sendKeys(text);
        }
    }

    public void callContextMenu(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
}