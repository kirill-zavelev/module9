package com.epam.webdriver.page.auth;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.page.AbstractPage;
import com.epam.webdriver.utils.JsOperations;
import com.epam.webdriver.utils.PropertyLoader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    private static final String BASE_URL = PropertyLoader.loadProperty("base.url");

    @FindBy(id = "passp-field-login")
    private WebElement userName;

    @FindBy(id = "passp-field-passwd")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitLoginBtn;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitPasswordBtn;

    @FindBy(className = "passp-footer")
    private WebElement footer;

    public LoginPage setUserName(String username) {
        userName.sendKeys(username);
        JsOperations.highLightText(userName);

        return this;
    }

    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.visibilityOf(footer));
        submitLoginBtn.click();

        return this;
    }

    public LoginPage setPassword(String password) {
        waitForElementToBeClickable(this.password);
        this.password.sendKeys(password);

        return this;
    }

    public LoginPage clickPassword() {
        submitPasswordBtn.click();

        return this;
    }

    public StartPage login(String username, String password) {
        setUserName(username);
        clickLogin();
        setPassword(password);
        clickPassword();

        return new StartPage();
    }

    public boolean isPasswordInputDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(password)).isDisplayed();
    }

    public LoginPage openBasePage() {
        driver.get(BASE_URL);

        return this;
    }
}
