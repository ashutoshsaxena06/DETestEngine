package com.de.adminApp.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.log4testng.Logger;
import com.de.ui.elements.Select;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.de.ui.elements.UIElements;

public class Locations extends AdminHomePage {

	private static Logger logger = Logger.getLogger(Locations.class);

	public Locations() {
		super("Locations");
	}

	By loc_txt_locationName = By.xpath("//input[@id='locations_name']");
	By loc_txt_companyName = By.xpath("//span[@id='select2-locations_company-container']");
	By loc_txt_searchInAutoSearch = By.xpath("//input[@class='select2-search__field']");
	By loc_ll_productList = By.xpath("//ul[@id='select2-locations_productList_autocomplete-results']/li");
	By loc_ll_companyList = By.xpath("//ul[@id='select2-locations_company-results']/li");
	By loc_ddl_timeZone = By.xpath("//select[@id='locations_timezone']");
	By loc_h_pageTitle = By.xpath("//h1[@class='title']");
	By loc_txt_productList = By.xpath("//span[@id='select2-locations_productList_autocomplete-container']");

	public TextBox getTxt_locationName() {
		return new TextBox(loc_txt_locationName, getPageName(), "txt-location-name");
	}

	public TextBox getTxt_companyName() {
		return new TextBox(loc_txt_locationName, getPageName(), "txt-location-name");
	}

	public TextBox getTxt_searchInAutoSearch() {
		return new TextBox(loc_txt_locationName, getPageName(), "txt-location-name");
	}

	public List<UIElement> getLl_productList() {
		return UIElements.getMultiple(loc_ll_productList, getPageName(), "ll-product-list");
	}

	public List<UIElement> getLl_companyList() {
		return UIElements.getMultiple(loc_ll_companyList, getPageName(), "ll-company-list");
	}

	public Select getDdl_timeZone() {
		return new Select(loc_ddl_timeZone, getPageName(), "ddl-timezone");
	}

	public UIElement getH_pageTitle() {
		return new UIElement(loc_h_pageTitle, getPageName(), "h-pagetitle");
	}

	public TextBox getTxt_productList() {
		return new TextBox(loc_txt_locationName, getPageName(), "txt-location-name");
	}

	public void addLocation(String locName, String companyName, String timeZone, String productList) {
		if (locName != null && companyName != null && timeZone != null && productList != null) {
			getTxt_locationName().clear();
			getTxt_locationName().sendKeys(locName);
			getTxt_companyName().click();
			getTxt_searchInAutoSearch().sendKeys(companyName);
			getDdl_timeZone().selectByVisibleText(timeZone);
			getTxt_productList().click();
			getTxt_searchInAutoSearch().sendKeys(productList);
		} else {
			logger.error("valid values not provided to add location");
		}
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getH_pageTitle();
	}
}
