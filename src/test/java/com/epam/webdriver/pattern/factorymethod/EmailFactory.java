package com.epam.webdriver.pattern.factorymethod;

import com.epam.webdriver.model.Email;

public class EmailFactory {

    public EmailCreator getEmail(EmailType type) {

        EmailCreator toReturn = null;

        switch (type) {
            case WITH_EMPTY_SUBJECT:
                toReturn = new EmailWithEmptySubjectCreator();
                break;
            case WITH_TWO_RECIPIENTS:
                toReturn = new EmailWithSeveralRecipientsCreator();
                break;
            default:
                toReturn = new EmailWithEmptySubjectCreator();
        }

        return toReturn;
    }
}
