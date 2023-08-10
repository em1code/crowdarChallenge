@AddToCart

Feature: Add products to cart functionality

    As a user I want to be able to add products to my shopping car.
    So that I can make purchases on the website.

    Background: Successful login in Product Page
        Given I am on the login page
        And I see the title Swag Labs
        When I enter the username standard_user and the password secret_sauce
        And I click the login button
        Then I should see the products page correctly

    Scenario Outline: Add multiple products to the cart
        Given I add the product <product> to the shopping cart
        And I should see the shopping cart icon with a quantity of <n>
        When I click on shopping cart icon
        Then the shopping cart displays the product <product>

        Examples:
            | product                           | n |
            | Sauce Labs Backpack               | 1 |
            | Sauce Labs Bolt T-Shirt           | 2 |
            | Sauce Labs Fleece Jacket          | 3 |
            | Sauce Labs Onesie                 | 4 |
            | Test.allTheThings() T-Shirt (Red) | 5 |
            | Sauce Labs Bike Light             | 6 |

    Scenario Outline: Remove products from the cart
        Given the shopping cart displays the product <product>
        And I should see the shopping cart icon with a quantity of <number>
        When I click on shopping cart icon
        And I click on Remove <product> button
        Then the product <product> should be no longer displayed

        Examples:
            | product                           | number |
            | Sauce Labs Backpack               | 6      |
            | Sauce Labs Bolt T-Shirt           | 5      |
            | Sauce Labs Fleece Jacket          | 4      |
            | Sauce Labs Onesie                 | 3      |
            | Test.allTheThings() T-Shirt (Red) | 2      |
            | Sauce Labs Bike Light             | 1      |

    Scenario Outline: Validate the title, description and price of the added product
        Given I add the product <product> to the shopping cart
        When I click on shopping cart icon
        Then I should see the same <product>, "<description>" and <price> that the product had before

        Examples:
            | product                  | description                                                                                                                                                            | price  |
            | Sauce Labs Bike Light    | A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.        | $9.99  |
            | Sauce Labs Bolt T-Shirt  | Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.                        | $15.99 |
            | Sauce Labs Fleece Jacket | It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office. | $49.99 |

# Scenario: Add a product to an empty cart
#     Given I add the product Sauce Labs Backpack to the cart
#     And I should see the shopping cart icon with a quantity of 1
#     When I click on shopping cart icon
#     Then the shopping cart displays the product Sauce Labs Backpack with a quantity of 1

# Scenario: Add multiple units of the same product
#     Given I add to the cart the product Sauce Labs Bike Light
#     And I should see the shopping cart icon with a quantity of 1
#     When I click again in Add to cart button
#     Then I should see the shopping cart icon with a quantity of 2

# Scenario: Update product quantity in the cart
#     Given I has the product Sauce Labs Bike Light in the cart with a quantity of 2
#     When the user modifies the quantity of Sauce Labs Bike Light to 4
#     Then the shopping cart displays Sauce Labs Bike Light with a quantity of 4

# Scenario: Add products with limited quantity
#     Given the product Sauce Labs Fleece has an maximum capacity of 5 units
#     When I adds 6 units of Sauce Labs Fleece to the cart
#     Then An error message is diplayed indicating that the product Sauce Labs Fleece has a quantity of 5

# Scenario: Navigate to Checkout page
#     Given I has added a product in my shopping cart
#     And I click the Checkout button
#     Then I should see the Checkout page

# Scenario: Can not access to Checkout page
#     Given I don't has any product in my shopping cart
#     And I click the Checkout button
#     Then An error message is displayed indicating that I need add at least one product to proceed to Checkout