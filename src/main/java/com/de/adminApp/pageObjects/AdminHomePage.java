package com.de.adminApp.pageObjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.de.core.DriverManager;
import com.de.ui.elements.Button;
import com.de.ui.elements.Link;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;
import com.framework.commonUtils.CommonActions;
import com.framework.commonUtils.Page;

public class AdminHomePage extends Page {
	private static Logger logger = Logger.getLogger(AdminHomePage.class);
	public static CommonActions commonActions = new CommonActions();

	public AdminHomePage(String PageName) {
		super(PageName);
	}

	public enum AppActions {
		open, deactivate, show, edit, delete;
	}

	By loc_ic_CompanyList = By.xpath("//span[@class='select2-selection select2-selection--single']");
	By loc_txt_CompanyName = By.xpath("//input[@class='select2-search__field']");

	By loc_h_homePageHeading = By.xpath("//a[contains(.,'Diningedge dark side')]");
	By loc_src_SearchBar = By.xpath("//input[@name='query']");
	By loc_btn_SearchButton = By.xpath("//button[@type='submit']");
	By loc_lnk_Add = By.xpath("//a[contains(.,'Add')]");
	By loc_btn_saveChanges = By.xpath("//button[contains(.,'Save changes')]"); // global save changes
	By loc_lnk_backtoListing = By.xpath("//a[contains(.,'Back to listing')]"); // back to listing
	String loc_lnk_sideBarLink = "//a/span[contains(.,'link')]";

	public UIElement getIc_CompanyList() {
		return new UIElement(loc_ic_CompanyList, getPageName(), "txt-company-list");
	}

	public TextBox getTxt_CompanyName() {
		return new TextBox(loc_txt_CompanyName, getPageName(), "txt-company-name");
	}

	public UIElement getH_homePageHeading() {
		return new UIElement(loc_h_homePageHeading, getPageName(), "home-page-heading");
	}

	public UIElement getSrc_SearchBar() {
		return new UIElement(loc_src_SearchBar, getPageName(), "search-bar");
	}

	public Button getBtn_SearchButton() {
		return new Button(loc_btn_SearchButton, getPageName(), "btn-search");
	}

	public Link getLnk_Add() {
		return new Link(loc_lnk_Add, getPageName(), "lnk-add");
	}

	public Link getLnk_backtoListing() {
		return new Link(loc_lnk_backtoListing, getPageName(), "lnk-back-to-listing");
	}

	public Link getlnk_sideBarLink(String link) {
		return new Link(By.xpath(loc_lnk_sideBarLink.replace("link", link)), getPageName(), link);
	}

	public Button getBtn_saveChanges() {
		return new Button(loc_btn_saveChanges, getPageName(), "Save Changes");
	}

	public void saveChanges() {
		getBtn_saveChanges().click();
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
		return Wait(10).until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//td[@data-label='" + column + "'][contains(.,'" + text + "')]")));
	}

	public String getIDFromName(String name) {
		return Wait(10)
				.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//td[contains(.,'" + name + "')]/preceding-sibling::td[@data-label='ID']")))
				.getText();
	}

	public void selectAndAddCompany(String companyName) {
		Actions act = new Actions(DriverManager.getDriver());
		act.moveToElement(getIc_CompanyList()).click().build().perform();
		getTxt_CompanyName().sendKeys(companyName);
		sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getH_homePageHeading();
	}

	public boolean loggedInStatus() {
		return getH_homePageHeading().isDisplayed();
	}

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}
}
