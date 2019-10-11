package com.de.deApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.de.core.DriverManager;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public class CreateVendorPage extends SettingsPage {

	By loc_lbl_AddVendorTitle = By.xpath("//h2[contains(text(),'Add Vendor')]");
	By loc_txt_AddVendor = By.xpath("//input[@id='integration-downshift-simple']");

	public UIElement getLbl_AddVendorTitle() {
		return new UIElement(loc_lbl_AddVendorTitle, getPageName(), "lbl_AddVendorTitle");
	}

	public TextBox getTxt_AddVendor() {
		return new TextBox(loc_txt_AddVendor, getPageName(), "txt_AddVendor");
	}

	public CreateVendorPage() {
		super("CreateVendorPage");
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getLbl_AddVendorTitle();
	}

	public void addNewVendor(String vendorName) {
		getTxt_AddVendor().clearAndType(vendorName);
		new Actions(DriverManager.getDriver()).sendKeys(Keys.ARROW_DOWN).build().perform();
		new Actions(DriverManager.getDriver()).sendKeys(Keys.ENTER).build().perform();
		saveVendor();
	}

	public void addNewVendorForAllLocations(String vendorName) {

	}

	public void saveVendor() {
		saveChanges();
	}

}