package com.de.deApp.pageObjects;

import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;
import org.openqa.selenium.By;

public class OrderSummaryPage  extends Page {
    public OrderSummaryPage() {
        super("CheckoutPage");
    }

    @Override
    public UIElement getUniqueElementInPage() {
        return new UIElement(By.xpath("//h2[contains(text(),'Order')]"), getPageName(), "heading-OrderSummaryPage");
    }
    public void getPONumber() {
    }
    //h2[contains(text(),'Order')]
//span[contains(text(),'Order Name/PO Number')]/following-sibling::p
}
