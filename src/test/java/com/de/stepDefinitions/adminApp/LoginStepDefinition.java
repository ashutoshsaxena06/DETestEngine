package com.de.framework.adminApp.stepDefinitions;

import java.util.List;

import com.de.framework.ConstantsPool.Constants;
import com.de.framework.adminApp.pageObjects.AdminAppLogin;
import com.de.framework.adminApp.pageObjects.AdminHomePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.de.framework.core.DriverManager;
import com.de.framework.commonUtils.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	
	private static final Logger logger = Logger.getLogger(LoginStepDefinition.class);
	private static AdminAppLogin adminAppLogin;
	boolean loginStatus=false;
	List<WebElement> links;
	AdminHomePage adminHomePage;
//	private static String option;
	private static CommonActions commonActions = new CommonActions();

	@Given("^I have \"([^\"]*)\" server adminApp which is up$")
	public void i_have_server_adminApp_which_is_up(String url) {
		Constants.AdminApp.setAdmin_App_Url(url);
		logger.info("The URL recieved is - " + url);
	}

	@When("^I perform healthCheckUp operation of host on adminApp \"([^\"]*)\" server of \"([^\"]*)\" enivronment$")
	public void i_perform_healthCheckUp_operation_of_host_on_adminApp_server_of_enivronment(String browser, String env) throws Throwable {
		DriverManager.getDriver();
		adminAppLogin.launchURL();
		logger.info("Performed the browser open action for environment "+ env);
	}

	@Then("^adminApp Application must be up and running$")
	public void adminapp_Application_must_be_up_and_running() throws Throwable {
		// login.shouldExist(login, 20);
		adminAppLogin = new AdminAppLogin();
		if (adminAppLogin.isExist(adminAppLogin, 10)) {
			logger.info("Application is up and running");
		} else {
			logger.info("Application is down");
			Assert.assertTrue(false);
		}
	}
	
	@Given("^AdminApp url is open$")
	public void adminApp_url_is_open(){
		if(!commonActions.getDriver().getCurrentUrl().equalsIgnoreCase(Constants.AdminApp.getAdmin_App_Url())) {
			commonActions.getDriver().get(Constants.AdminApp.getAdmin_App_Url());
			logger.info("the admin app url is open");
		}
	}

	@When("^I log in as an Admin user in AdminApp$")
	public void i_log_in_as_a_user_in_AdminApp() {
		loginStatus= adminAppLogin.doLogin();
	}

	@Then("^I should be on AdminApp Home Page$")
	public void i_should_be_on_AdminApp_Home_Page() {
	logger.info("performed login operation successfully - " + loginStatus);
	SoftAssert soft = new SoftAssert();
	soft.assertTrue(loginStatus);
	soft.assertTrue(adminHomePage.getUniqueElementInPage().isDisplayed());
	soft.assertAll();
	logger.info("User logged into Home page ..");
	}
}
