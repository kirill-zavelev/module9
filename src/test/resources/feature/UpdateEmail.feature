Feature: As a user I want to update email
  Scenario: Email is updated and its fields equals updated data
    Given the user opens Yandex Passport login page
    When the user clicks on mail box
    And the user opens mail creation form
    And the user filling recipient, subject and body email fields
    And the user clicks X button
    And the user clicks on Drafts item
    And the user opens email
    And the user filling email with new data
    And the user send updated email
    Then email with updated data exists in Send folder