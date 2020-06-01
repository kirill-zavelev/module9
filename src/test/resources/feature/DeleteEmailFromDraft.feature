Feature: As a user I want to delete email from draft folder
  Scenario: Drafts folder does not exists deleted email
    Given the user opens Yandex Passport login page
    When the user clicks on mail box
    And the user opens mail creation form
    And the user filling recipient, subject and body email fields
    And the user clicks X button
    And the user clicks on Drafts item
    And the user delete email
    Then deleted email does not exists in the list