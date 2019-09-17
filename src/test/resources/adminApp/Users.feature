@Locations
Feature: this feature file is to test all CRUD operations for Locations on Admin App

  @createLocation @smoke @endToEndOrdering
  Scenario Outline: Create a User
    Given User is on the AdminApp home page
    And create User for company with "<companyName>"
    When User click on Add Users
    And select the "<companyName>" from company search bar
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
    Given User is on the AdminApp home page
    And edit User for company with "<companyName>"
    When User click on edit icon in actions
    And select the "<companyName>" from company search bar
    And enter the "<firstName>" and "<userName>" and "<email>" and "<Password>" and "<Roles>" on Edit User page
    And click on Save Changes on Edit User page
    Then User must be updated
    And listed in the Users list with same User ID

    Examples: 
      | companyName        | firstName | userName    | email                      | Roles |
      | automationCompany1 | testUser1 | autoUser111 | ashutoshsaxena06@gmail.com | Both  |
      | automationCompany2 | testUser2 | autoUser121 | ashutoshsaxena06@gmail.com | Owner |

  @editLocation
  Scenario Outline: Edit a Location
    Given User is on the AdminApp home page
    And create Location for company with "<companyName>"
    When User click on edit icon in actions
    And select the "<companyName>" from company search bar
    And enter the "<locationName>" and "<timeZone>" and "<productList>" on Add Locations page
    And click on Save Changes on Edit Locations page
    Then Location must be updated
    And listed in the Locations list with a Location ID

    Examples: 
      | companyName        | locationName   | timeZone | productList              |
      | automationCompany1 | automationLoc1 | Chicago  | Shipwreck Bar and Grille |
      | automationCompany2 | automationLoc2 | New York | Shipwreck Bar and Grille |

  @editLocation
  Scenario Outline: Deactivate a Location
    Given User is on the AdminApp home page
    And Deactivate Location with name "<companyName>"
    When User click on deactivate icon in actions
    And enter the Location name on Deactivate Locations page
    And click on Save Changes on Deactivate Locations page
    Then Location must be Deactivated
    And listed in the Locations list with deactivated icon

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |

  @showLocation
  Scenario Outline: Show a Location
    Given User is on the AdminApp home page
    And Show Location with name "<companyName>"
    When User click on show icon in actions
    And enter the Location name on Show Locations page
    And click on Save Changes on Show Locations page
    Then Location must be Shown
    And with same Location ID and all Location coulumns details

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |

  @deleteLocation
  Scenario Outline: Delete a Location
    Given User is on the AdminApp home page
    And Edit Location with name "<companyName>"
    When User click on delete icon in actions
    And confirms the delete in pop up
    Then Location must be deleted
    And same Location ID must be removed from Locations list

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |
