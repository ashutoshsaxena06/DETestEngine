package com.de.deApp.stepdefinition;

import org.hamcrest.Matchers;
import org.junit.Assert;

import com.de.ConstantsPool.Constants;
import com.de.adminApp.pageObjects.AdminAppLogin;
import com.de.adminApp.pageObjects.AdminHomePage;
import com.de.adminApp.pageObjects.Companies;
import com.de.adminApp.pageObjects.Company;
import com.de.adminApp.pageObjects.OrderGuidePage;
import com.de.adminApp.pageObjects.User;
import com.de.adminApp.pageObjects.Users;
import com.de.deApp.pageObjects.CreateLocationPage;
import com.de.deApp.pageObjects.CreateVendorPage;
import com.de.deApp.pageObjects.DEHome;
import com.de.deApp.pageObjects.DELogin;
import com.de.deApp.pageObjects.EditVendorPage;
import com.de.deApp.pageObjects.ManageProductListsTab;
import com.de.deApp.pageObjects.ProductsListPage;
import com.de.deApp.pageObjects.SettingsPage;
import com.de.enums.AdminAppSideLinks;
import com.de.managers.DataManager;
import com.de.reporting.Reporter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EtoEfromOrderEdgeStepDefinition {

	static DataManager dataManager = new DataManager();
	AdminAppLogin adminAppLogin;
	AdminHomePage adminHomePage;
	Companies companies;
	Company.CreateCompany createCompany;
	Users users;
	User user;
	DELogin deLoginPage;
	DEHome deHomePage;
	SettingsPage settingsPage;
	CreateLocationPage createLocationPage;
	CreateVendorPage createVendorPage;
	EditVendorPage editVendorPage;
	ManageProductListsTab manageProductListsTab;
	ProductsListPage productListsPage;
	OrderGuidePage orderGuidePage;

	static String file = "D:\\workspace\\DETestEngine\\product_list_custom_units.csv";
	static String filePath = "D:\\workspace\\DETestEngine\\";
	static String expectedCount = "534";
	boolean adminApploginFlag;
	boolean DEApploginFlag;
	static String companyName;
	static String vendorName;
	static String locationName;
	static String productList;

	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}

	@Given("^login to admin app$")
	public void login_to_admin_app() {
		adminAppLogin = new AdminAppLogin();
		adminAppLogin.launchURL();
		adminAppLogin.shouldExist(adminAppLogin, 40);
		adminApploginFlag = adminAppLogin.doLogin();
	}

	@Given("^user is on adminApp home page$")
	public void user_is_on_adminApp_home_page() {
		sleep(7000);
		if (adminApploginFlag) {
			adminHomePage = new AdminHomePage("adminHomePage");
			Reporter.report.step("Login to admin app starus is [{}]", adminHomePage.loggedInStatus());
			Assert.assertTrue(adminHomePage.loggedInStatus());
		} else {
			Assert.assertTrue(adminAppLogin.retryLogin());
		}
	}

	@When("^Create a new Company \"([^\"]*)\" in adminApp$")
	public void create_a_new_Company_in_adminApp(String companyName) {
		this.companyName = companyName;
		sleep(7000);
		companies = new Companies();
		companies.getLnk_Add().click();
		createCompany = new Company.CreateCompany();
		createCompany.shouldExist(createCompany, 10);
		createCompany.addCompany(companyName); // creating a company
		Assert.assertThat(companies.getCellFromList("Name", companyName).getText(),
				Matchers.containsString(companyName));
	}

	@When("^Create \"([^\"]*)\" and assign \"([^\"]*)\" in adminApp$")
	public void create_and_assign_in_adminApp(String userName, String companyName) {
		sleep(7000);
		adminHomePage.getlnk_sideBarLink(AdminAppSideLinks.Users.name()).click();
		users = new Users();
		users.getLnk_Add().click();
		user = new User();
		user.shouldExist(user, 10);
		sleep(3000);
		user.addUser(companyName, null, userName, null);
		// users.shouldExist(users, 10);
		// Assert.assertThat(users.getCellFromList("Username", userName).getText(),
		// Matchers.containsString(userName));
	}

	@When("^Login DE webApp with \"([^\"]*)\"$")
	public void login_DE_webApp_with(String userName) {
		sleep(7000);
		deLoginPage = new DELogin();
		deLoginPage.launchURL();
		sleep(3000);
		deLoginPage.shouldExist(deLoginPage, 20);
		deLoginPage.doLogin();
		deHomePage = new DEHome();
		deHomePage.shouldExist(deHomePage, 20);
	}

	@When("^Go to settings page$")
	public void go_to_settings_page() {
		sleep(7000);
		deHomePage.getLnk_Settings().click();
		settingsPage = new SettingsPage();
		settingsPage.shouldExist(settingsPage, 10);
	}

	@When("^Add company Logo$")
	public void add_company_Logo() {
		sleep(7000);
		settingsPage.addCompanylogo();
		settingsPage.logoExist();
	}

	@When("^Create a new location \"([^\"]*)\" with required basic and notification tab details$")
	public void create_a_new_location_with_required_basic_and_notification_tab_details(String locName) {
		sleep(7000);
		settingsPage.getBtn_NewLocation().click();
		createLocationPage = new CreateLocationPage();
		createLocationPage.shouldExist(createLocationPage, 10);
		createLocationPage.fillBasicDetails(locName);
		// createLocationPage.goToNextTab();
		createLocationPage.goToNotificationTab();
		// createLocationPage.fillNotificationDetails();
		sleep(3000);
		createLocationPage.saveLocation();
		dataManager.setLocationName(locName);
	}

	@Then("^Verify the created location$")
	public void verify_the_created_location() {
		settingsPage.shouldExist(settingsPage, 10);
		Assert.assertTrue(settingsPage.locationExist(dataManager.getLocationName()));
	}

	@When("^Create a new vendor \"([^\"]*)\"$")
	public void create_a_new_vendor(String vendorName) {
		sleep(5000);
		this.vendorName = vendorName;
		settingsPage.getBtn_NewVendor().click();
		createVendorPage = new CreateVendorPage();
		createVendorPage.shouldExist(createVendorPage, 10);
		createVendorPage.addNewVendor(vendorName);
	}

	@Then("^Verify the created vendor \"([^\"]*)\"$")
	public void verify_the_created_vendor(String vendorName) {
		settingsPage.shouldExist(settingsPage, 10);
		settingsPage.vendorExist(vendorName);
	}

	@When("^Edit vendor to add the Order notification E-mail addresses$")
	public void edit_vendor_to_add_the_Order_notification_E_mail_addresses() {
		sleep(5000);
		editVendorPage = settingsPage.editVendor(vendorName);
		sleep(3000);
		editVendorPage.goToNotificationTab();
		editVendorPage.getTxtOrderNotification().clearAndType(Constants.AdminApp.defaultEmail);
		editVendorPage.getBtn_SaveEditVendor().click();
	}

	@When("^Navigate to manage product list$")
	public void navigate_to_manage_product_list() {
		sleep(5000);
		manageProductListsTab = settingsPage.navigateToManageProductListsTab();
	}

	@When("^Create a new product list as \"([^\"]*)\" and assign to \"([^\"]*)\"$")
	public void create_a_new_product_list_as_and_assign_to(String productList, String locationName) {
		sleep(5000);
		this.productList = productList;
		manageProductListsTab.getLnk_NewProductList().click();
		manageProductListsTab.createNewProductList(productList);
		manageProductListsTab.assignLocation(locationName);
	}

	@Then("^Verify the created productList$")
	public void verify_the_created_productList() {
		Assert.assertThat(manageProductListsTab.getH_CreateProductList().getText(),
				Matchers.containsString(productList));
	}

	@When("^Navigate to product list in manage items$")
	public void navigate_to_product_list_in_manage_items() {
		deHomePage.goToManageItems().clickOnOption("Products List");
	}

	@When("^Import a valid product list file$")
	public void import_a_valid_product_list_file() {
		productListsPage = new ProductsListPage();
		productListsPage.shouldExist(productListsPage, 10);
		productListsPage.getLnk_Import().click();
		productListsPage.getTxt_UploadFile().sendKeys(file);
		productListsPage.getBtn_Upload().click();
	}

	@Then("^Verify the count of products imported from product list file$")
	public void verify_the_count_of_products_imported_from_product_list_file() {
		sleep(5000);
		productListsPage.shouldExist(productListsPage, 10);
		String totalCount = productListsPage.getLbl_TotalCount().getText().replace("Total: ", "");
		Assert.assertThat(totalCount, Matchers.equalToIgnoringCase(expectedCount));
	}

	@When("^Switch to adminApp$")
	public void switch_to_adminApp() {
		sleep(5000);
		login_to_admin_app();
	}

	@When("^Go to order guides in vendors in adminApp$")
	public void go_to_order_guides_in_vendors_in_adminApp() {
		adminHomePage.getlnk_sideBarLink("Vendors").click();
		sleep(3000);
		adminHomePage.getlnk_sideBarLink("Order Guides").click();
	}

	@When("^Create a new order guide with file \"([^\"]*)\" in adminApp$")
	public void create_a_new_order_guide_with_file_in_adminApp(String orderGuide) {
		adminHomePage.getLnk_Add().click();
		orderGuidePage = new OrderGuidePage();
		orderGuidePage.addOrderGuide(companyName, vendorName, dataManager.getLocationName(),
				filePath + orderGuide + ".csv");
	}

	@Then("^Verify the created order guide in adminApp$")
	public void verify_the_created_order_guide_in_adminApp() {

	}

	@When("^Switch to DE webApp$")
	public void switch_to_DE_webApp() {
		login_DE_webApp_with(dataManager.getUsername());
	}

	@Then("^Verify the created order guide in DE webApp$")
	public void verify_the_created_order_guide_in_DE_webApp() {

	}

	@When("^Add comparable for a product$")
	public void add_comparable_for_a_product() {

	}

	@When("^Select quantity \"([^\"]*)\" to order$")
	public void select_quantity_to_order(String arg1) {

	}

	@When("^Go to cart using cart icon$")
	public void go_to_cart_using_cart_icon() {

	}

	@Then("^Verify the product details on checkout page$")
	public void verify_the_product_details_on_checkout_page() {

	}

	@When("^Submit the Order on checkout page$")
	public void submit_the_Order_on_checkout_page() {

	}

	@Then("^Verify the Order details on review page$")
	public void verify_the_Order_details_on_review_page() {

	}

}