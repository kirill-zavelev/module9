package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.factory.EmailFactory;
import com.epam.webdriver.factory.EmailType;
import com.epam.webdriver.model.Email;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.DraftPage;
import com.epam.webdriver.page.mailfolders.InboxPage;
import com.epam.webdriver.utils.PropertyLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendEmail {

    private static final Email expectedEmail = new EmailFactory().getEmail(EmailType.WITH_EMPTY_SUBJECT);

    private static final String USERNAME = PropertyLoader.loadProperty("user.name");
    private static final String PASSWORD = PropertyLoader.loadProperty("user.password");
    private static final String BASE_URL = PropertyLoader.loadProperty("base.url");

    private LoginPage loginPage;
    private QuickActionsPanelPage quickActionsPanelPage;
    private InboxPage inboxPage;
    private MailCreationPage mailCreationPage;

    private DriverDecorator driver;

    @Before
    public void setUpBrowser() {
        driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);

        loginPage = new LoginPage(driver);
        mailCreationPage = new MailCreationPage(driver);
        inboxPage = new InboxPage(driver);
        quickActionsPanelPage = loginPage.login(USERNAME, PASSWORD).clickOnUsername();
    }

    @After
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }

    @When("the user clicks on mail box")
    public void clickOnMailBox() {
        quickActionsPanelPage.openMailBox();
    }

    @And("the user opens mail creation form")
    public void openMailCreationForm() {
        inboxPage.openMailCreationForm();
    }

    @And("the user filling recipient, subject and body email fields")
    public void fillEmailFields() {
        mailCreationPage.fillEmail(expectedEmail);
    }

    @And("the user clicks send button")
    public void clickCloseButton() {
        mailCreationPage.sendMailAsDraft();
    }

    @And("the user clicks on Send item")
    public void clickDraftsFolder() {
        inboxPage.openDraftsFolder();
    }

    @Then("email with correct data exists in Send folder")
    public void createdEmailExistsInTheList() {
    }
}
