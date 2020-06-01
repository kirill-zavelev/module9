Feature: As a user I want to send email to draft
  Scenario: Email is sent and its fields equals setting data
    Given the user opens mail box
    When the user opens mail creation form
    And the user filling recipient, subject and body email fields
    And the user clicks close button
    And the user opens draft item
    Then email with correct data exists in draft folder