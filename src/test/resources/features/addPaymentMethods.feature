@AddPayMet
Feature: Login on OWASP juice-shop and add Payment Methods
  as user on page juice-shop
  I want to log into my account
  for add two Payment Methods


  Scenario: Login with user correct credentials and add Payment Methods

    Given user enter log in page "https://juice-shop.herokuapp.com/#/login"
    When user log in with credentials
      | jtc@gmail.com | Pass123*/. |
    And user goes to Add New Payment Methods "https://juice-shop.herokuapp.com/#/saved-payment-methods"
    When user fill out form to add Payment Methods
          | Visa | 4917484589897107 |
    And user fill out form with new Payment Method
      | Mastercard | 5425233430109903 |
    Then the Payment Methods are saved