@Regression @Logout @AZUL-1520
Feature: Logout function
  US-002 : As a user, I should be able to log out
  AC-2 : The user can not go to the home page again by clicking the step back button
            after successfully logging out.


  Background: Home page
    Given Users go to the Log in page
    When Users login with valid credentials

  # navigate().back() method
  @AZUL-1509
  Scenario: Verify that users should NOT be able go back homepage after log out successfully by pressing back button
    When click username dropdown that is top right on the homepage
    And click Log out button
    And click back button
    Then verify that user should NOT be able to go back home page

  # Command + ArrowLeft shortcut
  @AZUL-1510
  Scenario: Verify that users should NOT be able go back homepage after log out successfully with keyboard action
    When click username dropdown that is top right on the homepage
    And click Log out button
    And press shortcut key to go to previous web page
    Then verify that user should NOT be able to go back home page