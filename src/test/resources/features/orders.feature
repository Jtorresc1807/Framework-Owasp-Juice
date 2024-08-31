@Orders @ui @HU005
@critical
@allure.label.owner=JaimeT

Feature: Feature: Login on OWASP juice-shop and add products to basket and do purchase
  as user on page juice-shop
  I want to log into my account
  for add products to basket and do purchase

  Background:
    Given The user is on the login page "https://juice-shop.herokuapp.com/#/login"
    When user log in with credentials
      | jtc@gmail.com | Pass123*/. |

  Scenario: Scenario: Login with user correct and add 3 products (Apple, Banana, T-shirt) to basket and do purchase
    Then user add 3 products (Apple, Banana, T-shirt) to basket
      | Apple Juice | Banana | T-Shirt |
    When select second address and first payment methods
    And do purchase

  Scenario: Scenario: Login with user correct and add 2 products random to basket and do purchase
    Then user add two products to basket
    When select second address and first payment methods
    And do purchase