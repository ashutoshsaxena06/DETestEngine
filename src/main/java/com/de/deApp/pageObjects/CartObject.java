package com.de.deApp.pageObjects;

public class CartObject {

    private String productName;
    private String vendorName;
    private int qty;
    private double unitPrice;
    private double itemPrice;


    public CartObject(String productName, String vendorName, int qty, double unitPrice) {
        this.productName = productName;
        this.vendorName = vendorName;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.itemPrice = unitPrice * qty;
    }

    public String getProductName() {
        return productName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public int getQty() {
        return qty;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getItemPrice() {
        return itemPrice;
    }
}
