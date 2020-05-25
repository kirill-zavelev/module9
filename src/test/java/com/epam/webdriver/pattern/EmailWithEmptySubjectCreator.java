package com.epam.webdriver.pattern;

import com.epam.webdriver.model.Email;
import com.epam.webdriver.utils.PropertyLoader;
import org.openqa.selenium.WebElement;

public class EmailWithEmptySubjectCreator implements EmailCreator {

    @Override
    public Email createEmail(WebElement element) {
        Email emailWithEmptySubject = new Email();
        emailWithEmptySubject.setRecipient(PropertyLoader.loadProperty("user.send.to"));
        emailWithEmptySubject.setSubject("");
        emailWithEmptySubject.setBody(emailWithEmptySubject.getBody());

        return emailWithEmptySubject;
    }
}
