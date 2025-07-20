Feature: Purchase the Order from Ecommerce WebSite
  Description of the feature (optional).

  Background:
    Given Open the browser

  Scenario Outline: Postive way to purchase the order
    Given Login with  valid "<email>" and "<password>"
    When I add product to the cart "<item>"
    And Checkout the item "<item>" and submit the order
    Then "Thankyou for the order." should be displayed
    And Close the browser

    Examples:
      | email                     | password         | item            |
      | dharanidhar220@gmail.com  | Ilovecricket@123 | ZARA COAT 3     |
      | dharanidhar2211@gmail.com | Ilovecricket@123 | ADIDAS ORIGINAL |