package com.de.stepDefinitions.deApp;

import com.de.commonUtils.CommonActions;
import com.de.deApp.pageObjects.DEHome;
import com.de.deApp.pageObjects.DELogin;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DEHomeStepDefinition {
//	static WebcommonActions.getDriver() commonActions.getDriver();
//	static String url;
	static DELogin login;
	static DEHome home;
	List<WebElement> links;
	static String option;
	private static CommonActions commonActions = new CommonActions();
/*
	@Given("^I have \"([^\"]*)\" server which is up$")
	public void i_have_server_which_is_up(String url) {
		Constants.DEApp.setde_App_Url(url);
		System.out.println("The URL recieved is - " + url);
	}

	@When("^I perform healthCheckUp operation of host on \"([^\"]*)\" server of \"([^\"]*)\" enivronment$")
	public void i_perform_healthCheckUp_operation_of_host_on_server_of_enivronment(String browser, String env) {
		commonActions.setDriver(browser, Constants.path);
		commonActions.getDriver().get(Constants.DEApp.getde_App_Url());
		System.out.println("Performed the browser open action");
	}

	@Then("^Application must be up and running$")
	public void application_must_be_up_and_running() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// login.shouldExist(login, 20);
		login = new DELogin(commonActions.getDriver());
		if (login.btn_Login.isDisplayed()) {
			System.out.println("Application is up and running");
		} else {
			System.out.println("Application is down");
			Assert.assertTrue(false);
		}
	}

	@Given("^I am in DiningEdge url$")
	public void i_am_in_DiningEdge_url() {
		// commonActions.getDriver().get(url);
		System.out.println("Verified that we are on application login page");
	}

	@When("^I log in as a \"([^\"]*)\" user$")
	public void i_log_in_as_a_user(String admin) {
		commonActions.getDriver().get(Constants.DEApp.getde_App_Url());
		login = new DELogin(commonActions.getDriver());
		login.doLogin(Constants.DEApp.getUsername(), Constants.DEApp.getUsername());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("^I should be on Home Page$")
	public void i_should_be_on_Home_Page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		home = new DEHome(commonActions.getDriver());
		if (home.icon_Home.isDisplayed()) {
			System.out.println("User is on home page");
		} else {
			System.out.println("User is not Logged in");
			Assert.assertTrue(false);
		}
	}

	@Given("^I am in DiningEdge homepage$")
	public void i_am_in_DiningEdge_homepage() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (home.lbl_Home_DE.isDisplayed()) {
			System.out.println("User is on home page");
		} else {
			System.out.println("User is not Logged in");
			Assert.assertTrue(false);
		}
	}

	@When("^I check click on all links on this page$")
	public void i_check_click_on_all_links_on_this_page() {
		links = commonActions.getDriver().findElements(By.tagName("a"));
		try {
			for (int i = 0; i < links.size(); i++) {
				System.out.println(i + " Clicked on link - " + links.get(i).getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^get count$")
	public void get_count() {
		System.out.println("getting total number of links on Home page --- > " + links.size());
	}

	@Then("^I should be able to click on all links$")
	public void i_should_be_able_to_click_on_all_links() {
		System.out.println("Able to click on all links on the page");
	}

	@Then("^Get total number of links on a page$")
	public void get_total_number_of_links_on_a_page() {
		System.out.println("Total number of links on a page --- > " + links.size());

	}

	@When("^I go to side bar \"([^\"]*)\" available on homepage$")
	public void i_go_to_side_bar_available_on_homepage(String option) {
		DEHomeStepDefinition.option = option;
		System.out.println("Moving to side bar option -- " + DEHomeStepDefinition.option);
	}

	@When("^\"([^\"]*)\" on side bar option$")
	public void on_side_bar_option(String action) {
		if (action.equalsIgnoreCase("click")) {
			try {
				if (option.equals("Manage Items")) {
					WebElement we = commonActions.getDriver().findElement(By.xpath("//span[contains(text(),'" + option + "')]"));
					Actions act = new Actions(commonActions.getDriver());
					act.moveToElement(we).doubleClick().build().perform();
				} else {
					WebElement we = commonActions.getDriver().findElement(By.xpath("//span[contains(text(),'" + option + "')]"));
					we.click();
				}
				Thread.sleep(2000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Then("^I should be able to click on \"([^\"]*)\"$")
	public void i_should_be_able_to_click_on(String option) {
		System.out.println("Able to click on - " + DEHomeStepDefinition.option);
	}

	@Then("^new page linked to that option should be displayed$")
	public void new_page_linked_to_that_option_should_be_displayed() {
		try {
			System.out.println("Successfully landed on " + option + " page");
			Thread.sleep(2000);
			home.icon_Home.click();
			System.out.println("Moving back to home page ");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^I click on logout button$")
	public void I_click_on_logout_button() {
		if (home.logout()) {
			System.out.println("Able to Logout");
		} else {
			System.out.println("Not able to clock on Logout");
		}
	}

	@Then("^I should be on login page$")
	public void I_should_be_on_login_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// login.shouldExist(login, 20);
		login = new DELogin(commonActions.getDriver());
		if (login.btn_Login.isDisplayed()) {
			System.out.println("User logged out of Application");
		} else {
			System.out.println("Logout Failed");
			Assert.assertTrue(false);
		}
	}

	@Then("^Close all browsers$")
	public void Close_all_browsers() {
		try {
			commonActions.getDriver().quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
