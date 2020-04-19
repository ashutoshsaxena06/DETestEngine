@Locations
Feature: this feature file is to test all CRUD operations for Locations on Admin App

  @createLocation @smoke @endToEndOrdering
  Scenario Outline: Create a Location
    Given admin is on the AdminApp home page
    And create Location for company with "<companyName>"
    When admin click on Add Locations
    And select the "<companyName>" from company search bar on Location page
    And enter the "<locationName>" and "<timeZone>" and "<productList>" on Add Locations page
    And click on Save Changes on Add Locations page
    Then Location must be created
    And listed in the Locations list with a Location ID

    Examples: 
      | companyName        | locationName   | timeZone | productList              |
      | automationCompany1 | automationLoc1 | New York | Shipwreck Bar and Grille |
      | automationCompany2 | automationLoc2 | Chicago  | Shipwreck Bar and Grille |

  @editLocation
  Scenario Outline: Edit a Location
    Given admin is on the AdminApp home page
    And create Location for company with "<companyName>"
    When admin click on edit location icon in actions
    And select the "<companyName>" from company search bar on Location page
    And enter the "<locationName>" and "<timeZone>" and "<productList>" on Add Locations page
    And click on Save Changes on Edit Locations page
    Then Location must be updated
    And listed in the Locations list with a Location ID

    Examples: 
      | companyName        | locationName   | timeZone | productList              |
      | automationCompany1 | automationLoc1 | Chicago  | Shipwreck Bar and Grille |
      | automationCompany2 | automationLoc2 | New York | Shipwreck Bar and Grille |

  @deactivateLocation
  Scenario Outline: Deactivate a Location
    Given admin is on the AdminApp home page
    And Deactivate Location with name "<companyName>"
    When admin click on deactivate location icon in actions
    And enter the Location name on Deactivate Locations page
    And click on Save Changes on Deactivate Locations page
    Then Location must be Deactivated
    And listed in the Locations list with deactivated location icon

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |

  @showLocation
  Scenario Outline: Show a Location
    Given admin is on the AdminApp home page
    And Show Location with name "<companyName>"
    When admin click on show location icon in actions
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
    Given admin is on the AdminApp home page
    And Edit Location with name "<companyName>"
    When admin click on delete location icon in actions
    And confirms the delete in pop up
    Then Location must be deleted
    And same Location ID must be removed from Locations list

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |
