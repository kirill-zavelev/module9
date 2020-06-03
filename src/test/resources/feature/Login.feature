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