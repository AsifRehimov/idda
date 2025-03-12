Feature: Dynamic Controls

  Scenario: Verify checkbox visibility and selection
    Given User is on the dynamic controls page
    When User clicks on the "Remove" button
    Then The checkbox should not be visible
    When User clicks on the "Add" button
    Then The checkbox should be visible
    And The checkbox should be selected

  Scenario: Verify input field state
    Given User is on the dynamic controls page
    Then The input field should be disabled
    When User clicks on the "Enable" button
    Then The input field should be enabled
    When User clicks on the "Disable" button
    Then The input field should be disabled

  Scenario: Verify text changes after dynamic actions
    Given User is on the dynamic controls page
    When User clicks on the "Remove" button
    Then The message "It's gone!" should be displayed
    When User clicks on the "Add" button
    Then The message "It's back!" should be displayed
    When User clicks on the "Enable" button
    Then The message "It's enabled!" should be displayed
    When User clicks on the "Disable" button
    Then The message "It's disabled!" should be displayed

