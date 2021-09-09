Feature: Login
  As a user
  I want to be able to login
  So that I can see my account

  # Need to create an account first
  Scenario: User is able to login
    Given I am on index page
    When I navigate to login page
    And I login in with details
      | jane.doe@gmail.com | password |
    Then user is signed in
