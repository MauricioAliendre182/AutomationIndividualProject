@UI @Cart
Feature: Cart

  @DetailsProductFromCart
  Scenario Outline: A user should be able to go to details product from cart section
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    And I go to cart page using the top menu
    And I go to details product from the product with "<id>" as identifier
    And I go to cart page using the top menu
    And I go to remove a product from cart with "<id>" as identifier
    And I go to check if the product is not present anymore
    Examples:
      | id |scroll |
      | 1  |450    |
      | 2  |450    |
      | 3  |450    |

  @RemoveAProduct
  Scenario Outline: A user should be able to remove a product from cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    And I go to cart page using the top menu
    And I go to remove a product from cart with "<id>" as identifier
    And I go to check if the product is not present anymore
    Examples:
      | id |scroll |
      | 1  |450    |
      | 2  |450    |
      | 3  |450    |

  @CheckoutSameInformation @Test
  Scenario Outline: A user should not be able to fill the checkout form with the same information for every field
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    And I go to cart page using the top menu
    And I go to checkout section
    And I scroll down "<scroll>" and go to payment page
    And I fill every field with the same data which is "<text>"
    And I go to check that the payment can not be process

    Examples:
      | id |scroll |text       |
      | 1  |450    |ajjsjjdjdj |
      | 2  |450    |338484940  |
      | 3  |450    |#$%&^&^*^( |

  @CheckoutCorrectInformation @Test
  Scenario Outline: A user should not be able to fill the checkout form with the same information for every field
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    And I go to cart page using the top menu
    And I go to checkout section
    And I scroll down "<scroll>" and go to payment page
    And I fill every field with the with "<name>" as name, "<card>" as card, "<cvc>" as cvc, "<month>" as month, "<year>" as year
    And I go to check that the payment can be process

    Examples:
      | id |scroll |name              |card        |cvc|month|year|
      | 1  |450    |Mauricio Aliendre |76574653564 |234|07   |2027|
      | 2  |450    |Carlos Garcia     |87564677376 |125|01   |2028|
      | 3  |450    |Fernando Torrez   |95885894844 |672|04   |2026|

