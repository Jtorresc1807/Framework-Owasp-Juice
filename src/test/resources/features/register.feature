@Register @ui @HU001
@blocker
@allure.label.owner=JaimeT
Feature: Feature: Register on OWASP juice-shop
  as customer on page juice-shop
  I want to register on the page juice-shop.herokuapp.com
  for create orders an do purchase

  Scenario Outline: Scenario: Successful Register to 2 new users

    Given new user is on register page "https://juice-shop.herokuapp.com/#/register"
    When user fill out form with "<Email>" "<Password>" "<Repassword>" "<Answer>"
    And user clicks on register
    Then system create new account for each new user
    Examples:
      | Email          | Password     | Repassword   | Answer |
      | jtc@gmail.com  | Pass123*/.   | Pass123*/.   | Rosita |
      | ymsr@gmail.com | Pass1231*/., | Pass1231*/., | Rumi   |