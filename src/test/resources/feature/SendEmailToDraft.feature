Feature: As a user I want to send email as draft
  Scenario: Drafts folder should contains the email
    Given the user opens Yandex Passport login page
    When the user clicks on mail box
    And the user opens mail creation form
    And the user filling recipient, subject and body email fields
    And the user clicks X button
    And the user clicks on Drafts item
    Then created email exists in the list