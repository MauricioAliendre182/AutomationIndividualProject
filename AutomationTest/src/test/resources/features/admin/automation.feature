@UI
Feature: Posts

  @AddToCart
  Scenario Outline: A user should be able to add a product to cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    Examples:
        | id | scroll |
        | 1  | 450    |