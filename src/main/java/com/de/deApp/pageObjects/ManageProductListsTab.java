package com.de.deApp.pageObjects;

import org.openqa.selenium.By;

import com.de.ui.elements.CheckBox;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public class ManageProductListsTab extends SettingsPage {

	By loc_lnk_NewProductList = By.xpath("//span[contains(text(),'New Product List')]");
	By loc_txt_ProductListName = By.xpath("//label[contains(text(),'Name')]//parent::div/descendant::input");
	By loc_lnk_LocationsTab = By.xpath("//span[text()='Locations']");
	By loc_chk_LocationName = By.xpath("//span[contains(text(),'new test')]/parent::label/descendant::input");
	By loc_h_CreateProductList = By.xpath("//h2[contains(.,'Create Product List')]");
	By loc_lbl_CreatedListName = By.xpath("//div[contains(text(),'Auto:')]");

	public ManageProductListsTab() {
		super("ManageProductListsTab");
	}

	public UIElement getLbl_CreatedListName() {
		return new UIElement(loc_lbl_CreatedListName, getPageName(), "lbl_CreatedListName");
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

	public CheckBox getchk_LocationName() {
		return new CheckBox(loc_chk_LocationName, getPageName(), "chk_LocationName");
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

	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getLnk_NewProductList();
	}

}
