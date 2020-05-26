package com.epam.webdriver.base;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.driver.DriverSingleton;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.DraftPage;
import com.epam.webdriver.page.mailfolders.InboxPage;
import com.epam.webdriver.factory.EmailFactory;
import com.epam.webdriver.utils.PropertyLoader;
import com.epam.webdriver.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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

    protected DriverDecorator driver;

    @BeforeMethod
    public void setUpBrowser() {
        driver = new DriverDecorator(DriverSingleton.getDriver());
        driver.get(BASE_URL);

        loginPage = new LoginPage(driver);
        mailCreationPage = new MailCreationPage(driver);
        draftPage = new DraftPage(driver);
        inboxPage = new InboxPage(driver);
        quickActionsPanelPage = loginPage.login(USERNAME, PASSWORD).clickOnUsername();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }
}
