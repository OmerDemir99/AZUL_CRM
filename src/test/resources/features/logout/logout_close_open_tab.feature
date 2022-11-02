@Regression @Logout @AZUL-1520
Feature: Logout function
  US-002 : As a user, I should be able to log out
  AC-3 :  The user must be logged out if the user close the open tab
            (all tabs if there are multiple open tabs)


    Background: Home page
        Given Users go to the Log in page
        When Users login with valid credentials


    # Close single open tab
    @AZUL-1512
    Scenario: Verify that users log out after closing single open tab
      When close the single tab
      And open new browser and go to login page
      Then verify that user should NOT be able to go back home page

    # Close AzulCRM and try to go login page from another tab
    @AZUL-1513
    Scenario: Verify that users are able to log out only after closing currently open tab
      When open new tab or tabs
      And close the tab that is for Azul_crm
      And go to the login page using other tab
      Then verify that user should NOT be able to go back home page

    # Go to the Amazon web site from home page of AzulCRM and then close the tab
    @AZUL-1515
    Scenario: Verify that users are able to log out by going another web site without logging out
      When open new tab or tabs
      And go to the another web site and close web site
      And go to the login page using other tab
      Then verify that user should NOT be able to go back home page

    # Try to go back using browser history from another web site without logging out
    @AZUL-1517
    Scenario: Verify that users are able to log out by going another web site without logging out
      When open new tab or tabs
      And go to the another web site
      And select first option from history
      Then verify that user should NOT be able to go back home page