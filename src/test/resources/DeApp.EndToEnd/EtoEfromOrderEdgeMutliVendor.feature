Feature: this feature targets the end to end Ordering flow

  Background:
    Given login to admin app
  # And check if the User and Company exists

  Scenario Outline: Ordering for one vendor : Place order from Order edge
    Given user is on adminApp home page
    When Create a new Company "<companyName>" in adminApp
    And Create "<userName>" and assign "<companyName>" in adminApp
    And Login DE webApp with "<userName>"
    And Go to settings page
    #And Add company Logo
    And Create a new location "<locationName>" with required basic and notification tab details
    Then Verify the created location
    When Create multiple new vendors
      | US Foods |
      | Sysco    |
    Then Verify the created vendors
    When Edit all vendors to add the Order notification E-mail addresses
    And Navigate to manage product list
    And Create a new product list as "<productList>" and assign to "<locationName>"
    Then Verify the created productList
    When Navigate to product list in manage items
    And Import a valid product list file
    Then Verify the count of products imported from product list file
    When Switch to adminApp
    And Go to order guides in vendors in adminApp
    And Create new order guide for vendor using orderGuide in adminApp
      | US Foods | USF GP   |
      | Sysco    | sysco gp |
    Then Verify all the created order guides in adminApp
    When Switch to DE webApp
    And Go to Order Guides
    Then Verify all the created order guides in DE webApp
    When Add comparables for listed product
      | US Foods | Beef Base    |
      | Sysco    | Chicken base |
    And Select products and quantity to order
      | Beef Base    | 10 |
      | Chicken base | 20 |
    And Go to cart using cart icon
    Then Verify the product details on checkout page
    When Submit the Order on checkout page
    Then Verify the Order details on review page
    Examples:
      | companyName        | userName        | locationName | productList   | productQuantity |
      | testCompany10Jan20 | testUser10Jan20 | 10locJan     | myProductList | 10              |
