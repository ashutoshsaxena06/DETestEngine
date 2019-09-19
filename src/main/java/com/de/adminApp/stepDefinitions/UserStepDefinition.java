package com.de.adminApp.stepDefinitions;

import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import org.junit.Assert;

import com.de.adminApp.pages.Companies;
import com.de.adminApp.pages.GlobalPage;
import com.de.adminApp.pages.User;
import com.de.adminApp.pages.Users;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStepDefinition extends GlobalStepDefinition {

	private static final Logger logger = Logger.getLogger(CompanyStepDefinition.class);
	public static String companyName;
	public User user;
	public Companies.Actions actions;
	public Users users;

	@Given("^create User for company with \"([^\"]*)\"$")
	public void create_User_for_company_with(String compName) {
		logger.info("creating user with name - " + compName);
		companyName = compName;
		globalPage = new GlobalPage(getDriver());
	}

	@When("^admin click on Add Users$")
	public void admin_click_on_Add_Users() {
		users = new Users(getDriver());
		globalPage.lnk_Add.click();
		user = new User(getDriver());
		Assert.assertTrue(user.isExist(user, 10));
	}

	@When("^select the \"([^\"]*)\" from company search bar on User Page$")
	public void select_the_from_company_search_bar_on_User_Page(String arg1) {
		logger.info("entering User details..");
	}

	@When("^enter the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and password on Add User page$")
	public void enter_the_and_and_and_and_password_on_Add_User_page(String firstName, String userName, String email,
			String roles) {
		user.addUser(companyName, firstName, userName, email, roles);
	}

	@When("^click on Save Changes on Add User page$")
	public void click_on_Save_Changes_on_Add_User_page() {
		user.saveChanges();
	}

	@Then("^User must be created$")
	public void user_must_be_created() {
		Assert.assertThat(globalPage.getCellFromList("Name", companyName).getText(),
				Matchers.containsString(companyName));
	}

	@Then("^listed in the Users list with a User ID$")
	public void listed_in_the_Users_list_with_a_User_ID() {

		logger.info("new user is listed with ID - " + users.getUserID(companyName));
		Assert.assertNotNull(users.getUserID(companyName));
	}

	@Given("^edit User for company with \"([^\"]*)\"$")
	public void edit_User_for_company_with(String arg1) {

	}

	@When("^enter the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" on Edit User page$")
	public void enter_the_and_and_and_and_on_Edit_User_page(String arg1, String arg2, String arg3, String arg4,
			String arg5) {

	}

	@When("^click on Save Changes on Edit User page$")
	public void click_on_Save_Changes_on_Edit_User_page() {

	}

	@Then("^User must be updated$")
	public void user_must_be_updated() {

	}

	@Then("^listed in the Users list with same User ID$")
	public void listed_in_the_Users_list_with_same_User_ID() {

	}

}
