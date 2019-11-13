package com.de.adminApp.pageObjects;

import com.de.core.DriverManager;
import com.google.inject.internal.cglib.proxy.$InvocationHandler;
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
	String loc_chk_LocationSelect = "//form[@name='orderguides']/..//label[contains(text(),'2Oct')]/input";
	By loc_txt_attachFile = By.xpath("//form[@name='orderguides']/descendant::input[@id='orderguides_digitalDocument']");
	By loc_lbl_OGSuccess = By.xpath("//div[contains(text(),'Successfully')]");


	public Select getDdl_Selectvendor() {
		return new Select(loc_ddl_Selectvendor, getPageName(), "loc_ddl_Selectvendor");
	}

	public UIElement getLbl_AllLocations() {
		return new UIElement(loc_lbl_AllLocations, getPageName(), "loc_lbl_AllLocations");
	}

	public CheckBox getChk_AllLocationsSelect() {
		return new CheckBox(loc_chk_AllLocationsSelect, getPageName(), "loc_chk_AllLocationsSelect");
	}

	public UIElement getChk_LoctionSelect(String location) {
		return new UIElement(By.xpath(loc_chk_LocationSelect.replace("location", location)), getPageName(),
				"loc_chk_LocationSelect");
	}

	public TextBox getTxt_attachFile() {
		return new TextBox(loc_txt_attachFile, getPageName(), "loc_txt_attachFile");
	}

	public UIElement getLbl_OGSuccess() {
		return new UIElement(loc_lbl_OGSuccess, getPageName(), "loc_lbl_OGSuccess");
	}

	public UIElement getH_OrderGuide() {
		return new UIElement(loc_h_OrderGuide, getPageName(), "h_OrderGuide");
	}

	public void addOrderGuide(String companyName, String vendor, String location, String fileName) {
		selectAndAddCompany(companyName);
		sleep(5000);
		getDdl_Selectvendor().selectByVisibleText(vendor);
		sleep(3000);
		getChk_LoctionSelect(location).click();
		if(!getChk_LoctionSelect(location).isSelected()){
			DriverManager.getDriver().findElement(By.xpath("//form[@name='orderguides']/descendant::input[@id='select_all']")).click();
		}
		sleep(3000);
		try{ getTxt_attachFile().sendKeys(fileName);}
		catch (Exception e){
			e.printStackTrace();
		}
		saveChanges();
	}

}
