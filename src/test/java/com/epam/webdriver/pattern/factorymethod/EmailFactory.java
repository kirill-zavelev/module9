package com.epam.webdriver.pattern.factorymethod;

import com.epam.webdriver.model.Email;

public class EmailFactory {

    public Email getEmail(EmailType type) {
        EmailWithEmptySubjectCreator emailWithEmptySubjectCreator = new EmailWithEmptySubjectCreator();
        EmailWithSeveralRecipientsCreator emailWithSeveralRecipientsCreator = new EmailWithSeveralRecipientsCreator();

        switch (type) {
            case WITH_EMPTY_SUBJECT:
                new EmailWithEmptySubjectCreator();
                break;
            case WITH_TWO_RECIPIENTS:
                new EmailWithSeveralRecipientsCreator();
                break;
            default:
                return null;
        }

    }
}
