@UI @Products
Feature: Products

  @AddToCart
  Scenario Outline: A user should be able to add a product to cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    Examples:
        | id | scroll |
        | 1  | 450    |

  @AddToCartFromDetails
  Scenario Outline: A user should be able to add a product to cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to details product with "<id>" as identifier and scroll down "<scroll>"
    And I go to add the product to cart from product details section
    Examples:
      | id | scroll |
      | 1  | 450    |

  @CategoryProducts
  Scenario Outline: A user should be able to add a product to cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to category products and select the category "<category>" and subcategory "<subcategory>" as identifier and scroll down "<scroll>"
    And I go to check if the products belong to the category "<category>" and subcategory "<subcategory>"
    Examples:
      |category |subcategory |scroll |
      |Women    |Tops        |450    |
      |Men      |Jeans       |450    |