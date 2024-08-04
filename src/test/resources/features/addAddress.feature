@AddAddress
Feature: Login on OWASP juice-shop and add Shipping Address
  as user on page juice-shop
  I want to log into my account
  for add two Shipping Address

  Scenario: Login with user correct credentials and add Shipping Address

    Given user enter log in page "https://juice-shop.herokuapp.com/#/login"
    When user log in with credentials
      | jtc@gmail.com | Pass123*/. |
    And user goes to Add New Address "https://juice-shop.herokuapp.com/#/address/saved"
    When user fill out form to New Address
      | Colombia | Matias | 3124567777 | 30567 | Calle falsa 123 | Bucaramanga | Santander |
    And user fill out form twice
      | Colombia | Yeri | 3132423535 | 53455 | Calle 99 31 - 1 | Piedecuesta | Santander |
    Then the addresses are saved