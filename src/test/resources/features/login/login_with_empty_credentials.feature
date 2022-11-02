@Regression @Login @AZUL-1406
Feature: Login function with Empty Credentials
  US-001 : As a user, I should be able to log in
  AC-3 : "Please fill out this field" message should be displayed if the password or username is empty

  Background: Login page
    Given Users go to the Log in page

  @AZUL-1398 @Smoke
  Scenario Outline: Verify that user should NOT be able to log in with Empty Credentials and see "Please fill out this field" error message
    When Type "<username>" and "<password>" in the input boxes
    And Click Log In button
    Then Verify that user should be able to see error message "Please fill out this field"

    Examples: Empty username-Valid password, Empty username-Invalid password, Valid username-Empty password, Invalid username-Empty password, Empty username-Empty password
      | username                       | password           |
      |                                | UserUser           |
      |                                | üşçö£#$>£½§{[]}\÷` |
      | marketing99@cybertekschool.com |                    |
      | marketing99                    |                    |
      |                                |                    |