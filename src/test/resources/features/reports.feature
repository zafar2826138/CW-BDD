Feature: 5) Report Page: Test Cases

  Background:
    Given  User is on the Sign-In page
    When   User enters a valid 'email' and  valid 'password'
    And    User clicks the Sign In button



# Add Income
  Scenario: TC_034: Verify that a new income entry can be successfully added with valid details.

  Scenario: TC_035: Check that an error appears when entering a negative amount.

  Scenario: TC_036: Verify that selecting an income category updates the report correctly.

# Add Expense
  Scenario: TC_037: Verify that a new expense entry can be successfully added with valid details.

  Scenario: TC_038: Check that an error appears when entering a negative expense amount.

  Scenario: TC_039: Verify that selecting an expense category updates the report correctly.

# Transaction
  Scenario: TC_040: Verify that the total balance (Income - Expense) updates correctly after adding a transaction.

  Scenario: TC_041: Ensure that users can filter transactions by date range.

  Scenario: TC_042: Check that users can sort transactions by income or expense.

  Scenario: TC_043: Verify that exporting the transaction list (PDF, CSV, Excel) works correctly.

  Scenario: TC_044: Check that searching for a specific transaction returns accurate results.



