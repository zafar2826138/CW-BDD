Feature: 4) Expenses Page: Test Cases

  Background:
    Given  User is on the Sign-In page
    When   User enters a valid 'email' and  valid 'password'
    And    User clicks the Sign In button

 # Sellers
  Scenario: TC_022: Verify that a new seller can be successfully added with valid details.
    Then User clicks Expenses Tab

  Scenario: TC_023: Verify that duplicate seller entries are not allowed.
    Then User clicks Expenses Tab

  Scenario: TC_024: Verify that users can edit existing seller details.
    Then User clicks Expenses Tab

  Scenario: TC_025: Ensure users can delete a seller successfully.
    Then User clicks Expenses Tab

  Scenario: TC_026: Verify that searching for a seller returns correct results.
    Then User clicks Expenses Tab

# Products and Services
  Scenario: TC_027: Verify that a new product/service can be successfully added under expenses.
    Then User clicks Expenses Tab
    Then User clicks Product and Services Tab Expences

  Scenario: TC_028: Check that an error appears when entering a negative cost value.
    Then User clicks Expenses Tab
    Then User clicks Product and Services Tab Expences

  Scenario: TC_029: Ensure that users can edit product/service details.
    Then User clicks Expenses Tab
    Then User clicks Product and Services Tab Expences

  Scenario: TC_030: Check that a deleted product/service is removed from the list.
    Then User clicks Expenses Tab
    Then User clicks Product and Services Tab Expences

  Scenario: TC_031: Ensure that duplicate product/service names are not allowed.
    Then User clicks Expenses Tab
    Then User clicks Product and Services Tab Expences

# Check
  Scenario: TC_032: Verify that a check can be successfully added with valid details.

  Scenario: TC_033: Ensure that users can print or export check details.
