package com.de.deApp.pageObjects;

import com.de.ui.elements.Table;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;
import org.openqa.selenium.By;

public class OrderGuides extends Page{
	
	public OrderGuides() {
		super("OrderGuides");
	}

	String loc_tbl_vendorName = "//th[contains(text(),'vendor')]";
	By loc_h_OrderGuidePageHeading = By.xpath("//h2[contains(text(),'Order Guides')]");

	public Table getTbl_vendorName(String vendor) {
		return new Table(By.xpath(loc_tbl_vendorName.replace("vendor",vendor)), getPageName(), "lbl_Home_DE");
	}

	public UIElement getUniqueElementInPage() {
		return new UIElement(loc_h_OrderGuidePageHeading, getPageName(), "h_OrderGuidePageHeading;");
	}

}
