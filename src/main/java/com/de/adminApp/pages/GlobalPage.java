package com.de.adminApp.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commonUtils.CommonActions;

public class GlobalPage {
	public static CommonActions commonActions = new CommonActions();
	private static Logger logger = Logger.getLogger(GlobalPage.class);

	public enum Actions{
		open,deactivate,show,edit,delete;
	}

    @FindBy(xpath = "//a[contains(.,'Diningedge dark side')]")
    public WebElement h_homePageHeading;

    @FindBy(xpath = "//input[@name='query']")
    public WebElement src_SearchBar;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement btn_SearchButton;

    public GlobalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(.,'Add')]")
    public WebElement lnk_Add;

	@FindBy(xpath="//button[text()='Save changes']") // global save changes
	public WebElement btn_saveChanges;

	@FindBy(xpath="//a[text()='Back to listing']") // back to listing
	public WebElement lnk_backtoListing;
    
}
