package com.epam.webdriver.pattern.factorymethod;

import com.epam.webdriver.model.Email;
import org.openqa.selenium.WebElement;

public interface EmailCreator {
    void createEmail(WebElement element);
}
