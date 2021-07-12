Feature: Cart
  As a user,
  I want to add and remove items to the cart, to view item price, quantity and total price (VAT).

  Scenario: Add item to cart
    Given user navigates to "user" page
    And user views "MacBook" product details
    And user changes the product quantity to "1"
    And user adds the product to the cart
    Then ensure the green message is displayed
    And click on the cart component button
    And verify the "MacBook" product is at the 1st place in the cart
    And verify the item quantity is "1"



