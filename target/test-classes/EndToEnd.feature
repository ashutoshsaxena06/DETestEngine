Feature: this feature targets the end to end Ordering flow


  # Background: Check service is up and running on server
  @smoke @endToEnd
  Scenario Outline: Application is UP
    Given I have "<host>" server adminApp which is up
    When I perform healthCheckUp operation of host on adminApp "<browser>" server of "<env>" enivronment
    Then adminApp Application must be up and running


    Examples: 
      | host                                             | browser | env |
      | http://admin.newdiningedge.baitek.org:8100/login | chrome  | QA  |

  #test 1  check login
  @Login @smoke @endToEnd
  Scenario: Login Scenario
    Given AdminApp url is open
    When I log in as an Admin user in AdminApp
    Then I should be on AdminApp Home Page
    
      @createCompany @smoke @endToEnd
  Scenario Outline: Create a company
    Given admin is on the AdminApp home page
    And create company with name "<companyName>"
    When admin click on Add companies
    And enter the company name on Add Companies page
    And click on Save Changes on Add Companies page
    Then Company must be created
    And listed in the companies list with a company ID

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 | 
      
     @createLocation @smoke @endToEnd
  Scenario Outline: Create a User
    Given admin is on the AdminApp home page
    And create User for company with "<companyName>"
    When admin click on Add Users
    And select the "<companyName>" from company search bar on User Page
    And enter the "<firstName>" and "<userName>" and "<email>" and "<Roles>" and password on Add User page
    And click on Save Changes on Add User page
    Then User must be created
    And listed in the Users list with a User ID

    Examples: 
      | companyName        | firstName | userName    | email                      | Roles |
      | automationCompany1 | testUser1 | autoUser111 | ashutoshsaxena06@gmail.com | Both  |
      | automationCompany2 | testUser2 | autoUser121 | ashutoshsaxena06@gmail.com | Owner |
      
      # test 4 creating New Locations from Admin portal
     @createLocation @smoke @endToEnd
  Scenario Outline: Create a Location
    Given admin is on the AdminApp home page
    And create Location for company with "<companyName>"
    When admin click on Add Locations
    And select the "<companyName>" from company search bar on location page
    And enter the "<locationName>" and "<timeZone>" and "<productList>" on Add Locations page
    And click on Save Changes on Add Locations page
    Then Location must be created
    And listed in the Locations list with a Location ID

    Examples: 
      | companyName        | locationName   | timeZone | productList              |
      | automationCompany1 | automationLoc1 | New York | Shipwreck Bar and Grille |
      | automationCompany2 | automationLoc2 | Chicago  | Shipwreck Bar and Grille |
      
       #test 1  check login
  @Login @smoke @endToEnd
  Scenario: Login Scenario
    Given I am in DiningEdge url
    When I log in as a "Admin" user
    Then I should be on Home Page

  #test 2  check link count on home page
  @Home @Links @functional @smoke @endToEnd
  Scenario: check link count on home page
    Given I am in DiningEdge homepage
    When I check click on all links on this page
    And get count
    Then I should be able to click on all links
    And Get total number of links on a page

  #test 4  check side bar options
  @SideBar @functional @smoke @endToEnd
  Scenario Outline: check side bar options
    Given I am in DiningEdge homepage
    When I go to side bar "<option>" available on homepage
    And "<action>" on side bar option
    Then I should be able to click on "<option>"
    And new page linked to that option should be displayed

    Examples: 
      | option         | action |
      | Order Edge     | click  |
      | Order from OG  | click  |
      | Pending Orders | click  |
      | Orders Guides  | click  |
      | Reports        | click  |
      | Manage Items   | click  |
      | Purchases      | click  |

  #test 5  check logout
  @Login @smoke @endToEnd
  Scenario: Login Scenario
    Given I am in DiningEdge url
    When I click on logout button
    Then I should be on login page
    And Close all browsers
      