//package com.epam.webdriver.cucumber.steps;
//
//import com.epam.webdriver.base.BaseTest;
//import com.epam.webdriver.cucumber.hooks.BaseHook;
//import com.epam.webdriver.driver.DriverSingleton;
//import com.epam.webdriver.model.Email;
//import com.epam.webdriver.page.auth.QuickActionsPanelPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.testng.Assert;
//
//public class Send extends BaseHook {
//
//    Email expectedEmail = new Email();
//
//    private BaseHook baseHook;
//
//    public Send(BaseHook baseHook) {
//        this.baseHook = baseHook;
//    }
//
//    @When("user clicks on Mailbox item")
//    public void userClicksOnMailboxItem() {
//        quickActionsPanelPage.openMailBox();
//    }
//
//    @And("clicks Create new Email button")
//    public void clicksCreateNewEmailButton() {
//        inboxPage.openMailCreationForm();
//    }
//
//    @And("filling Recipient, Subject, Body")
//    public void fillingRecipientSubjectBody() {
//        mailCreationPage.fillEmail(expectedEmail);
//    }
//
//    @And("clicks Send button")
//    public void clicksSendButton() {
//        mailCreationPage.sendMail();
//    }
//
//    @And("opens Send folder")
//    public void opensSendFolder() {
//        inboxPage.openSendFolder();
//    }
//
//    @Then("Email with appropriate fields is in the list")
//    public void emailWithAppropriateFieldsIsInTheList() {
//        Email actualEmail = inboxPage.getActualEmailFromList(expectedEmail);
//
//        Assert.assertEquals(actualEmail, expectedEmail, "Expected email does not exist in the list.");
//    }
//}
