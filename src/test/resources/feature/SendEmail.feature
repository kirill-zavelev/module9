Feature: As a user I want to send email
  Scenario: Email is sent and its fields equals setting data
    Given the user opens mail box
    When the user opens mail creation form
    And the user filling recipient, subject and body email fields
    And the user clicks send button
    And the user opens send item
    Then email with correct data exists in send folder