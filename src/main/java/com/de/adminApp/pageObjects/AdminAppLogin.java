package com.de.adminApp.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.de.ConstantsPool.Constants;
import com.de.ui.elements.Button;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;

public class AdminAppLogin extends Page {
	private static final Logger logger = Logger.getLogger(AdminAppLogin.class);

	By loc_txt_Username = By.xpath("//input[@id='username']");
	By loc_txt_Password = By.xpath("//input[@id='password']");
	By loc_chk_RememberMe = By.xpath("//input[@id='remember_me']");
	By loc_btn_Submit = By.xpath("//input[@id='_submit']");

	public TextBox getTxt_Username() {
		return new TextBox(loc_txt_Username, getPageName(),"txt-username");
	}

	public TextBox getTxt_Password() {
		return new TextBox(loc_txt_Password, getPageName(), "txt-password");
	}

	public CheckBox getChk_RememberMe() {
		return new CheckBox(loc_chk_RememberMe, getPageName(),"chk-remember-me");
	}

	public Button getBtn_Submit() {
		return new Button(loc_btn_Submit, getPageName(), "btn-submit");
	}

	public AdminAppLogin() {
		super("AdminAppLogin");
	}

	public boolean doLogin() {
		if (getBtn_Submit().isDisplayed()) {
			logger.info("Application is up and running");
		} else {
			logger.info("Application is down");
			Assert.assertTrue(false);
		}
		boolean flag = false;
		try {
			getTxt_Username().clearAndType(Constants.AdminApp.getAdmin_Username());
			getTxt_Password().clearAndType(Constants.AdminApp.getAdmin_Password());
			getBtn_Submit().click();
			Thread.sleep(10000);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public UIElement getUniqueElementInPage() {
		return getBtn_Submit();
	}

	public void launchURL() {
		setPageURL(Constants.AdminApp.getAdmin_App_Url());
		launch();
	}

	public boolean retryLogin() {
		launchURL();
		return doLogin();
	}
}
