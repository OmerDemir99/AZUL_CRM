@Regression @Login @AZUL-1406
Feature: Login function with Valid Credentials
  US-001 : As a user, I should be able to log in
  AC-4 : User land on the ‘Get Password’ page after clicking on the "Forgot your password?" link


  Background: Login page
    Given Users go to the Log in page

    @AZUL-1399
    Scenario: Verify that user should be able to access to "Get Password" page from "Log in" page
      When click forgot your password link
      Then verify that user should be able access get password page
      And click Authorization link
      Then verify that user should be able to go back login page