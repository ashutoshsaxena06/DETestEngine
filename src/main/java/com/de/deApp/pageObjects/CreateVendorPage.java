package com.de.deApp.pageObjects;

import com.de.core.DriverManager;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class CreateVendorPage extends SettingsPage {

    static int retryForVendor = 0;
    By loc_lbl_AddVendorTitle = By.xpath("//h2[contains(text(),'Add Vendor')]");
    By loc_txt_AddVendor = By.xpath("//input[@id='integration-downshift-simple']");

    public CreateVendorPage() {
        super("CreateVendorPage");
    }

    public UIElement getLbl_AddVendorTitle() {
        return new UIElement(loc_lbl_AddVendorTitle, getPageName(), "lbl_AddVendorTitle");
    }

    public TextBox getTxt_AddVendor() {
        return new TextBox(loc_txt_AddVendor, getPageName(), "txt_AddVendor");
    }

    @Override
    public UIElement getUniqueElementInPage() {
        return getLbl_AddVendorTitle();
    }

    public boolean addNewVendor(String vendorName) {
        retryForVendor++;
        if (retryForVendor < 2) {
            getTxt_AddVendor().clearAndType(vendorName);
            sleep(4000);
            new Actions(getDriver()).sendKeys(Keys.ARROW_DOWN).build().perform();
            new Actions(getDriver()).sendKeys(Keys.ENTER).build().perform();
            System.out.println(getTxt_AddVendor().getAttribute("value").equalsIgnoreCase(vendorName) || addNewVendor(vendorName));
            saveVendor();
        }
		return true;
	}

    public void addNewVendorForAllLocations(String vendorName) {

    }

    public void saveVendor() {
        saveChanges();
    }

}