package com.de.adminApp.pageObjects;

import org.openqa.selenium.By;

import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public abstract class Company extends AdminHomePage {

	public Company(String pageName) {
		super(pageName);
	}

	By loc_txt_CompanyName = By.xpath("//input[@id='companies_name']");

	public TextBox getTxt_CompanyName() {
		return new TextBox(loc_txt_CompanyName, getPageName(), "txt-company-name");
	}

	public void inputCompanyName(String name) {
		getTxt_CompanyName().clearAndType(name);
	}
	
	public void addCompany(String name) {
		inputCompanyName(name);
		saveChanges();
	}

	public static class CreateCompany extends Company {
		
		public CreateCompany() {
			super("CreateCompany");
		}
		
		By loc_h_CreateCompany = By.xpath("//h1[contains(.,'Create a new Company')]");

		public UIElement getH_CreateCompany() {
			return new UIElement(loc_h_CreateCompany, "CreateCompany", "page-heading-create-company");
		}

		@Override
		public UIElement getUniqueElementInPage() {
			return getH_CreateCompany();
		}

	}

	public static class EditCompany extends Company {

		public EditCompany() {
			super("EditCompany");
		}

		By loc_h_EditCompany = By.xpath("//h1[text()='Edit Company']");

		public UIElement getH_EditCompany() {
			return new UIElement(loc_h_EditCompany, "EditCompany", "page-heading-edit-company");
		}

		@Override
		public UIElement getUniqueElementInPage() {
			return getH_EditCompany();
		}
	}

}
