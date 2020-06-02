package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.model.Email;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.InboxPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class Send {

    private QuickActionsPanelPage quickActionsPanelPage;
    private MailCreationPage mailCreationPage;
    private InboxPage inboxPage;
    private Email expectedEmail = new Email();

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

    @And("user clicks on Mailbox item")
    public void userClicksOnMailboxItem() {
        quickActionsPanelPage = new QuickActionsPanelPage(driver);
        quickActionsPanelPage.openMailBox();
    }

    @And("clicks Create new Email button")
    public void clicksCreateNewEmailButton() {
        inboxPage = new InboxPage(driver);
        inboxPage.openMailCreationForm();
    }

    @And("filling Recipient, Subject, Body")
    public void fillingRecipientSubjectBody() {
        mailCreationPage = new MailCreationPage(driver);
        mailCreationPage.fillEmail(expectedEmail);
    }

    @And("clicks Send button")
    public void clicksSendButton() {
        mailCreationPage.sendMail();
    }

    @And("opens Send folder")
    public void opensSendFolder() {
        inboxPage.openSendFolder();
    }

    @Then("Email with appropriate fields is in the list")
    public void emailWithAppropriateFieldsIsInTheList() {
        Email actualEmail = inboxPage.getActualEmailFromList(expectedEmail);

        Assert.assertEquals(actualEmail, expectedEmail, "Expected email does not exist in the list.");
    }
}
