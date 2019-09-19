package com.de.adminApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Users extends GlobalPage {

	public Users(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
	}
	
	public int getUserID(String name) {
		return Integer.valueOf(getIDFromName(name));
	}
	
	@FindBy(xpath="//h1[@title='List of Users']")
	public WebElement lbl_UsersPageTitle; 

	@Override
	public WebElement getUniqueElementInPage() {
		return lbl_UsersPageTitle;
	}
}
