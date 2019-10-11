package com.de.adminApp.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.de.ConstantsPool.Constants;
import com.de.core.DriverManager;
import com.de.managers.DataManager;
import com.de.reporting.Reporter;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.Select;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Roles;

public class User extends AdminHomePage {

	private static Logger logger = Logger.getLogger(User.class);

	public User() {
		super("User");
	}

	// String loc_ll_companyName = "//li[contains(.,'companyName')]";
	// By loc_ul_companies = By.xpath("//ul[@id='select2-users_company-results']");
	By loc_lbl_UserPageTitle = By.xpath("//h1[contains(.,'User')]");
	By loc_ddl_companyList = By.xpath("//select[@id='users_company']");
	By loc_txt_firstname = By.xpath("//input[@id='users_firstName']");
	By loc_txt_lastName = By.xpath("//input[@id='users_lastName']");
	By loc_txt_userName = By.xpath("//input[@id='users_username']");
	By loc_txt_email = By.xpath("//input[@id='users_email']");
	By loc_chk_enabled = By.xpath("//input[@id='users_enabled']");
	By loc_txt_password = By.xpath("//input[@id='users_plainPassword']");
	By loc_ddl_roles = By.xpath("//select[@id='users_roles']");

	// public UIElement getLl_companyName(String companyName) {
	// return new UIElement(By.xpath(loc_ll_companyName.replace("companyName",
	// companyName)), getPageName(), "ll-company-name");
	// }
	//
	// public UIElement getUl_companies() {
	// return new UIElement(loc_ul_companies, getPageName(),
	// "ul-company-name-list");
	// }

	public UIElement getLbl_UserPageTitle() {
		return new UIElement(loc_lbl_UserPageTitle, getPageName(), "lbl-page-title");
	}

	public Select getDdl_companyList() {
		return new Select(loc_ddl_companyList, getPageName(), "ddl-company-list");
	}

	public TextBox getTxt_firstname() {
		return new TextBox(loc_txt_firstname, getPageName(), "txt-firstname");
	}

	public TextBox getTxt_lastName() {
		return new TextBox(loc_txt_lastName, getPageName(), "txt-lastname");
	}

	public TextBox getTxt_userName() {
		return new TextBox(loc_txt_userName, getPageName(), "txt-username");
	}

	public TextBox getTxt_email() {
		return new TextBox(loc_txt_email, getPageName(), "txt-email");
	}

	public CheckBox getChk_enabled() {
		return new CheckBox(loc_chk_enabled, getPageName(), "chk-enabled");
	}

	public TextBox getTxt_password() {
		return new TextBox(loc_txt_password, getPageName(), "txt-password");
	}

	public Select getDdl_roles() {
		return new Select(loc_ddl_roles, getPageName(), "ddl-roles");
	}

	public void addUser(String companyName, String firstName, String userName, String email) {
		userUpdateWithValues(
				companyName != null && !companyName.isEmpty() ? companyName : Constants.AdminApp.defaultCompanyName,
				firstName != null && !firstName.isEmpty() ? firstName : Constants.AdminApp.defaultFirstName,
				userName != null && !userName.isEmpty() ? userName : Constants.AdminApp.defaultUserName,
				email != null && !email.isEmpty() ? email : Constants.AdminApp.defaultEmail);
	}

	public void userUpdateWithValues(String companyName, String firstName, String userName, String email) {
		Reporter.report.info("creating user using values - " + companyName, firstName, userName, email);

		selectAndAddCompany(companyName);
		getTxt_firstname().clearAndType(firstName);
		getTxt_lastName().clearAndType(Constants.AdminApp.defaultLasttName);
		getTxt_userName().clearAndType(userName);
		getTxt_email().clearAndType(email);
		getTxt_password().clearAndType(Constants.AdminApp.defaultPassword);
		if (!getChk_enabled().isChecked()) {
			getChk_enabled().check();
		}
		// enterRoles(roles);
		getDdl_roles().selectByVisibleText(Roles.ROLE_OWNER.name());
		saveChanges();
		DataManager.setCredentials(userName, Constants.AdminApp.defaultPassword);
	}

	public void enterRoles(String roles) {
		if (roles.equalsIgnoreCase("both")) {
			org.openqa.selenium.interactions.Actions act = new org.openqa.selenium.interactions.Actions(getDriver());
			act.keyDown(Keys.CONTROL).perform();
			getDdl_roles().selectByVisibleText(Roles.ROLE_OWNER.name());
			getDdl_roles().selectByVisibleText(Roles.ROLE_USER.name());
			act.keyUp(Keys.CONTROL).perform();
		} else if (roles.equalsIgnoreCase("user")) {
			getDdl_roles().selectByVisibleText(Roles.ROLE_USER.name());
		} else if (roles.equalsIgnoreCase("owner")) {
			getDdl_roles().selectByVisibleText(Roles.ROLE_OWNER.name());
		}
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getLbl_UserPageTitle();
	}

}
