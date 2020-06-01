package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.base.BaseTest;
import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.factory.EmailFactory;
import com.epam.webdriver.factory.EmailType;
import com.epam.webdriver.model.Email;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.DraftPage;
import com.epam.webdriver.page.mailfolders.InboxPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SendEmailToDraft extends BaseTest {

    private static final Email expectedEmail = new EmailFactory().getEmail(EmailType.WITH_EMPTY_SUBJECT);

    @Before
    public void setUpBrowser() {
        driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);

        loginPage = new LoginPage(driver);
        mailCreationPage = new MailCreationPage(driver);
        inboxPage = new InboxPage(driver);
        draftPage = new DraftPage(driver);
    }

    @After
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }

    @And("the user clicks close button")
    public void clickCloseButton() {
        mailCreationPage.sendMailAsDraft();
    }

    @And("the user opens draft item")
    public void openDraftFolder() {
        inboxPage.openDraftsFolder();
    }

    @Then("email with correct data exists in draft folder")
    public void emailWithCorrectDataExistsInDraftFolder() {
        Email actualEmail = draftPage.getActualEmailFromList(expectedEmail);

        Assert.assertEquals(actualEmail, expectedEmail, "Incorrect email data. Please mail parameters.");
    }
}
