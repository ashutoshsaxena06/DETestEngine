package com.de.deApp.pageObjects;

import com.de.core.DriverManager;
import com.de.reporting.Reporter;
import com.de.ui.elements.Alert;
import com.de.ui.elements.UIElement;
import com.de.ui.elements.UIElements;
import com.framework.commonUtils.Page;
import org.jruby.RubyProcess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ManageComparables extends Page {
    private String productName;

    String loc_HproductName = "//h2[contains(text(),'productName)]";
    String loc_btnSearchVendorItems = "//label[contains(text(),'vendorName')]/following-sibling::div/div/button[@aria-label='Toggle password visibility']";
    String loc_txtSearchVendorItem = "//label[contains(text(),'vendorName')]/following-sibling::div/input";
    String loc_lblTotalItemsFound = "//label[contains(text(),'vendorName')]/following::span[contains(text(),'Found:')]";
    String loc_lblAllItemNamesForVendor = "//label[contains(text(),'vendorName')]/following::span[contains(text(),'Found:')]/preceding-sibling::div/p[1]"; //  text of all comparables
    String loc_lblAllItemCodesForVendor = "//label[contains(text(),'vendorName')]/following::div/p[2]"; //  item number of all comparables
    String loc_chkAddItem = "//p[contains(text(),'productName')]/following::input[1]"; // add item
    String loc_chkMaster = "//p[contains(text(),'productName')]/following::input[@type='radio']"; // make it master
    By loc_btnSaveAndClose = By.xpath("//span[contains(text(),'Save and Close')]");
    By loc_hManageUnits = By.xpath("//h2[contains(text(),'Manage Units')]");
    By loc_btnCloseManageUnits = By.xpath("//div[@id='form-dialog-title']/following-sibling::button"); // close manage units button

    public ManageComparables(String productName) {
        super("ManageComparables");
        this.productName=productName;
    }

    public String getProductName(){
        return loc_HproductName.replace("productName",this.productName);
    }

    @Override
    public UIElement getUniqueElementInPage() {
        return new UIElement(By.xpath(getProductName()),getPageName(), "manage-comparable-heading-productname");
    }

    public void searchProductInVendorList(String productName, String vendorName) {
        // go to the vendor item search
        // enter and search
        new UIElement(By.xpath(loc_txtSearchVendorItem.replace("vendorName",vendorName)), getPageName(), "loc_txtSearchVendorItem").sendKeys(productName);
        sleep(5000);
        // print all result
        UIElement totalResults = new UIElement(By.xpath(loc_txtSearchVendorItem.replace("vendorName",vendorName)), getPageName(), "loc_txtSearchVendorItem");
        System.out.println("total items found for comparable - " + totalResults.getText() );
        List<UIElement> allResults = new UIElements().getMultiple(By.xpath(loc_lblTotalItemsFound.replace("vendorName",vendorName)), getPageName(), "loc_lblTotalItemsFound");
        int i=1;
        for (WebElement e : allResults) {
            System.out.println("Item " + i++ + " : ");
            System.out.print(e.getText());
        }
    }

    public void addComparable(String productName) {
        // click on add for 1st result
        new UIElement(By.xpath(loc_chkAddItem.replace("productName",productName)), getPageName(), "loc_chkAddItem").click();
        new UIElement(loc_btnCloseManageUnits, getPageName(), "loc_btnCloseManageUnits").click();
        sleep(5000);

    }

    public UIElement manageUnitsPopUp() {
        return new UIElement(loc_hManageUnits, getPageName(), "loc_hManageUnits");
    }

    public void closeManageUnitsPopUp(){
        new UIElement(loc_btnCloseManageUnits, getPageName(), "loc_btnCloseManageUnits").click();
    }

}
