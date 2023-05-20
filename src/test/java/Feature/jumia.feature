@regression
Feature: NOON EGYPT Scenarios

  Scenario: Create a new account and add items to cart
    Given I am on the homepage
    When I click on the Account -> Sign in link
    And I fill in the registration data with:
      | Full Name | Email              | Password   |
      | John Doe  | johndoe@example.com | test123456 |
    And I submit the registration form
    And I login using the email "johndoe@example.com" and password "test123456"
    And I hover on Fashion -> Shirts
    And I add 2 items to my cart
    And I increase the item quantity from the cart page
    Then the item is added to the cart successfully
    And the subtotal is calculated correctly according to the added item prices

