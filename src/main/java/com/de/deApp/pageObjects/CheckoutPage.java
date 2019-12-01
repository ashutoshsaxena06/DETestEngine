package com.de.deApp.pageObjects;

import com.de.core.DriverManager;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage extends Page {
    public CheckoutPage() {
        super("CheckoutPage");
    }

    By loc_hCheckout = By.xpath("//h2[contains(text(),'Checkout')]");
    By loc_chkToSelectItem = By.xpath("//tr[@role='checkbox']"); // no of items
    By loc_lblProductName = By.xpath("//tr[@role='checkbox']/th[2]");
    By loc_lblVendorName = By.xpath("//tr[@role='checkbox']/th[3]/p");
    By loc_lblUnitPrice = By.xpath("//tr[@role='checkbox']/th[6]/p/h3");
    By loc_lblQty = By.xpath("//tr[@role='checkbox']/th[7]/descendant::input");
    By loc_lblExtPrice = By.xpath("//tr[@role='checkbox']/th[8]/h3");
    By loc_btnSubmitAll = By.xpath("//button/span[contains(text(),'Submit All')]");


    // @Override
    public UIElement getUniqueElementInPage() {
        return new UIElement(By.xpath("//h2[contains(text(),'Checkout')]"), getPageName(), "heading-checkout");
    }

    public void verifyItemDetails() {
        //get product name and assert
        // get vendor name and assert
        // get qty and assert
        // get unit price and assert
        // get item price and assert
    }

    public void submitAll() {
        UIElement ele = new UIElement(loc_btnSubmitAll, getPageName(), "loc_btnSubmitAll");
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", ele);
        ele.click();
    }


}
