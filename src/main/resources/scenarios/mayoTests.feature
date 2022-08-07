@Mayo
Feature: Mayo Tests

  Background: open Mayo home page
    Given The user is on mayo clinic home page

  Scenario: verify home page title
    Then The user verifies the title of home page

  Scenario Outline: verify home page title
    And user navigates to the page "<page_name1>"
    Then verifies the title "<title>"
    When user clicks on "<link>"
    Then The user verifies the title of home page
    Examples:
      | page_name1                   | title                                 | link        |
      | Learn_more_about_mayo_clinic | Why Choose Mayo Clinic? - Mayo Clinic | Header_Logo |


