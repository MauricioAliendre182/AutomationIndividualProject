@UI @Products
Feature: Products

  @AddToCart
  Scenario Outline: A user should be able to add a product to cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to add a product to the cart with "<id>" as identifier and scroll down "<scroll>"
    And I go to cart page using the top menu
    And I go to remove a product from cart with "<id>" as identifier
    Examples:
        | id | scroll |
        | 1  | 450    |
        | 2  | 450    |
        | 3  | 450    |

  @AddToCartFromDetails
  Scenario Outline: A user should be able to add a product to cart
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to details product with "<id>" as identifier and scroll down "<scroll>"
    And I go to add the product to cart from product details section
    And I go to cart page using the top menu
    And I go to remove a product from cart with "<id>" as identifier
    Examples:
      | id | scroll |
      | 1  | 450    |
      | 2  | 450    |
      | 3  | 450    |

  @CategoryProducts
  Scenario Outline: A user should be able to filter the products by category and subcategory
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to category products and select the category "<category>" and subcategory "<subcategory>" as identifier and scroll down "<scroll>"
    And I go to check if the products belong to the category "<category>" and subcategory "<subcategory>"
    Examples:
      |category |subcategory |scroll |
      |Women    |Tops        |450    |
      |Men      |Jeans       |450    |

  @BrandProducts
  Scenario Outline: A user should be able to filter the products by brand
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to brand section and select the brand "<brand>" as identifier and scroll down "<scroll>"
    And I go to check if the products belong to the brand "<brand>" and the section "<section>"
    Examples:
      |brand          |section |scroll |
      |Polo           |Brand   |450    |
      |Madame         |Brand   |450    |
      |Mast & Harbour |Brand   |450    |

  @SetANegativeNumber
  Scenario Outline: A user should not be able to set a negative number in quantity products
    Given I am logged in to automation exercise page
    When I go to Products page using the top menu
    And I go to details product with "<id>" as identifier and scroll down "<scroll>"
    And I set the number "<number>" in quantity part from details product
    And I go to cart page using the top menu
    And I go to remove a product from cart with "<id>" as identifier
    And I go to check if the product had a negative number in quantity
    Examples:
      | id | scroll | number  |
      | 1  |450     | -9      |
      | 2  |450     | -7      |