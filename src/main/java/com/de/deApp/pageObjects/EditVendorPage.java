package com.de.deApp.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public class EditVendorPage extends SettingsPage {

	
	By loc_txt_OrderNotification = By.xpath("//span[contains(.,'Order notification E-mail addresses')]/parent::div/..//input");
	By loc_btn_SaveEditVendor = By.xpath("//span[contains(.,'Period ')]/ancestor::div/descendant::span[contains(.,'Save')]");
	By loc_h_EditVendor= By.xpath("//h2[contains(.,'Edit Vendor')]");
	
	public TextBox getTxtOrderNotification() {
		return new TextBox(loc_txt_OrderNotification, getPageName(), "txt_OrderNotification");
	}
	
	public Button getBtn_SaveEditVendor() {
		return new Button(loc_btn_SaveEditVendor, getPageName(), "btn_SaveEditVendor");
	}
	
	public UIElement getH_EditVendor() {
		return new UIElement(loc_h_EditVendor, getPageName(), "h_EditVendor");
	}
	
	
	public EditVendorPage() {
		super("EditVendorPage");
	}

	public void goToNotificationTab() {
		Actions act = new Actions(DriverManager.getDriver());
		act.moveToElement(getBtn_Notification()).click().build().perform();
	}
	
	@Override
	public UIElement getUniqueElementInPage() {
		return getH_EditVendor();
	}

}
