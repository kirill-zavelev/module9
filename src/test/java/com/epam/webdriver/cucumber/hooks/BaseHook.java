package com.epam.webdriver.cucumber.hooks;

import com.epam.webdriver.decorator.DriverDecorator;
import com.epam.webdriver.page.auth.LoginPage;
import com.epam.webdriver.page.auth.QuickActionsPanelPage;
import com.epam.webdriver.page.auth.StartPage;
import com.epam.webdriver.page.mailactions.MailCreationPage;
import com.epam.webdriver.page.mailfolders.InboxPage;

public class BaseHook {

    protected QuickActionsPanelPage quickActionsPanelPage;
    protected MailCreationPage mailCreationPage;
    protected InboxPage inboxPage;
    protected LoginPage loginPage;
    protected StartPage startPage;

    protected DriverDecorator driver;

}
