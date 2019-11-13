package com.de.deApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;

public class SettingsPage extends Page {

	public SettingsPage() {
		super("SettingsPage");
	}

	public SettingsPage(String pageName) {
		super(pageName);
	}

	By loc_h_SettingsPageHeading = By.xpath("//h3[text()='Settings']");
	By loc_btn_AddCompanylogo = By.xpath("//form/descendant::button[3]");
	By loc_lnk_Deactivate = By.xpath("//span[text()='Deactivate']");
	By loc_btn_EditLocation = By.xpath("//button[@title()='Edit Location']");
	By loc_btn_DeleteLocation = By.xpath("//button[@title()='Delete Location']");
	By loc_btn_NewLocation = By.xpath("//span[text()='New Location']");
	By loc_btn_NewVendor = By.xpath("//span[contains(text(),'Add Vendor')]");
	String loc_lbl_LocationName = "//div[contains(text(),'locName')]";
	String loc_tbl_VendorName = "//th[contains(.,'vendorName')]";
	By loc_btn_Notification = By.xpath("//button[contains(.,'Notifications')]");
	By loc_lbl_ManageProductListsTab = By.xpath("//span[contains(text(),'Manage Product Lists')]");
	By loc_btn_Save = By.xpath(
			"//button/span[text()='Cancel' or text()='Back']/ancestor::div/descendant::button[contains(.,'Save')]");

	// span[contains(text(),'Product List')]

	public UIElement getH_SettingsPageHeading() {
		return new UIElement(loc_h_SettingsPageHeading, getPageName(), "h_SettingsPageHeading");
	}

	public Button getBtn_Notification() {
		return new Button(loc_btn_Notification, getPageName(), "btn_Notification");
	}

	public Button getBtn_AddCompanylogo() {
		return new Button(loc_btn_AddCompanylogo, getPageName(), "btn_AddCompanylogo");
	}

	public UIElement getLnk_Deactivate() {
		return new UIElement(loc_lnk_Deactivate, getPageName(), "lnk_Deactivate");
	}

	public Button getBtn_EditLocation() {
		return new Button(loc_btn_EditLocation, getPageName(), "btn_EditLocation");
	}

	public Button getBtn_DeleteLocation() {
		return new Button(loc_btn_DeleteLocation, getPageName(), "btn_DeleteLocation");
	}

	public Button getBtn_NewLocation() {
		return new Button(loc_btn_NewLocation, getPageName(), "btn_NewLocation");
	}

	public Button getBtn_NewVendor() {
		return new Button(loc_btn_NewVendor, getPageName(), "btn_NewVendor");
	}

	public UIElement getLbl_LocationName(String locName) {
		return new UIElement(By.xpath(loc_lbl_LocationName.replace("locName", locName)), getPageName(),
				"lbl_LocationName");
	}

	public UIElement getLoc_tbl_VendorName(String vendorName) {
		return new UIElement(By.xpath(loc_tbl_VendorName.replace("vendorName", vendorName)), getPageName(),
				"tbl_VendorName");
	}

	public UIElement getLbl_ManageProductListsTab() {
		return new UIElement(loc_lbl_ManageProductListsTab, getPageName(), "lbl_ManageProductListsTab");
	}

	// Setting Page

	/*
	 * // ? By = By.xpath("//h2[@class='jss117 jss123']") public WebElement
	 * lbl_MyRestaurant;
	 * 
	 * By = By.xpath("//input[contains(@value,'vandyCompany')]") public WebElement
	 * lbl_Restaurant;
	 * 
	 * // ? By = By.
	 * xpath("//body/div[@id='root']/div/div[@class='jss913']/main[@class='jss915']/div/div[@class='jss1132']/form[@class='jss1139']/div[@class='jss1155']/div[@class='jss1134']/div[@class='jss1238 jss1262']/div[@class='jss1239']/div[@class='jss943 jss945 jss944 jss1159 jss1156 jss1160']/div[1]/*[1]"
	 * ) public WebElement lbl_Logo;
	 * 
	 * 
	 * 
	 * // Manage Product List
	 * 
	 * By = By.xpath("//span[contains(text(),'Manage Product Lists')]") public
	 * WebElement btn_ManageProductLists;
	 * 
	 * By = By.xpath("//span[contains(text(),'New Product List')]") public
	 * WebElement btn_NewProductList;
	 * 
	 * By = By.xpath("//div[contains(text(),'vandyProduct')]") public WebElement
	 * ddl_ProductList;
	 * 
	 * By = By.xpath("//span[text()='Locations' and @xpath='1']") public WebElement
	 * btn_Locations;
	 * 
	 * public void clickNewLocation() { h_SettingsPageHeading.click(); }
	 * 
	 * public void clickAddVendor() { h_SettingsPageHeading.click(); }
	 */

	@Override
	public UIElement getUniqueElementInPage() {
		return getH_SettingsPageHeading();
	}

	public void addCompanylogo() {
		Actions act = new Actions(DriverManager.getDriver());
		act.moveToElement(getBtn_AddCompanylogo()).click().build().perform();
	}

	public void goToNotificationTab() {
		Actions act = new Actions(DriverManager.getDriver());
		act.moveToElement(getBtn_Notification()).click().build().perform();
	}

	public ManageProductListsTab navigateToManageProductListsTab() {
		new Actions(DriverManager.getDriver()).moveToElement(getLbl_ManageProductListsTab()).click().build().perform();
		return new ManageProductListsTab();
	}

	public void logoExist() {

	}

	public boolean locationExist(String locationName) {
		return getLbl_LocationName(locationName).isDisplayed();
	}

	public boolean vendorExist(String vendorName) {
		return getLoc_tbl_VendorName(vendorName).isDisplayed();
	}

	public EditVendorPage editVendor(String vendorName) {
		getLoc_tbl_VendorName(vendorName).click();
		return new EditVendorPage();
	}

	public void saveChanges() {
		new Button(loc_btn_Save, getPageName(), "btn_Save").click();
	}

	public void clickOnAddVendor() {
		new Actions(getDriver()).moveToElement(getBtn_NewVendor()).click().build().perform();
	}
}
