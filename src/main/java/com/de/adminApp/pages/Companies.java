package com.de.adminApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import net.serenitybdd.core.annotations.findby.By;

public class Companies extends GlobalPage{

	public Companies(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@title='List of Companies']")
	public WebElement lbl_CompanyPageTitle; 
	
	
	@Override
	public WebElement getUniqueElementInPage() {
		return lbl_CompanyPageTitle;
	}
	
	public int getCompanyID(String name) {
		return Integer.valueOf(getIDFromName(name));
	}
	
	public static class Actions extends Companies{

		public Actions(WebDriver driver) {
			super(driver);
		}
		
		@FindBy(xpath="//td[@data-label='Actions']")
		public WebElement tbl_AllActions; 
		
		public WebElement getAction(String actioName) {
			return Wait(10).until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-label='Actions']/a[name='"+actioName+"']")));
		}
		
		
	}

}
