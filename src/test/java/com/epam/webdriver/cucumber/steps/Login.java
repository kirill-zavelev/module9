package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.auth.StartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Login {

    private StartPage startPage = new StartPage();
    private LoginPage loginPage = new LoginPage();
    private QuickActionsPanelPage quickActionsPanelPage = new QuickActionsPanelPage();

    @Given("user is on login page")
    public void getBaseUrl() {
        loginPage.openBasePage();
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
        startPage.clickOnUsername();
    }

    @Then("user is on start page with user's username {string} displayed")
    public void verifyUserName(String username) {
        String actualEmail = quickActionsPanelPage.getActualEmail();

        Assert.assertEquals(actualEmail, username, "Incorrect email is displayed.");
    }
}
