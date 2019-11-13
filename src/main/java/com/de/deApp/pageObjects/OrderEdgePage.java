package com.de.deApp.pageObjects;

import com.de.adminApp.pageObjects.Companies;
import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

public class OrderEdgePage extends Page {

    public OrderEdgePage() {
        super("OrderEdgePage");
    }
// top bar
    By loc_chk_BestComparables = By.xpath("//span[@title='Show only Best Comparables']/..//input");
    By loc_lnk_last7Days  = By.xpath("//p[contains(text(),'Last 7 days')]");
    By loc_btn_Cart  = By.xpath("//button[@title='Cart']");
    By loc_btn_Search = By.xpath("//button[@title='Search']");
    By loc_btn_Checkout = By.xpath("//span[contains(text(),'Checkout')]");
    By loc_txt_Search = By.xpath("//input[@id='adornment-search']");
    By loc_lnkOpenManageComparable = By.xpath("//div[@id='fixed-col']/descendant::a[@title='Open Manage Comparabls']");
    By loc_hOrderEdgeTitle = By.xpath("//h3[contains(text(),'Order Edge')]");

    public UIElement getHOrderEdgeTitle() {
        return new TextBox(loc_hOrderEdgeTitle, getPageName(), "loc_hOrderEdgeTitle");
    }

    public UIElement getLnkOpenManageComparable() {
        return new TextBox(loc_lnkOpenManageComparable, getPageName(), "loc_lnkOpenManageComparable");
    }

    public TextBox getLoc_txt_Search() {
        return new TextBox(loc_txt_Search, getPageName(), "loc_txt_Search");
    }

    public UIElement getLoc_chk_BestComparables() {
        return new UIElement(loc_chk_BestComparables, getPageName(), "loc_chk_BestComparables");
    }

    public UIElement getLoc_lnk_last7Days() {
        return new UIElement(loc_lnk_last7Days, getPageName(), "loc_lnk_last7Days");
    }

    public UIElement getLoc_btn_Cart() {
        return new UIElement(loc_btn_Cart, getPageName(), "loc_btn_Cart");
    }

    public UIElement getLoc_btn_Search() {
        return new UIElement(loc_btn_Search, getPageName(), "loc_btn_Search");
    }

    public Button getLoc_btn_Checkout() {
        return new Button(loc_btn_Checkout, getPageName(), "loc_btn_Checkout");
    }

//total items on a page //div[@id='grid']/*
	// product window
	//button[@title='Hide product from Grid']
	//button[@title='Open Manage Units']

    // ordering
    String loc_ProductNameUsingSeq = "//div[@id='grid']/div[1]/div[1]/div/div[1]/div[2]/h3[contains(text(),'1.')]";
    String loc_ProductNameUsingName ="//div[@id='grid']/descendant::h3[contains(text(),'productName')]";
    String loc_ProductCellUsingName= "//div[@id='grid']/descendant::h3[contains(text(),'productName')]/ancestor::div[4]";
    String loc_ManageCompForProduct= "//div[@id='grid']/descendant::h3[contains(text(),'productName')]/preceding::a[@title='Open Manage Comparabls']";
    String loc_VendorNames= "//div[@id='grid-header']/descendant::p"; // vendor header names
    String loc_VendorCellForProduct ="//div[@id='grid']/descendant::h3[contains(text(),'productName')]/ancestor::div[4]/following-sibling::div";
    String loc_txtItemQty = "//div[@id='grid']/descendant::h3[contains(text(),'productName')]/ancestor::div[contains(@class,'grid-row-fixes')]/following-sibling::div/div[2]/descendant::input[1]";

    public String getLoc_ProductNameUsingSeq() {
        return loc_ProductNameUsingSeq;
    }

    public String getLoc_ProductNameUsingName() {
        return loc_ProductNameUsingName;
    }

    public UIElement getLoc_ProductCellUsingName(String productName) {
        return new UIElement(By.xpath(loc_ProductCellUsingName.replace("productName",productName)), getPageName(), "loc_ProductCellUsingName");
    }

    public String getLoc_ManageCompForProduct() {
        return loc_ManageCompForProduct;
    }

    public String getLoc_VendorNames() {
        return loc_VendorNames;
    }

    public String getLoc_VendorCellForProduct() {
        return loc_VendorCellForProduct;
    }

    public String getLoc_ItemQty() {
        return loc_txtItemQty;
    }

    public void orderUsingPartialSearch(String partialItemName) {

    }

    public void orderUsingFullSearch(String completeItemName) {
        // click on search
        getLoc_btn_Search().click();
        // input
        getLoc_txt_Search().clearAndType(completeItemName);
        sleep(4000);
    }

    public void orderWithItemNumOnAnyPage(String num) {
    }

    public void orderWithItemNumOnPage(String ItemNum, String pageNum) {
    }

	public void orderFirstItem() {
	}


    @Override
    public UIElement getUniqueElementInPage() {
        return getHOrderEdgeTitle();
    }

    public void goToManageComparable(String productName) {
        // go to resulted product and click on manage comparable + icon
        try{getLoc_ProductCellUsingName(productName).findElement(loc_lnkOpenManageComparable).click();
//            new Actions(DriverManager.getDriver()).moveToElement(getLoc_ProductCellUsingName(productName)).perform();
//            new Actions(DriverManager.getDriver()).moveToElement(ele).click(ele).build().perform();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            getLnkOpenManageComparable().click();
        }
    }

    public void selectQuantity(String productName, String qty) {
        UIElement productCell = getVendorProductCell(productName);
        // go to vendor on Order edge
        new Actions(DriverManager.getDriver())
                .clickAndHold(productCell)
                .perform();
        // choose qty
        WebElement txtQty = productCell.findElement(By.xpath(loc_txtItemQty.replace("productName",productName)));
        new Actions(DriverManager.getDriver()).moveToElement(txtQty).sendKeys(qty).build().perform();
        sleep(4000);
        String actual = txtQty.getAttribute("value");
        System.out.println("Check entered quantity match - " + qty.equalsIgnoreCase(actual) );
    }

    public UIElement getIconCart() {
        return new UIElement(loc_btn_Cart, getPageName(),"loc_btn_Cart");
    }

    public UIElement getBtnCheckOut() {
        return new UIElement(loc_btn_Checkout, getPageName(), "loc_btn_Checkout");
    }

    public UIElement getVendorProductCell(String productName){
        return new UIElement(By.xpath(loc_VendorCellForProduct.replace("productName",productName)),getPageName(), "loc_VendorCellForProduct");
    }

    public void getCSPrice(String productName) {
        // get cs price from order edge
        //return getVendorProductCell(productName).findElement(By.xpath())
    }
}
