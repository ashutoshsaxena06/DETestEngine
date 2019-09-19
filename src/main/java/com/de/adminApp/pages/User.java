package com.de.adminApp.pages;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.de.ConstantsPool.Constants;
import com.framework.commonUtils.Roles;

public class User extends GlobalPage{

	private static Logger logger = Logger.getLogger(User.class);
	
	public User(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(@title,'User')]")
	public WebElement lbl_UserPageTitle; 

	@FindBy(xpath="//select[@id='users_company']")
	public WebElement ddl_companyList;

	@FindBy(xpath="///input[@id='users_firstName']")
	public WebElement txt_firstname;

	@FindBy(xpath="//input[@id='users_lastName']")
	public WebElement txt_lastName;

	@FindBy(xpath="//input[@id='users_username']")
	public WebElement txt_userName;

	@FindBy(xpath="//input[@id='users_email']")
	public WebElement txt_email;

	@FindBy(xpath="//input[@id='users_enabled']")
	public WebElement chk_enabled;

	@FindBy(xpath="//input[@id='users_plainPassword']")
	public WebElement txt_password;

	@FindBy(xpath="//select[@id='users_roles']")
	public WebElement ddl_roles;
	
	public void addUser(String companyName, String firstName, String userName, String email, String roles) {
		if (companyName !=null && userName != null && email!=null && roles != null) {
			logger.info("creating user using values - " + Arrays.asList(companyName,firstName,userName, email, roles));
			userUpdateWithValues(companyName, firstName, userName, email, roles);
		}else {
			logger.info("creating user using values all default values");
			userUpdateWithValues(Constants.AdminApp.defaultCompanyName, Constants.AdminApp.defaultFirstName, Constants.AdminApp.defaultUserName, Constants.AdminApp.defaultEmail, roles);
		}
	}


	public void userUpdateWithValues(String companyName, String firstName, String userName, String email,
			String roles) {
		Select se = new Select(ddl_companyList);
		se.selectByVisibleText(companyName);
		commonActions.clearTextBoxes(Arrays.asList(txt_email,txt_firstname,txt_lastName, txt_password, txt_userName));
		txt_firstname.sendKeys(firstName);
		txt_lastName.sendKeys(Constants.AdminApp.defaultLasttName);
		txt_userName.sendKeys(userName);
		txt_email.sendKeys(email);
		txt_password.sendKeys(Constants.AdminApp.defaultPassword);
		chk_enabled.click();
		enterRoles(roles);
	}


	private void enterRoles(String roles) {
		Select se = new Select(ddl_roles);
		if (roles.equalsIgnoreCase("both")) {
			org.openqa.selenium.interactions.Actions act = new org.openqa.selenium.interactions.Actions(getDriver());
			act.keyDown(Keys.CONTROL).perform();
			se.selectByVisibleText(Roles.ROLE_OWNER.name());
			se.selectByVisibleText(Roles.ROLE_USER.name());
			act.keyUp(Keys.CONTROL).perform();
		}else if(roles.equalsIgnoreCase("user")){
			se.selectByVisibleText(Roles.ROLE_USER.name());
		}else if(roles.equalsIgnoreCase("owner")) {
			se.selectByVisibleText(Roles.ROLE_OWNER.name());
		}
	}


	@Override
	public WebElement getUniqueElementInPage() {
		return lbl_UserPageTitle;
	}
	

	

}
