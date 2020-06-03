Feature: As a user I want to login to the system

  Background: User is on LoginPage
    Given user is on login page

  Scenario Outline: Login by user
    When user enter username "<username>"
    And clicks login button
    And user enter password "<password>"
    And clicks login button
    And clicks on avatar
    Then user is on start page with user's username "<username>" displayed
    Examples:
      | username             | password     |
      | buben.vika@yandex.by | 55555555vika |


  Scenario: Send email
    Given user is on start page
    When user clicks on Mailbox item
    And clicks Create new Email button
    And filling Recipient, Subject, Body
    And clicks Send button
    And opens Send folder
    Then Email with appropriate fields is in the list
