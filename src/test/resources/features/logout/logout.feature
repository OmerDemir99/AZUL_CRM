@Regression @Logout @AZUL-1520
Feature: Logout function
  US-002 : As a user, I should be able to log out
  AC-1 : The user can log out and ends up on the login page.


  Background: Home page
    Given Users go to the Log in page
    When Users login with valid credentials

    # Logout button scenario
    @AZUL-1507
    Scenario: Verify that users should be able log out and are successfully redirected to login page
      When click username dropdown that is top right on the homepage
      And click Log out button
      Then verify that user should be able to log out and see login page

     # Open two tabs with same credentials
    @AZUL-1508
    Scenario: Verify that users should be able log out even if two account is opened
      When open new tab and log in with same credentials
      When click username dropdown that is top right on the homepage
      And click Log out button
      Then verify that user should NOT be able to do anything in the another open homepage