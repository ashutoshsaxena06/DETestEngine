package com.de.adminApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.de.ui.elements.UIElement;

public class Users extends AdminHomePage {

	public Users() {
		super("Users");
	}

	public int getUserID(String name) {
		return Integer.valueOf(getIDFromName(name));
	}

	By loc_lbl_UsersPageTitle = By.xpath("//h1[contains(.,'List of Users']");
	public WebElement lbl_UsersPageTitle;

	@Override
	public UIElement getUniqueElementInPage() {
		return getLbl_UsersPageTitle();
	}

	public UIElement getLbl_UsersPageTitle() {
		return new UIElement(loc_lbl_UsersPageTitle, getPageName(), "lbl-page-title");
	}
}
