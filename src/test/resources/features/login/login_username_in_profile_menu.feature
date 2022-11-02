@Regression @Login @AZUL-1406
Feature: Login function with Valid Credentials
  US-001 : As a user, I should be able to log in
  AC-8 : All users can see their own usernames in the profile menu, after successful login


  Background: Login page
    Given Users go to the Log in page

  @AZUL-1405 @Smoke
  Scenario Outline: Verify that user should be able to see their own name in the profile menu after login
    When Type "<username>" and "<password>" in the input boxes
    And Click Log In button
    Then Verify that user should be able to see own name "<name>" in the profile menu


    Examples: HR user
      | username                       | password | name                           |
      | hr1@cybertekschool.com         | UserUser | hr1@cybertekschool.com         |
      | helpdesk22@cybertekschool.com  | UserUser | helpdesk22@cybertekschool.com  |
      | marketing91@cybertekschool.com | UserUser | marketing91@cybertekschool.com |
      | hr44@cybertekschool.com        | UserUser | hr44@cybertekschool.com        |
      | helpdesk57@cybertekschool.com  | UserUser | helpdesk57@cybertekschool.com  |
      | marketing93@cybertekschool.com | UserUser | marketing93@cybertekschool.com |