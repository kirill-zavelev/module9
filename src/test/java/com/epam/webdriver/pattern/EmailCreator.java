package com.epam.webdriver.pattern;

import com.epam.webdriver.model.Email;
import org.openqa.selenium.WebElement;

public interface EmailCreator {
    Email createEmail(WebElement element);
}
