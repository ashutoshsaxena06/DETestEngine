package com.de.adminApp.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.framework.commonUtils.CommonActions;
import com.framework.commonUtils.Page;

public class GlobalPage extends Page {
	private static Logger logger = Logger.getLogger(GlobalPage.class);
	public static CommonActions commonActions = new CommonActions();

	public enum Actions {
		open, deactivate, show, edit, delete;
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

	@FindBy(xpath = "//button[contains(.,'Save changes')]") // global save changes
	public WebElement btn_saveChanges;

	@FindBy(xpath = "//a[contains(.,'Back to listing')]") // back to listing
	public WebElement lnk_backtoListing;

	public void saveChanges() {
		Wait(10).until(ExpectedConditions.elementToBeClickable(btn_saveChanges)).click();
	}

	// ListOf

	public List<WebElement> getDataInColumn(String dataColumn) {
		return Wait(10).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//td[@data-label='" + dataColumn + "']")));
	}

	public int totalElementsInColumn(String column) {
		return getDataInColumn(column).size();
	}

	public WebElement getCellFromList(String column, String text) {
		return Wait(10).until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//td[@data-label='" + column + "'][contains(text(),'" + text + "')]")));
	}
	
	public String getIDFromName(String name) {
		return Wait(10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'"+name+"')]/preceding-sibling::td[@data-label='ID']"))).getText();
	}

	@Override
	public WebElement getUniqueElementInPage() {
		return h_homePageHeading;
	}
	
	

}
