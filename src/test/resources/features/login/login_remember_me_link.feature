@Regression @Login @AZUL-1406
Feature: Login function with Valid Credentials
  US-001 : As a user, I should be able to log in
  AC-5 : User can see "Remember Me" link exists and is clickable on the login page


  Background: Login page
    Given Users go to the Log in page

    @AZUL-1400
    Scenario: Verify that "Remember Me" link exists and is clickable on the login page
      Then verify that remember me link exist
      Then verify that remember me link is clickable