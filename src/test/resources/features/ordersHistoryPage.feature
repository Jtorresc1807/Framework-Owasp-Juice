@OrdersHistory @ui @HU006
@minor
@allure.label.owner=JaimeT
Feature: Feature: Login on OWASP juice-shop and take screenshot to orders
  as user on page juice-shop
  I want to log into my account
  for take screenshot to orders

  Scenario: Scenario: Login with user correct credentials for take screenshot to orders

    Given user enter log in page "https://juice-shop.herokuapp.com/#/login"
    When user log in with credentials
      | jtc@gmail.com | Pass123*/. |
    Then user enter in page "https://juice-shop.herokuapp.com/#/order-history"
    And take screenshot to purchase orders and save to "My_screenshot"