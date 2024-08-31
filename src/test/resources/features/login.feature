@Login @ui @HU002
@critical
@allure.label.owner=JaimeT
Feature: Feature: Login on OWASP juice-shop
  as user on page juice-shop
  I want to log into my account
  for make a purchase

  Background:
    Given The user is on the login page "https://juice-shop.herokuapp.com/#/login"

  Scenario: Scenario: Login with user correct credentials
    When user fill out form with credentials ok
      | jtc@gmail.com | Pass123*/. |
    And user clicks on Log In
    Then user logs into his account

  Scenario: Scenario: Login with Failed login
    When user fill out form with credentials fails
      | jtc123@gmail.com | Pass123*/.Fail |
    And user clicks on Log In
    Then user see Invalid email or password


