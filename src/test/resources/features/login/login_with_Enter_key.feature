@Regression @Login @AZUL-1406
Feature: Login function with Valid Credentials
  US-001 : As a user, I should be able to log in
  AC-7 : Verify if the ‘Enter’ key of the keyboard is working correctly on the login page.


  Background: Login page
    Given Users go to the Log in page


    # Data Table
  @AZUL-1402
  Scenario: Verify that user should be able to log in with Valid Credentials - Helpdesk ( Pressing "Enter" key on the keyboard)
    When Enter username and password in the input boxes
      | username | helpdesk100@cybertekschool.com |
      | password | UserUser                       |
    And Press Enter button on the keyboard
    Then Verify that user should be able to see title that contains "Portal"


    # Parameterization
  @AZUL-1403
  Scenario: Verify that user should be able to log in with Valid Credentials - HR ( Pressing "Enter" key on the keyboard)
    When Type username "hr100@cybertekschool.com" and password "UserUser" in the input boxes
    And Press Enter button on the keyboard
    Then Verify that user should be able to see title that contains "Portal"


    # ConfigurationReader
  @AZUL-1404 @Smoke
  Scenario: Verify that user should be able to log in with Valid Credentials - Marketing ( Pressing "Enter" key on the keyboard)
    When Type username and password in the input boxes
    And Press Enter button on the keyboard
    Then Verify that user should be able to see title that contains "Portal"