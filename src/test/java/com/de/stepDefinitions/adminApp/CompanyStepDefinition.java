package com.de.framework.adminApp.stepDefinitions;

import com.de.framework.adminApp.pageObjects.AdminHomePage;
import com.de.framework.adminApp.pageObjects.Companies;
import com.de.framework.adminApp.pageObjects.Company;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompanyStepDefinition {

	private static final Logger logger = Logger.getLogger(CompanyStepDefinition.class);
	public static String companyName;
	Company.CreateCompany createCompany;
	Company.EditCompany editCompany;
	Companies.Actions actions;
	Companies companies;
	AdminHomePage adminHomepage;
	
	@Given("^create company with name \"([^\"]*)\"$")
	public void create_company_with_name(String compName) {
		logger.info("creating company with name - " + compName);
		companyName = compName;
	}

	@When("^admin click on Add companies$")
	public void admin_click_on_Add_companies() {
		companies = new Companies();
		companies.getLnk_Add().click();
		createCompany = new Company.CreateCompany();
		Assert.assertTrue(createCompany.isExist(createCompany, 10));
	}

	@When("^enter the company name on Add Companies page$")
	public void enter_the_company_name_on_Add_Companies_page() {
		createCompany.inputCompanyName(companyName);
	}

	@When("^click on Save Changes on Add Companies page$")
	public void click_on_Save_Changes_on_Add_Companies_page() {
		createCompany.saveChanges();
	}

	@Then("^Company must be created$")
	public void company_must_be_created() {
		Assert.assertThat(adminHomepage.getCellFromList("Name", companyName).getText(), Matchers.containsString(companyName));
		
	}

	@Then("^listed in the companies list with a company ID$")
	public void listed_in_the_companies_list_with_a_company_ID() {
		logger.info("new company is listed with ID - "+ companies.getCompanyID(companyName));
		Assert.assertNotNull(companies.getCompanyID(companyName));
	}

	@Given("^Edit company with name \"([^\"]*)\"$")
	public void edit_company_with_name(String compName) {
		editCompany = new Company.EditCompany();
		companyName = compName;
		logger.info("edit company and it name - " + compName);
	}

	@When("^admin click on edit company icon in actions$")
	public void admin_click_on_edit_company_icon_in_actions() {
		new Companies.Actions().getAction("edit").click();
	}

	@When("^enter the company name on Edit Companies page$")
	public void enter_the_company_name_on_Edit_Companies_page() {
		logger.info("displaying page - "+ editCompany.getUniqueElementInPage().getText());
		editCompany.inputCompanyName(companyName);
	}

	@When("^click on Save Changes on Edit Companies page$")
	public void click_on_Save_Changes_on_Edit_Companies_page() {
		editCompany.saveChanges();
	}

	@Then("^Company must be edited$")
	public void company_must_be_edited() {
		Assert.assertThat(adminHomepage.getCellFromList("Name", companyName).getText(), Matchers.containsString(companyName));
	}

	@Then("^listed in the companies list with same company ID$")
	public void listed_in_the_companies_list_with_same_company_ID() {
		logger.info("edited company is listed with ID - "+ companies.getCompanyID(companyName));
		Assert.assertNotNull(companies.getCompanyID(companyName));
	}

	@Given("^Deactivate company with name \"([^\"]*)\"$")
	public void deactivate_company_with_name(String arg1) {

	}

	@When("^admin click on deactivate icon in actions$")
	public void admin_click_on_deactivate_icon_in_actions() {

	}

	@When("^enter the company name on Deactivate Companies page$")
	public void enter_the_company_name_on_Deactivate_Companies_page() {

	}

	@When("^click on Save Changes on Deactivate Companies page$")
	public void click_on_Save_Changes_on_Deactivate_Companies_page() {

	}

	@Then("^Company must be Deactivated$")
	public void company_must_be_Deactivated() {

	}

	@Then("^listed in the companies list with deactivated icon$")
	public void listed_in_the_companies_list_with_deactivated_icon() {

	}

	@Given("^Show company with name \"([^\"]*)\"$")
	public void show_company_with_name(String arg1) {

	}

	@When("^admin click on show icon in actions$")
	public void admin_click_on_show_icon_in_actions() {

	}

	@When("^enter the company name on Show Companies page$")
	public void enter_the_company_name_on_Show_Companies_page() {

	}

	@When("^click on Save Changes on Show Companies page$")
	public void click_on_Save_Changes_on_Show_Companies_page() {

	}

	@Then("^Company must be Shown$")
	public void company_must_be_Shown() {

	}

	@Then("^with same company ID and all company coulumns details$")
	public void with_same_company_ID_and_all_company_coulumns_details() {

	}

	@When("^admin click on delete icon in actions$")
	public void admin_click_on_delete_icon_in_actions() {

	}

	@When("^confirms the delete in pop up$")
	public void confirms_the_delete_in_pop_up() {

	}

	@Then("^Company must be deleted$")
	public void company_must_be_deleted() {

	}

	@Then("^same company ID must be removed from companies list$")
	public void same_company_ID_must_be_removed_from_companies_list() {

	}
}
