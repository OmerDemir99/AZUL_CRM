@Regression @Login @AZUL-1406
Feature: Login function with Valid Credentials
  US-001 : As a user, I should be able to log in
    AC-1 : All users can log in with valid credentials
           (We have 3 types of users such as HR user, Marketing user, Helpdesk user).


  Background: Login page
    Given Users go to the Log in page


  Scenario Outline: Verify that user should be able to log in with Valid Credentials ( Clicking "Log In" button )
    When Type "<username>" and "<password>" in the input boxes
    And Click Log In button
    Then Verify that user should be able to see title that contains "Portal"

    @AZUL-1392 @Smoke
    Examples: HR user
      | username                | password |
      | hr10@cybertekschool.com | UserUser |
      | hr20@cybertekschool.com | UserUser |
      | hr30@cybertekschool.com | UserUser |
      | hr40@cybertekschool.com | UserUser |
      | hr50@cybertekschool.com | UserUser |

    @AZUL-1393
    Examples: Helpdesk user
      | username                      | password |
      | helpdesk40@cybertekschool.com | UserUser |
      | helpdesk50@cybertekschool.com | UserUser |
      | helpdesk60@cybertekschool.com | UserUser |
      | helpdesk70@cybertekschool.com | UserUser |
      | helpdesk80@cybertekschool.com | UserUser |

    @AZUL-1394
    Examples: Marketing user
      | username                       | password |
      | marketing95@cybertekschool.com | UserUser |
      | marketing96@cybertekschool.com | UserUser |
      | marketing97@cybertekschool.com | UserUser |
      | marketing98@cybertekschool.com | UserUser |
      | marketing99@cybertekschool.com | UserUser |


