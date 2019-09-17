Feature: Check DiningEdge Login Page Funcationalities

  # Background: Check service is up and running on server
  @smoke
  Scenario Outline: Application is UP
    Given I have "<host>" server which is up
    When I perform healthCheckUp operation of host on "<browser>" server of "<env>" enivronment
    Then Application must be up and running

    Examples: 
      | host                                  | browser | env |
      | http://newdiningedge.baitek.org:8100/ | chrome  | QA  |

  #test 1  check login
  @Login @smoke
  Scenario: Login Scenario
    Given I am in DiningEdge url
    When I log in as a "Admin" user
    Then I should be on Home Page

  #test   check logout
  @Logout 
  Scenario: Login Scenario
    Given I am in DiningEdge url
    When I click on logout button
    Then I should be on login page
    And Close all browsers
