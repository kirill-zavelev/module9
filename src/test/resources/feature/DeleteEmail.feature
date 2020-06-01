Feature: As a user I want to delete email from draft
  Scenario: Email is deleted from drafts
    Given the user opens mail box
    When the user opens mail creation form
    And the user filling recipient, subject and body email fields
    And the user clicks close button
    And the user opens draft item
    And the user delete email
    Then email does not exists in draft folder