package com.de.adminApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Company extends GlobalPage {

	public Company(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='companies_name']")
	public WebElement txt_CompanyName;
	
	public void inputCompanyName(String name) {
		txt_CompanyName.sendKeys(name);
	}

	public static class CreateCompany extends Company {
		@FindBy(xpath = "//h1[contains(.,'Create a new Company')]")
		public WebElement h_CreateCompany;

		public CreateCompany(WebDriver driver) {
			super(driver);
		}

		@Override
		public WebElement getUniqueElementInPage() {
			return h_CreateCompany;
		}

	}

	public static class EditCompany extends Company {

		@FindBy(xpath = "//h1[text()='Edit Company']")
		public WebElement h_EditCompany;

		public EditCompany(WebDriver driver) {
			super(driver);
		}

		@Override
		public WebElement getUniqueElementInPage() {
			return h_EditCompany;
		}

	}

}
