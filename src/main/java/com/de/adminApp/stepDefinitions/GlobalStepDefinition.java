package com.de.adminApp.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import com.de.adminApp.pages.GlobalPage;
import com.framework.commonUtils.CommonActions;

public class GlobalStepDefinition {
	public static CommonActions commonActions = new CommonActions();
	public static GlobalPage globalPage;
	public static SoftAssert softly = new SoftAssert();
	private Logger logger;
	
	static {
		globalPage = new GlobalPage(commonActions.getDriver()) {
			@Override
			public WebElement getUniqueElementInPage() {
				return h_homePageHeading;
			}
		};

	}
	
	public static WebDriver getDriver() {
		return commonActions.getDriver();
	}
	
}
