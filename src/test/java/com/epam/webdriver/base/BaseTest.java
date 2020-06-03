package com.epam.webdriver.base;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.factory.EmailFactory;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.DraftPage;
import com.epam.webdriver.page.mailfolders.InboxPage;
import com.epam.webdriver.utils.PropertyLoader;
import com.epam.webdriver.utils.TestListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class BaseTest {

    protected static final String USERNAME = PropertyLoader.loadProperty("user.name");
    protected static final String PASSWORD = PropertyLoader.loadProperty("user.password");
    protected static final String EMAIL = PropertyLoader.loadProperty("user.send.from");
    protected static final String BASE_URL = PropertyLoader.loadProperty("base.url");
    protected static final EmailFactory EMAIL_FACTORY = new EmailFactory();

    protected LoginPage loginPage;
    protected QuickActionsPanelPage quickActionsPanelPage;
    protected InboxPage inboxPage;
    protected MailCreationPage mailCreationPage;
    protected DraftPage draftPage;

    @BeforeMethod
    public void setUpBrowser() {
        loginPage = new LoginPage();
        mailCreationPage = new MailCreationPage();
        draftPage = new DraftPage();
        inboxPage = new InboxPage();
        quickActionsPanelPage = loginPage
                .openBasePage()
                .login(USERNAME, PASSWORD)
                .clickOnUsername();
    }

    @AfterMethod
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }
}
