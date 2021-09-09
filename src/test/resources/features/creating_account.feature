Feature: Creating a new account
  As a user
  I want to be able to create an account
  So that I can login

  # needs tear down
  @skip
  Scenario: Creating new account for user
    Given I am on authentication page
    When I enter an email
    And click Create an account
    And I fill in the form
    Then new account has been created
