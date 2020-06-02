package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;

import com.epam.webdriver.page.auth.StartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login {

    private StartPage startPage;
    private LoginPage loginPage;
    private QuickActionsPanelPage quickActionsPanelPage;
    private DriverDecorator driver;

    @After
    protected void tearDownBrowser() {
        driver.quit();
        driver.close();
        driver = null;
    }

    @Before
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Given("user is on login page {string}")
    public void getBaseUrl(String baseUrl) {
        driver.get(baseUrl);
        loginPage = new LoginPage(driver);
    }

    @When("user enter username {string}")
    public void enterUserName(String username) {
        loginPage.setUserName(username);
    }

    @And("clicks login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @And("user enter password {string}")
    public void enterPassword(String password) {
        loginPage.setPassword(password);
    }

    @And("clicks on avatar")
    public void clickOnUsername() {
        startPage = new StartPage(driver);
        startPage.clickOnUsername();
    }

    @Then("user is on start page with user's username {string} displayed")
    public void verifyUserName(String username) {
        quickActionsPanelPage = new QuickActionsPanelPage(driver);
        String actualEmail = quickActionsPanelPage.getActualEmail();

        Assert.assertEquals(actualEmail, username, "Incorrect email is displayed.");
    }
}
