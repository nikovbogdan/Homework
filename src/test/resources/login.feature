Feature:Login
  As a user,
  I want to log in with valid credentials(Username and Password) and to not be able to log in with invalid credentials.
  In case of unsuccessful LogIn an error(RED) message appears above the Username input field.

  @TC0001 @sanity @regression @positive
  Scenario: Valid login admin page
    Given user navigates to "admin" page
    When user enters "admin" and "parola123!" and click OK - "admin" account
    Then ensure "Milen Strahinski" is displayed on page header
    And ensure log out button is displayed on page header

  @TC0002 @sanity @regression @negative
  Scenario: Can't login with invalid credentials admin page
    Given user navigates to "admin" page
    When user enters "admin" and "parola12345!" and click OK - "admin" account
    Then ensure RED message is displayed
    And ensure RED message has "No match for Username and/or Password." text

  @TC0002 @negative
  Scenario Outline: Can't login with invalid credentials(DDT)
    Given user navigates to "admin" page
    When user enters "<username>" and "<password>" and click OK - "admin" account
    Then ensure RED message is displayed
    And ensure RED message has "No match for Username and/or Password." text
    Examples:
      | username  | password       |
      | admin     | parola123456!  |
      |           |                |
      | adm       | parola123!     |
      | admin123  | parola123456!  |
      | ..        | ..             |
      | adm 12333 | parola123!4556 |

  @TC0005 @positive @sanity
  Scenario: Valid Login user page
    Given user navigates to "user" page
    When user enters "bogdan@mailinator.com" and "Pass123!" and click OK - "user" account
    Then ensure Edit Your Account hyperlink is displayed

  @TC0008 @negative @sanity @regression
  Scenario: Forgotten password hyperlink (wrong email)
    Given user navigates to "user" page
    When user clicks on Forgotten Password hyperlink
    And user enters "bogdan_1234@mailinator.com" email, associated whit his account, to receive password reset link
    Then ensure RED message is displayed
    And ensure RED message has "Warning: The E-Mail Address was not found in our records, please try again!" text

  @TC0009 @positive @sanity
  Scenario: Forgotten password hyperlink
    Given user navigates to "user" page
    When user clicks on Forgotten Password hyperlink
    And user enters "bogdan@mailinator.com" email, associated whit his account, to receive password reset link
    Then ensure GREEN message is displayed
    And ensure GREEN message has "An email with a confirmation link has been sent your email address." text