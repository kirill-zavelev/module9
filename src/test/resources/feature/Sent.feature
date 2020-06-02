Feature: As a user I want to login to the system

  Background: User is on LoginPage

    Scenario: Send email
      When user clicks on Mailbox item
      And clicks Create new Email button
      And filling Recipient, Subject, Body
      And clicks Send button
      And opens Send folder
      Then Email with appropriate fields is in the list