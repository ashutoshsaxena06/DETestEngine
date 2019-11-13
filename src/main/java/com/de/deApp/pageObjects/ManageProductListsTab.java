package com.de.deApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public class ManageProductListsTab extends SettingsPage {

	By loc_lnk_NewProductList = By.xpath("//span[contains(text(),'New Product List')]");
	By loc_txt_ProductListName = By.xpath("//label[contains(text(),'Name')]//parent::div/descendant::input");
	By loc_lnk_LocationsTab = By.xpath("//span[text()='Locations']");
	String loc_chk_LocationName = "//span[contains(text(),'locationName')]/parent::label/descendant::input";
	By loc_h_CreateProductList = By.xpath("//h2[contains(.,'Create Product List')]");
	String loc_lbl_CreatedListName = "//div[contains(text(),'list')]";
	By loc_btn_SaveProductList = By.xpath("//span[contains(text(),'Save')]");
	By loc_chkAllLocations = By.xpath("//span[contains(text(),'All locations')]/preceding::input[1]");



	public ManageProductListsTab() {
		super("ManageProductListsTab");
	}

	public UIElement getLbl_CreatedListName(String list) {
		return new UIElement(By.xpath(loc_lbl_CreatedListName.replace("list", list)), getPageName(), "lbl_CreatedListName");
	}

	public UIElement getLnk_NewProductList() {
		return new UIElement(loc_lnk_NewProductList, getPageName(), "lnk_NewProductList");
	}

	public TextBox getTxt_ProductListName() {
		return new TextBox(loc_txt_ProductListName, getPageName(), "txt_ProductListName");
	}

	public UIElement getLnk_LocationsTab() {
		return new UIElement(loc_lnk_LocationsTab, getPageName(), "lnk_LocationsTab");
	}

	public CheckBox getchk_LocationName(String locationName) {
		return new CheckBox(By.xpath(loc_chk_LocationName.replace("locationName", locationName)), getPageName(), "locationName");
	}

	public CheckBox getChkAllLocations() {
		return new CheckBox(loc_chkAllLocations, getPageName(), "loc_chkAllLocations");
	}

	public UIElement getH_CreateProductList() {
		return new UIElement(loc_h_CreateProductList, getPageName(), "h_CreateProductList") {
			public String getText() {
				return  this.getWrappedElement().getText().replace("Auto:", "");
			}
		};
	}

	public void createNewProductList(String productListName) {
		if (getH_CreateProductList().isDisplayed()) {
			getTxt_ProductListName().clearAndType(productListName);
			saveChanges();
		}
	}

	public void assignLocation(String locationName) {
		new Actions(DriverManager.getDriver()).moveToElement(getLnk_LocationsTab()).click().build().perform();
		sleep(2000);
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", getchk_LocationName(locationName));
		sleep(3000);
		//new Actions(DriverManager.getDriver()).moveToElement(getchk_LocationName(locationName)).click();
		getChkAllLocations().click();
		new Button(loc_btn_SaveProductList, getPageName(), "loc_btn_SaveProductList").click();
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getLnk_NewProductList();
	}

}
