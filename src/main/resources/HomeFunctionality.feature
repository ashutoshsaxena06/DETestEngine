Feature: Check DiningEdge Home Page Funcationalities

  # Background: Check service is up and running on server
  @smoke
  Scenario Outline: Application is UP
    Given I have "<host>" server which is up
    When I perform healthCheckUp operation of host on "<browser>" server of "<env>" enivronment
    Then Application must be up and running

    Examples: 
      | host                                  | browser | env |
      | http://newdiningedge.baitek.org:8000/ | chrome  | QA  |

  #test 1  check login
  @Login @smoke
  Scenario: Login Scenario
    Given I am in DiningEdge url
    When I log in as a "Admin" user
    Then I should be on Home Page

  #test 2  check link count on home page
  @Home @Links @functional @smoke
  Scenario: check link count on home page
    Given I am in DiningEdge homepage
    When I check click on all links on this page
    And get count
    Then I should be able to click on all links
    And Get total number of links on a page

  #test 4  check side bar options
  @SideBar @functional @smoke
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
  @Login @smoke
  Scenario: Login Scenario
    Given I am in DiningEdge url
    When I click on logout button
    Then I should be on login page
    And Close all browsers
