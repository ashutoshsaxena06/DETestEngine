package com.de.deApp.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.de.ConstantsPool.Constants;
import com.de.adminApp.pages.User;

public class DELogin {

	@FindBy(xpath = "//label[contains(.,'Username')]/following::input[1]")
	public WebElement tbx_userName;

	@FindBy(xpath = "//label[contains(.,'Password')]/following::input[1]")
	public WebElement tbx_password;

	@FindBy(xpath = "//span[contains(.,'Login')]")
	public WebElement btn_Login;

	 public DELogin(WebDriver driver) {
	 PageFactory.initElements(driver, this);
	 }

	public boolean doLogin(String userName, String password) {
		boolean flag= false;
		try {
			tbx_userName.sendKeys(userName);
			tbx_password.sendKeys(password);
			btn_Login.click();
			flag= true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
