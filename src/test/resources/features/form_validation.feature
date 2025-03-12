Feature: Form Validation Testing

  Scenario: Verify form submission with valid data
    Given User is on the form validation page
    When User enters "Valid Data" as Contact Name
    And User enters "Valid Data" as Contact Number
    And User selects "Valid Data" as PickUp Date
    And User selects "Valid Data" as Payment Method
    And User clicks on Register button
    Then Form should be registered successfully

  Scenario: Verify form submission with invalid data and error messages
    Given User is on the form validation page
    When User enters "Invalid Data" as Contact Name
    And User enters "Invalid Data" as Contact Number
    And User selects "Invalid Data" as PickUp Date
    And User selects "Invalid Data" as Payment Method
    And User clicks on Register button
    Then User should see error message "Please enter your Contact name." in position 1
    And User should see error message "Please provide your Contact number." in position 2
    And User should see error message "Please provide valid Date." in position 3
    And User should see error message "Please select the Payment Method." in position 4
