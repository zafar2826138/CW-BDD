@regression
Feature: 3) Sales Page: Test Cases

  Background:
    Given  User is on the Sign-In page
    When   User enters a valid 'email' and  valid 'password'
    And    User clicks the Sign In button

#  Clients
  Scenario: TC_007: Verify that a new client can be successfully added with valid details.
    Then User clicks Sales Tab
    Then User click add client button
    Then User fills Add client form and clicks Save button
    Then User verifies client added and appears in Clients list

  Scenario: TC_008: Verify that users can edit existing client details.
    Then User clicks Sales Tab
    Then User clicks edit icon on first client
    Then User makes changes in Edit form and clicks Save button
    Then User validates changes of first client

  Scenario: TC_009: Ensure users can archive a client successfully.
    Then User clicks Sales Tab
    Then User clicks archive icon on random client
    Then User validates archived client from Archived tab list

  Scenario: TC_010: Verify that duplicate client entries are not allowed.
    Then User clicks Sales Tab
    Then User click add client button
    Then User fills Add client form with existing client and clicks Save button
    Then User validates duplicate client cannot be created

    # Products and Services
  Scenario: TC_011: Verify that a new product/service can be successfully added.
    Then User clicks Sales Tab
    Then User clicks Product and Services Tab Sales
    Then User clicks Add Product and service button
    Then User fills Add product and service form and clicks Save button
    Then User validates added product from list


  Scenario: TC_012: Check that an error appears when entering a negative price value.
    Then User clicks Sales Tab
    Then User clicks Product and Services Tab Sales
    Then User clicks Add Product and service button
    Then User fills Add product and service form with negative price and clicks Save button
    Then User validates that product cannot be added


  Scenario: TC_013: Ensure that users can edit product/service details.
    Then User clicks Sales Tab
    Then User clicks Product and Services Tab Sales
    Then User clicks edit icon on first product
    Then User changes Edit product or service form and clicks Save button
    Then User validates changes of product from list

  Scenario: TC_014: Check that a deleted product/service is removed from the list.
    Then User clicks Sales Tab
    Then User clicks Product and Services Tab Sales
    Then User clicks delete icon on first product
    Then User validates deleted product from list

  Scenario: TC_015: Ensure that duplicate product/service names are not allowed.
    Then User clicks Sales Tab
    Then User clicks Product and Services Tab Sales
    Then User clicks Add Product and service button
    Then User fills Add product and service form with existing product and clicks Save button
    Then User validates duplicate product are not allowed

    # Invoice
  Scenario: TC_016: Verify that an invoice can be successfully created with valid details.
    Then User clicks Sales Tab
    Then User clicks Invoice Tab
    Then User clicks Create invoice button
    Then User fills Create invoice form
    Then User validates new invoice created

  Scenario: TC_017: Ensure that selecting a client auto-fills relevant details (if applicable).
    Then User clicks Sales Tab
    Then User clicks Invoice Tab
    Then User clicks Create invoice button
    Then User selects existing client from Whom dropdown
    Then User validates auto-fill details

  Scenario: TC_018: Check that users can add multiple products/services to an invoice.
    Then User clicks Sales Tab
    Then User clicks Invoice Tab
    Then User clicks Create invoice button
    Then User adds multiple products and services
    Then User validates valid entry

  Scenario: TC_019: Validate that total invoice amount updates correctly based on selected products/services.
    Then User clicks Sales Tab
    Then User clicks Invoice Tab
    Then User clicks Create invoice button
    Then User adds multiple products and services
    Then User validates amount updates correctly


  Scenario: TC_020: Ensure that users can edit invoice details.
    Then User clicks Sales Tab
    Then User clicks Invoice Tab
    Then User clicks edit icon from first invoice
    Then User fills Edit invoice form and clicks Save button
    Then User validates changes saved


  Scenario: TC_021: Validate that invoices can be downloaded/exported (PDF).
    Then User clicks Sales Tab
    Then User clicks Invoice Tab
    Then User clicks Show PDF version icon from first invoice
    Then User clicks Download PDF button
    Then User validates invoice downloaded to local machine
