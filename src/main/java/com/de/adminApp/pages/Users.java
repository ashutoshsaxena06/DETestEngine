package com.de.adminApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Users extends GlobalPage {

	public Users(WebDriver driver) {
		super(driver);
        PageFactory.initElements(driver, this);
	}
}
