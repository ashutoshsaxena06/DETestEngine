@Locations
Feature: this feature file is to test all CRUD operations for Locations on Admin App

  @createLocation @smoke @endToEndOrdering
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

  @editLocation
  Scenario Outline: Edit a User
    Given admin is on the AdminApp home page
    And edit User for company with "<companyName>"
    When admin click on edit icon in actions
    And select the "<companyName>" from company search bar on User Page
    And enter the "<firstName>" and "<userName>" and "<email>" and "<Password>" and "<Roles>" on Edit User page
    And click on Save Changes on Edit User page
    Then User must be updated
    And listed in the Users list with same User ID

    Examples: 
      | companyName        | firstName | userName    | email                      | Roles |
      | automationCompany1 | testUser1 | autoUser111 | ashutoshsaxena06@gmail.com | Both  |
      | automationCompany2 | testUser2 | autoUser121 | ashutoshsaxena06@gmail.com | Owner |

 