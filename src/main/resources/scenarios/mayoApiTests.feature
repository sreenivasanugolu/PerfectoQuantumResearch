@APITests
Feature: Mayo  API Tests

  @smoke @regression @sev1fixes
  Scenario: verify api test
    Given I do a get in api site
    Then I should see details in response


