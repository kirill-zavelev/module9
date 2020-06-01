Feature: As a user I want to login to the system

  Background: User is on LoginPage

  Scenario Outline: Login by user
    When user enter username "<username>"
    And clicks login button
    And user enter password "<password>"
    And clicks login button
    Then user is on page with user's username "<username>" displayed
    Examples:
      | username   | password     |
      | buben.vika | 55555555vika |
