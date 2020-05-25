package com.epam.webdriver.pattern.factorymethod;

import com.epam.webdriver.model.Email;
import com.epam.webdriver.pattern.factorymethod.EmailCreator;
import com.epam.webdriver.utils.PropertyLoader;
import org.openqa.selenium.WebElement;

public class EmailWithEmptySubjectCreator implements EmailCreator {

    Email emailWithEmptySubject = new Email();

    @Override
    public void createEmail(WebElement element) {
        emailWithEmptySubject.setRecipient(PropertyLoader.loadProperty("user.send.to"));
        emailWithEmptySubject.setSubject("");
        emailWithEmptySubject.setBody(emailWithEmptySubject.getBody());
    }
}
