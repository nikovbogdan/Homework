Feature: Cart
  As a user,
  I want to add and remove items to the cart, to view item price, quantity and total price (VAT).

  Scenario: Add one item to cart
    Given user navigates to "user" page
    And user views "MacBook" product details
    And user changes the product quantity to "1"
    And user adds the product to the cart
    Then ensure the item is added message is displayed
    And click on the cart component button
    And verify the "MacBook" product is at the 1st place in the cart
    And verify the item quantity is "1"

    Scenario: Add multiple items to cart
      Given user navigates to "user" page
      And user views "MacBook" product details
      And user changes the product quantity to "1"
      And user adds the product to the cart
      Then ensure the item is added message is displayed
      And user navigates to "home" page
      And user views "iPhone" product details
      And user adds the product to the cart
      And ensure the item is added message is displayed
      And click on the cart component button
      And verify the "iPhone" product is in the cart

  Scenario: Change quantity of a product
    Given user navigates to "user" page
    And user views "MacBook" product details
    And user changes the product quantity to "5"
    And user adds the product to the cart
    Then ensure the item is added message is displayed
    And select cart from user header
    And change the quantity to "2"
    And verify the message for changing the quantity is displayed

