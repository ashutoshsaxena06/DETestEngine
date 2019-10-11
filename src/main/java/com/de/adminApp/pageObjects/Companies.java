package com.de.adminApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.de.ui.elements.Table;
import com.de.ui.elements.UIElement;

public class Companies extends AdminHomePage{

	public Companies() {
		super("Companies");
	}
	
	By loc_lbl_CompanyPageTitle = By.xpath("//h1[contains(.,'List of Companies')]");

	public UIElement getLbl_CompanyPageTitle() {
		return new UIElement(loc_lbl_CompanyPageTitle, getPageName(), "lbl-company-page-title");
	}
	
	@Override
	public UIElement getUniqueElementInPage() {
		return getLbl_CompanyPageTitle();
	}
	


	public int getCompanyID(String name) {
		return Integer.valueOf(getIDFromName(name));
	}
	
	public static class Actions extends Companies{

		
		By loc_tbl_AllActions = By.xpath("//td[@data-label='Actions']");

		public Table getTbl_AllActions() {
			return new Table(loc_tbl_AllActions, getPageName(), "companies-page-actions");
		}
		
		public WebElement getAction(String actionName) {
			return getTbl_AllActions().findElement(By.name(actionName));
		}
		
		
	}

}
