package com.de.deApp.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.de.ConstantsPool.Constants;
import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.de.ui.elements.UIElements;

public class CreateLocationPage extends SettingsPage {

	public CreateLocationPage() {
		super("CreateLocationPage");
	}

	By loc_lbl_CreateLocation = By.xpath("//h2[contains(.,'Create Location')]");
	By loc_btn_Basic = By.xpath("//button/p[text()='Basic']");
	By loc_lbl_LocationName = By.xpath("//label[text()='Location Name']");
	String loc_txt_BasicDetails = "//label[text()='fieldName']/following-sibling::*/input";
	By loc_lbl_MandatoryFields = By.xpath("//*[text()='Create Location']/following::form/..//label/*");
	By loc_btn_Back = By.xpath("//button/span[text()='Back']");
	By loc_btn_Next = By.xpath("//button/span[text()='Next']");
	By loc_txt_AddEmail = By.xpath("//input[@placeholder='Add']");
	By loc_txt_FromEmail = By.xpath("//span[text()='From email']/following::input[@type='text']");

	By loc_chk_sendExportedItems = By.xpath(
			"//span[text()='Send exported items list automatically']/preceding-sibling::*/..//input[@type='checkbox']");

	public UIElement getLbl_CreateLocation() {
		return new UIElement(loc_lbl_CreateLocation, getPageName(), "lbl_CreateLocation");
	}

	public Button getBtn_Basic() {
		return new Button(loc_btn_Basic, getPageName(), "btn_Basic");
	}

	public UIElement getLbl_LocationName() {
		return new UIElement(loc_lbl_LocationName, getPageName(), "lbl_LocationName");
	}

	public Button getBtn_Back() {
		return new Button(loc_btn_Back, getPageName(), "btn_Back");
	}

	public Button getBtn_Next() {
		return new Button(loc_btn_Next, getPageName(), "btn_Next");
	}

	public CheckBox getChk_sendExportedItems() {
		return new CheckBox(loc_chk_sendExportedItems, getPageName(), "chk_sendExportedItems");
	}

	public TextBox getTxt_AddEmail() {
		return new TextBox(loc_txt_AddEmail, getPageName(), "txt_AddEmail");
	}

	public TextBox getTxt_FromEmail() {
		return new TextBox(loc_txt_FromEmail, getPageName(), "txt_FromEmail");
	}

	public TextBox getTextElement(String s) {
		return new TextBox(By.xpath(loc_txt_BasicDetails.replace("fieldName", s)), getPageName(), "txt-" + s);
	}

	// page methods

	public List<TextBox> getAllMandatoryFields() {
		return UIElements.getTextBoxes(loc_lbl_MandatoryFields, getPageName(), "all-mandatory-fields");
	}

	public void fillBasicDetails(String locName) {
		getTextElement("Location Name").clearAndType(locName);
		getTextElement("Street").clearAndType("street1");
		getTextElement("City").clearAndType("city1");
		getTextElement("Postal Code (zip)").clearAndType("33125");
	}


	public void goToNextTab() {
		Actions act = new Actions(DriverManager.getDriver());
		act.moveToElement(getBtn_Next()).click().build().perform();
	}

	public void fillNotificationDetails() {
		getTxt_AddEmail().clearAndType(Constants.AdminApp.defaultEmail);
		getTxt_FromEmail().clearAndType(Constants.AdminApp.defaultEmail1);
	}

	public void saveLocation() {
		saveChanges();
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getLbl_CreateLocation();
	}

}
