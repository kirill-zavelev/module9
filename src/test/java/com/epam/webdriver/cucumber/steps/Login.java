package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.base.BaseTest;
import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends BaseTest {

    @Before
    public void setUpBrowser() {
        driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);

        loginPage = new LoginPage(driver);
        quickActionsPanelPage = new QuickActionsPanelPage(driver);
    }

    @After
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }

    @When("^user enter username ([^\"]*)$")
    public void enterUserName(String username) {

    }

    @And("clicks login button")
    public void clickLogin() {
//        loginPage.login(USERNAME,)
    }

    @And("user enter password {string}")
    public void enterPassword(String arg0) {
    }

    @Then("user is on page with user's username {string} displayed")
    public void verifyUserName(String arg0) {
    }
}
