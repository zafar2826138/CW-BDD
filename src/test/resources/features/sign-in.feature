@regression
Feature: 2) Sign In Functionality: Test Cases

  Scenario: TC_004: Verify login with valid credentials.
    Given  User is on the Sign-In page
    When   User enters a valid 'email' and  valid 'password'
    And    User clicks the Sign In button

  Scenario: TC_005: Verify that an incorrect password triggers an error message.
    Given  User is on the Sign-In page
    When   User enters a invalid 'email' and  invalid 'password'
    And    User clicks the Sign In button
    Then   User validates not signed in

  Scenario: TC_006: Ensure users can reset their password via the "Forgot Password" link.
    Given  User is on the Sign-In page
    When   User enters clicks Forgot Pasword link
    And    User enters 'email' and clicks send button
    Then   User validates logotype