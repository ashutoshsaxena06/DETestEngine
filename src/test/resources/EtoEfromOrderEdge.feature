@EndToEndOrdering
Feature: this feature targets the end to end Ordering flow

  Background:
   Given login to admin app

  # And check if the User and Company exists
  @EndToEndOrdering @Ordering @OrderEdge
  Scenario Outline: Ordering for one vendor : Place order from Order edge
    Given user is on adminApp home page
    When Create a new Company "<companyName>" in adminApp
    And Create "<userName>" and assign "<companyName>" in adminApp
    And Login DE webApp with "<userName>"
    And Go to settings page
    #And Add company Logo
    And Create a new location "<locationName>" with required basic and notification tab details
    Then Verify the created location
    When Create a new vendor "<vendorName>"
    Then Verify the created vendor "<vendorName>"
    When Edit vendor to add the Order notification E-mail addresses
    And Navigate to manage product list
    And Create a new product list as "<productList>" and assign to "<locationName>"
    Then Verify the created productList
    When Navigate to product list in manage items
    And Import a valid product list file
    Then Verify the count of products imported from product list file
    When Switch to adminApp
    And Go to order guides in vendors in adminApp
    And Create a new order guide with file "<orderGuide>" in adminApp
    Then Verify the created order guide in adminApp
    When Switch to DE webApp
    And Go to Order Guides
    Then Verify the created order guide in DE webApp
    When Add comparable for a product
    And Select quantity "<productQuantity>" to order
    And Go to cart using cart icon
    Then Verify the product details on checkout page
    When Submit the Order on checkout page
    Then Verify the Order details on review page

    Examples: 
      | companyName         | userName       | locationName | vendorName | productList  | orderGuide | productQuantity |
      | testCompany6Nov19   | testUser3Oct19 | 2Oct         | US Foods   | productList1 | USF GP     |              10 |
     # | testCompany7Oct19 | testUser7Oct19 | 7Oct         | Sysco      | productList2 | sysco gp   |              20 |
