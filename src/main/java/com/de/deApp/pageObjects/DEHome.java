package com.de.deApp.pageObjects;

import com.de.ConstantsPool.Constants;
import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.CheckBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class DEHome extends Page {

    By loc_lbl_Home_DE = By.xpath("//h3[text()='Dining edge']");
    By loc_icon_Home = By.xpath("//div[@title='Dashboard']/a");
    By loc_lnk_Settings = By.xpath("//a[contains(text(),'settings')]");
    By loc_icon_Settings = By.xpath("//a[contains(@href,'settings')]");
    // Menu Item OrderEdge
    By loc_lnk_menu_Ordge = By.xpath("//span[contains(text(),'Order Edge')]");
    By loc_chkbx_tax = By.xpath("//input[@name='hasTax']");
    By loc_chkbx_OrderGrid = By.xpath("//input[@name='showOnGrid']");
    By loc_chkbx_Active = By.xpath("//input[@name='active']");
    By loc_btn_Cancel = By.xpath("//span[contains(text(),'Cancel')]");
    By loc_btn_User = By.xpath("//button[@aria-label='VerifiedUser']");
    By loc_btn_Logout = By.xpath("//li[text()='Logout']");
    By loc_lnk_ManageItems = By.xpath("//span[contains(text(),'Manage Items')]");
    String loc_lnk_ManageItemOption = "//span[contains(text(),'option')]";

    public DEHome() {
        super("DEHomePage");
    }

    public DEHome(String pageName) {
        super(pageName);
    }

    public UIElement getLnk_Settings() { return new UIElement(loc_lnk_Settings, getPageName(), "lnk_Settings"); }

    public UIElement getIcon_Settings() { return new UIElement(loc_icon_Settings, getPageName(), "loc_icon_Settings"); }

    public UIElement getLbl_Home_DE() {
        return new UIElement(loc_lbl_Home_DE, getPageName(), "lbl_Home_DE");
    }

    public UIElement getIcon_Home() {
        return new UIElement(loc_icon_Home, getPageName(), "icon_Home");
    }

    public UIElement getLnk_menu_Ordge() {
        return new UIElement(loc_lnk_menu_Ordge, getPageName(), "lnk_menu_Ordge");
    }

    public CheckBox getChkbx_tax() {
        return new CheckBox(loc_chkbx_tax, getPageName(), "chkbx_tax");
    }

    public CheckBox getChkbx_OrderGrid() {
        return new CheckBox(loc_chkbx_OrderGrid, getPageName(), "chkbx_OrderGrid");
    }

    public CheckBox getChkbx_Active() {
        return new CheckBox(loc_chkbx_Active, getPageName(), "chkbx_Active");
    }

    public Button getBtn_Cancel() {
        return new Button(loc_btn_Cancel, getPageName(), "btn_Cancel");
    }

    public Button getBtn_User() {
        return new Button(loc_btn_User, getPageName(), "btn_User");
    }

    public Button getBtn_Logout() {
        return new Button(loc_btn_Logout, getPageName(), "btn_Logout");
    }

    public UIElement getLnk_ManageItems() {
        return new UIElement(loc_lnk_ManageItems, getPageName(), "lnk_ManageItems");
    }


    public boolean logout() {
        try {
            getBtn_User().click();
            getBtn_Logout().click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public UIElement getUniqueElementInPage() {
        return getLbl_Home_DE();
    }

    public DEHome goToManageItems() {
        new Actions(DriverManager.getDriver()).moveToElement(getLnk_ManageItems()).click().build().perform();
        return new DEHome();
    }

    public UIElement getOption(String option) {
        return new UIElement(By.xpath(loc_lnk_ManageItemOption.replace("option", option)), getPageName(), "lnk_ManageItem_" + option);
    }

    public void clickOnOption(String option) {
        try {
            new Actions(DriverManager.getDriver()).moveToElement(getOption(option)).click().build().perform();
            DriverManager.getDriver().navigate().to(Constants.DEApp.getde_App_Url() + "manage-items");
        } catch (Exception e) {
            e.printStackTrace();
            DriverManager.getDriver().navigate().to(Constants.DEApp.getde_App_Url() + "manage-items");
        }
    }

}
