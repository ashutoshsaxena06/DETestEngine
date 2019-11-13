package com.de.deApp.pageObjects;

import org.openqa.selenium.By;

import com.de.ConstantsPool.Constants;
import com.de.managers.DataManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;

public class DELogin  extends Page {

	By loc_tbx_userName= By.xpath("//label[contains(.,'Username')]/following::input[1]");
	By  loc_tbx_password= By.xpath("//label[contains(.,'Password')]/following::input[1]");
	By  loc_btn_Login= By.xpath("//span[contains(.,'Login')]");

	public TextBox getTbx_userName() {
		return new TextBox(loc_tbx_userName, getPageName(), "txt-user-name");
	}

	public TextBox getTbx_password() {
		return new TextBox(loc_tbx_password, getPageName(), "txt-password");
	}

	public Button getBtn_Login() {
		return new Button(loc_btn_Login, getPageName(), "btn-Login");
	}

	 public DELogin() {
		 super("DELogin");
	 }

	public boolean doLogin(String userName, String password) {
		boolean flag= false;
		try {
			getTbx_userName().sendKeys(userName);
			getTbx_password().sendKeys(password);
			getBtn_Login().click();
			flag= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public UIElement getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return getBtn_Login();
	}

	public void launchURL() {
		setPageURL(Constants.DEApp.getde_App_Url());
		launch();
	}

	public boolean retryLogin() {
		launchURL();
		return doLogin();
	}

	public boolean doLogin() {
		return doLogin(DataManager.getUsername(), DataManager.getPassword());
	}

}
