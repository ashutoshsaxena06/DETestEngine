
@companies
Feature: this feature file is to test all CRUD operations for Companies on Admin App

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

  @editCompany
  Scenario Outline: Edit a company
    Given admin is on the AdminApp home page
    And Edit company with name "<companyName>"
    When admin click on edit company icon in actions
    And enter the company name on Edit Companies page
    And click on Save Changes on Edit Companies page
    Then Company must be edited
    And listed in the companies list with same company ID

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |
      
   @editCompany
  Scenario Outline: Deactivate a company
    Given admin is on the AdminApp home page
    And Deactivate company with name "<companyName>"
    When admin click on deactivate icon in actions
    And enter the company name on Deactivate Companies page
    And click on Save Changes on Deactivate Companies page
    Then Company must be Deactivated
    And listed in the companies list with deactivated icon

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |
      
    @showCompany
  Scenario Outline: Show a company
    Given admin is on the AdminApp home page
    And Show company with name "<companyName>"
    When admin click on show icon in actions
    And enter the company name on Show Companies page
    And click on Save Changes on Show Companies page
    Then Company must be Shown
    And with same company ID and all company coulumns details

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |
      

     @deleteCompany
  Scenario Outline: Delete a company
    Given admin is on the AdminApp home page
    And Edit company with name "<companyName>"
    When admin click on delete icon in actions
    And confirms the delete in pop up
    Then Company must be deleted
    And same company ID must be removed from companies list

    Examples: 
      | companyName     |
      | automationTest1 |
      | automationTest2 |