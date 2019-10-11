package com.de.deApp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;

public class OrderEdgePage extends Page {

	public OrderEdgePage(WebDriver driver) {
		super("OrderEdgePage");
		PageFactory.initElements(driver, this);
	}
//
//	By  = By.xpath("//h3[contains(text(),'Order Edge')]")
//	public WebElement h_OrderEdgeHeading;
//
//	public WebElement getUniqueElementInPage() {
//		return h_OrderEdgeHeading;
//	}
//
//	By  = By.xpath("//div[@class='jss2292 jss2104 jss2299']")
//	public WebElement lbl_product;
//
//	By  = By.xpath("//div[@class='jss2195 jss2226']")
//	public WebElement btn_Quantity;
//
//	By  = By.xpath("//div[@class='jss2195 jss2226']")
//	public WebElement btn_Quantit;

	@Override
	public UIElement getUniqueElementInPage() {
		// TODO Auto-generated method stub
		return null;
	}

}
