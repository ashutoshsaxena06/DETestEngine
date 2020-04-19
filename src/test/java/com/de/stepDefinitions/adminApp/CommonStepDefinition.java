package com.de.framework.adminApp.stepDefinitions;

import com.de.framework.adminApp.pageObjects.AdminAppLogin;
import org.apache.log4j.Logger;

import cucumber.api.java.en.Given;

public class CommonStepDefinition {
	private static Logger logger = Logger.getLogger(CommonStepDefinition.class);
	private static AdminAppLogin login = new AdminAppLogin();

	@Given("^admin is on the AdminApp home page$")
	public void admin_is_on_the_AdminApp_home_page() {
		logger.info("Admin app home page displayed - ");
		// logger.info(new
		// Companies(getDriver()).getUniqueElementInPage().isDisplayed()); //? true :
		// login.doLogin()
		// Assert.assertTrue(globalPage.getUniqueElementInPage().isDisplayed());
	}
}
