package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.base.BaseTest;
import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.factory.EmailFactory;
import com.epam.webdriver.factory.EmailType;
import com.epam.webdriver.model.Email;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.auth.StartPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.DraftPage;
import com.epam.webdriver.page.mailfolders.InboxPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendEmail {

    private static final Email expectedEmail = new EmailFactory().getEmail(EmailType.WITH_EMPTY_SUBJECT);

    protected LoginPage loginPage;
    protected QuickActionsPanelPage quickActionsPanelPage;
    protected InboxPage inboxPage;
    protected MailCreationPage mailCreationPage;
    protected DraftPage draftPage;

    protected DriverDecorator driver;

    @When("the user opens Yandex Passport login page")
    public void openYandexPassportLoginPage() {

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
