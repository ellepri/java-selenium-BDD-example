Feature: Shopping
  As a user
  I want to be able to add items in the cart
  So that I can purchase the items

  Scenario: Adding most expensive dress in the cart
    Given I am on category page
    When I click on most expensive dress
    Then my item is added to the cart
    And the "Product successfully added to your shopping cart" heading is displayed

  # Need to create an account first
  Scenario: Session is saved after logging out
    Given I am on authentication page
    And user is logged in with following details
      | jane.doe@gmail.com | password |
    When I add item on the cart
    And I logout
    And I login in with details
      | jane.doe@gmail.com | password |
    Then item is still on the cart
