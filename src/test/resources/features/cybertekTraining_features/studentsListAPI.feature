Feature: Student List API

  @batchID
  Scenario Outline: Getting list of Students by Batch Number

    Given user gets students list with "<resource>"
    And user validates data from response by batch number "<batchID>"

    Examples:
      | resource          | batchID |
      | /student/batch/14 | 14      |
      | /student/batch/4  | 4       |
