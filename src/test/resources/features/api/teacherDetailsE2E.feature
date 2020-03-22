Feature: Teacher Details End to End for UI vs API

  @e2e
  Scenario Outline: UI vs API cross data validation
    Given user gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user opens teacher profile details page "<teacherID>"
    And user cross validates teacher details on API and on UI

    Examples:
      | resource      | teacherID |
      | /teacher/2625 | 2625      |
      | /teacher/2761 | 2761      |