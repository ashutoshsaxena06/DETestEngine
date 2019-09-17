package com.de.deApp.pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DEHome {

	public DEHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// @Override
	// public WebElement getUniqueElementInPage() {
	// return icon_Home;
	// }

	// By deLogin = By.className("jss751 jss736");
	// @FindBy(xpath = "//body/div[@id='root']/div/div[@class='jss23 jss26 jss40
	// jss20']/div[2]/div[1]")
	// public WebElement txtbx_UserName;
	//
	// @FindBy(xpath = "//input[@class='jss203 jss188 jss206 jss191']")
	// public WebElement txtbx_Password;
	//
	// @FindBy(xpath = "//input[@class='jss225']")
	// public WebElement chkbx_Remember;
	//
	// @FindBy(xpath = "//span[@class='jss256']")
	// public WebElement btn_Login;

	@FindBy(xpath = "//h3[text()='Dining edge']")
	public WebElement lbl_Home_DE;

	@FindBy(xpath = "//div[@title='Dashboard']/a")
	public WebElement icon_Home;

	// Menu Item OrderEdge
	@FindBy(xpath = "//span[contains(text(),'Order Edge')]")
	public WebElement lnk_menu_Oedge;

	@FindBy(xpath = "//input[@class='jss816']")
	public WebElement lnk_bestcomperables;

	@FindBy(xpath = "//body/div[@id='root']/div/div[@class='jss298']/main[@class='jss300']/div/div[@class='jss567 jss570 jss573 jss802']/div[@class='jss357 jss359 jss358 jss803']/button[1]/span[1]/*[1]")
	public WebElement lnk_filter;

	@FindBy(xpath = "//button[@class='jss383 jss523 jss852']//*[@class='jss386']")
	public WebElement btn_addprdct;

	@FindBy(xpath = "//h2[@class='jss395 jss401']")
	public WebElement lbl_Createprdct;

	@FindBy(xpath = "//div[@class='jss568 jss607']//input[@class='jss468 jss453']")
	public WebElement txtbx_name;

	@FindBy(xpath = "//div[@class='jss567 jss591']//div[1]//div[1]//div[1]//div[1]//div[1]")
	public WebElement drpdwn_Category;

	@FindBy(xpath = "//div[@class='jss567 jss591']//div[2]//div[1]//div[1]//div[1]//div[1]")
	public WebElement drpdwn_Storage;

	@FindBy(xpath = "//p[contains(text(),'Standard Units Of Measure')]")
	public WebElement lbl_StdrdUnitsOfMeasure;

	@FindBy(xpath = "//div[@class='jss568 jss597']//input[@class='jss468 jss453']")
	public WebElement txtbx_Size;

	@FindBy(xpath = "//div[@class='']")
	public WebElement drpdwn_Unit;

	@FindBy(xpath = "//div[@class='jss568 jss598']//input[@class='jss468 jss453']")
	public WebElement txtbx_lvl;

	@FindBy(xpath = "//div[@class='jss568 jss599']//input[@class='jss468 jss453']")
	public WebElement txtbx_Position;

	@FindBy(xpath = "//input[@name='hasTax']")
	public WebElement chkbx_tax;

	@FindBy(xpath = "//input[@name='showOnGrid']")
	public WebElement chkbx_OrderGrid;

	@FindBy(xpath = "//input[@name='active']")
	public WebElement chkbx_Active;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	public WebElement btn_Cancel;

	@FindBy(xpath = "//button[@class='jss383 jss496 jss507 jss508 jss510 jss511 jss485 jss1083 jss674 jss491']")
	public WebElement btn_Save;

	@FindBy(xpath = "//button[@aria-label='VerifiedUser']")
	public WebElement btn_User;

	@FindBy(xpath = "//li[text()='Logout']")
	public WebElement btn_Logout;

	public boolean logout() {
		try {
			btn_User.click();
			btn_Logout.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
