@checkout
Feature: Checkout

    #Background : If we have a long setup or given before the test,we are breaking this given or setup operations into Background
 Background:
   Given user is actually successfully login

  Scenario Outline: Order Checkout
    When I click on item with name "<Item>"
    And I click on the ADD TO CART button
    And I click on the SHOPPING CART button
    And I click on theCHECKOUT button
    And I enter the order information "<Firstname>", "<Lastname>" and "<Zip>"
    And I click on continue button
    Then Item name matches that of "<Item>"

    Examples:
    |Item                     | Firstname | Lastname | Zip  |
    |Sauce Labs Bike Light    |test       |test      | 12345|
    |Sauce Labs Backpack      |test2      |test2     | 12345|
    |Sauce Labs Fleece Jacket |test3      |test3     | 23456|


