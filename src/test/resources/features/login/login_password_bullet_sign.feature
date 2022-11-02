@Regression @Login @AZUL-1406
Feature: Login function with Valid Credentials
  US-001 : As a user, I should be able to log in
  AC-6 : User should see the password in bullet signs by default


  Background: Login page
    Given Users go to the Log in page

    @AZUL-1401
    Scenario: Verify that entered password should be able to turn into bullet sign
      Then verify that user should be able see entered password as bullet signs
