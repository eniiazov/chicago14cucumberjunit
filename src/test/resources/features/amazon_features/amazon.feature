@regression @amazon
Feature: Amazon feature

  @p
  Scenario: Validate size of categories
    Given I login to "amazon" website
    When I click "hamburger menu" button
    Then I validate size of categories