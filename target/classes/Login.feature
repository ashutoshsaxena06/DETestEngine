Feature: Check AdminApp Login Page Funcationalities

  # Background: Check service is up and running on server
  @smoke
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

  #test   check logout
  @Logout
  Scenario: Login Scenario
    Given AdminApp url is open
    When I click on logout button
    Then I should be on login page
    And Close all browsers
