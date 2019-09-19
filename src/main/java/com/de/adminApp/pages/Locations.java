package com.de.adminApp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.log4testng.Logger;

public class Locations extends GlobalPage {
	
	private static Logger logger = Logger.getLogger(Locations.class);

	public Locations(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='locations_name']")
	public WebElement txt_locationName;

	@FindBy(xpath = "//span[@id='select2-locations_company-container']")
	public WebElement txt_companyName;

	@FindBy(xpath = "//input[@class='select2-search__field']")
	public WebElement txt_searchInAutoSearch;
	
	@FindBy(xpath = "//ul[@id='select2-locations_productList_autocomplete-results']/li")
	public List<WebElement> ll_productList;
	
	@FindBy(xpath = "//ul[@id='select2-locations_company-results']/li")
	public List<WebElement> ll_companyList;
	
	@FindBy(xpath = "//select[@id='locations_timezone']")
	public WebElement ddl_timeZone;
	
	@FindBy(xpath = "//h1[@class='title']")
	public WebElement h_pageTitle;
	
	@FindBy(xpath = "//span[@id='select2-locations_productList_autocomplete-container']")
	public WebElement txt_productList;
	
	
	public void addLocation(String locName, String companyName, String timeZone, String productList) {
		if (locName !=null && companyName !=null && timeZone != null && productList!=null) {
			
			txt_locationName.clear();
			txt_locationName.sendKeys(locName);
			txt_companyName.click();
			txt_searchInAutoSearch.sendKeys(companyName);
			Select se = new Select(ddl_timeZone);
			se.selectByVisibleText(timeZone);
			txt_productList.click();
			txt_searchInAutoSearch.sendKeys(productList);
		}else {
			logger.error("valid values not provided to add location");
		}
	}


	@Override
	public WebElement getUniqueElementInPage() {
		return h_pageTitle;
	}
	
	
	
	
	
	
}
