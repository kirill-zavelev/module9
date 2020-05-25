package com.epam.webdriver.pattern.factorymethod;

import com.epam.webdriver.model.Email;
import com.epam.webdriver.utils.PropertyLoader;
import org.openqa.selenium.WebElement;

public class EmailWithSeveralRecipientsCreator implements EmailCreator {

    Email emailWithTwoRecipients = new Email();

    @Override
    public void createEmail(WebElement element) {
        emailWithTwoRecipients.setRecipient(PropertyLoader.loadProperty("user.send.to")
                + " ;" + "k.zavelev@gmail.com");
        emailWithTwoRecipients.setSubject(emailWithTwoRecipients.getSubject());
        emailWithTwoRecipients.setBody(emailWithTwoRecipients.getBody());
    }
}
