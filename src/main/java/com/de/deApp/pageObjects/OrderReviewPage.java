package com.de.deApp.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;

public class OrderReviewPage extends Page{


public OrderReviewPage(String pageName) {
		super("OrderReviewPage");
	}

@FindBy(xpath="//p[contains(.,'Order #')]")
public WebElement lnk_Deactivate;

@Override
public UIElement getUniqueElementInPage() {
	return null;
}

//order date //p[contains(.,'date')]

//span[text()='Location']/following-sibling::p

//span[text()='Created by']/following-sibling::p

//h2[text()!='Order']




}
