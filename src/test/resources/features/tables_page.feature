Feature: Table Validation

  Scenario: Extract and verify column values from the table
    Given User is on the table page
    When User extracts values from the "Last Name" column
    Then User should see the following values:
      | Smith  |
      | Bach   |
      | Doe    |
      | Conway |

  Scenario: Verify row count before and after an operation
    Given User is on the table page
    Then The table should have 4 rows
    When User deletes the row with "Last Name" "Conway"
    Then The table should have 3 rows

  Scenario: Verify sorting of table data in ascending order
    Given User is on the table page
    When User sorts the "Last Name" column in ascending order
    Then The "Last Name" column should be sorted as:
      | Bach   |
      | Conway |
      | Doe    |
      | Smith  |

  Scenario: Verify sorting of table data in descending order
    Given User is on the table page
    When User sorts the "Last Name" column in descending order
    Then The "Last Name" column should be sorted as:
      | Smith  |
      | Doe    |
      | Conway |
      | Bach   |

