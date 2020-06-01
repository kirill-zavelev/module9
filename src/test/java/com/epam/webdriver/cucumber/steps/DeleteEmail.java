package com.epam.webdriver.cucumber.steps;

import com.epam.webdriver.base.BaseTest;
import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.model.Email;
import com.epam.webdriver.page.mailfolders.DraftPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class DeleteEmail extends BaseTest {

    private static final Email email = new Email();

    @Before
    public void setUpBrowser() {
        driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);

        draftPage = new DraftPage(driver);
    }

    @After
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }

    @And("the user delete email")
    public void deleteEmail() {
        draftPage.checkEmailCheckbox(email)
                .clickDeleteEmail();
    }

    @Then("email does not exists in draft folder")
    public void verifyEmailIsDeleted() {
        boolean isEmailDeleted = draftPage.isEmailDeleted(email);
        Assert.assertTrue(isEmailDeleted, "Email was not deleted from inbox.");
    }
}
