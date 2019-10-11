package com.de.adminApp.pageObjects;

import org.openqa.selenium.By;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.Select;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public class OrderGuidePage extends AdminHomePage {

	public OrderGuidePage() {
		super("OrderGuidePage");
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getH_OrderGuide();
	}

	By loc_h_OrderGuide = By.xpath("//h1[contains(.,'Create new Order Guide')]");
	By loc_ddl_Selectvendor = By.xpath("//select[@id='orderguides_vendor']");
	By loc_lbl_AllLocations = By.xpath("//div[@id='orderguides_locations']/..//label");
	By loc_chk_AllLocationsSelect = By.xpath("//div[@id='orderguides_locations']/..//input");
	String loc_chk_LoctionSelect = "//div[@id='orderguides_locations']/..//label[contains(.,'location')]/input";
	By loc_txt_attachFile = By.xpath("//input[@id='orderguides_digitalDocument']");

	public Select getDdl_Selectvendor() {
		return new Select(loc_ddl_Selectvendor, getPageName(), "loc_ddl_Selectvendor");
	}

	public UIElement getLbl_AllLocations() {
		return new UIElement(loc_lbl_AllLocations, getPageName(), "loc_lbl_AllLocations");
	}

	public CheckBox getChk_AllLocationsSelect() {
		return new CheckBox(loc_chk_AllLocationsSelect, getPageName(), "loc_chk_AllLocationsSelect");
	}

	public CheckBox getChk_LoctionSelect(String location) {
		return new CheckBox(By.xpath(loc_chk_LoctionSelect.replace("location", location)), getPageName(),
				"loc_chk_LoctionSelect");
	}

	public TextBox getTxt_attachFile(String location) {
		return new TextBox(loc_txt_attachFile, getPageName(), "loc_txt_attachFile");
	}

	public UIElement getH_OrderGuide() {
		return new UIElement(loc_h_OrderGuide, getPageName(), "h_OrderGuide");
	}

	public void addOrderGuide(String companyName, String vendor, String location, String fileName) {
		selectAndAddCompany(companyName);
		sleep(5000);
		getDdl_Selectvendor().selectByVisibleText(vendor);
		sleep(5000);
		getChk_LoctionSelect(location).check();
		sleep(3000);
		getTxt_attachFile(location);
	}

}
