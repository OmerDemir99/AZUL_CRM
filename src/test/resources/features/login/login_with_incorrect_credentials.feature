@Regression @Login @AZUL-1406
Feature: Login function with Invalid Credentials
  US-001 : As a user, I should be able to log in
  AC-2 : "Incorrect login or password." should be displayed for invalid
          (valid username-invalid password and invalid username-valid password) credentials

  Background: Login page
    Given Users go to the Log in page

  Scenario Outline: Verify that user should NOT be able to log in with Invalid Credentials ( Clicking "Log In" button )
    When Type "<username>" and "<password>" in the input boxes
    And Click Log In button
    Then Verify that user should be able to see error message "Incorrect login or password"

    @AZUL-1395 @Smoke
    Examples: Valid username, Invalid password
      | username                       | password |
      | hr10@cybertekschool.com        | Useruser |
      | helpdesk10@cybertekschool.com  | 1<\",l~  |
      | marketing99@cybertekschool.com | useruser |

    @AZUL-1396
    Examples: Invalid username, Valid password
      | username                     | password |
      | hr@cybertekschool.com        | UserUser |
      | helpdesk10cybertekschool.com | UserUser |
      | marketing99@cydeo.com        | UserUser |

    @AZUL-1397
    Examples: Invalid username, Invalid password
      | username                      | password   |
      | hr@com                        | ___3___    |
      | helpdesk200cybertekschool.com | LoserLoser |
      | 11!!aaQ@%/()=?*_  -é^#~       | (UserUser) |


