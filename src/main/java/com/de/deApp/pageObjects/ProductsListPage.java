package com.de.deApp.pageObjects;

import org.openqa.selenium.By;

import com.de.ui.elements.Button;
import com.de.ui.elements.TextBox;
import com.de.ui.elements.UIElement;

public class ProductsListPage extends DEHome {

	public ProductsListPage() {
		super("ProductsListPage");
	}

	By loc_h_ProductsList = By.xpath("//h3[contains(.,'Products List')]");
	By loc_lnk_Import = By.xpath("//span[contains(text(),'Import')]");
	By loc_txt_UploadFile = By.xpath("//input[@accept='text/csv, .csv']");
	By loc_btn_Upload = By.xpath("//span[contains(text(),'Upload')]");
	By loc_lbl_TotalCount = By.xpath("//p[contains(.,'Total: ')]");

	public UIElement getH_ProductsList() {
		return new UIElement(loc_h_ProductsList, getPageName(), "h_ProductsList");
	}

	public UIElement getLnk_Import() {
		return new UIElement(loc_lnk_Import, getPageName(), "lnk_Import");
	}

	public TextBox getTxt_UploadFile() {
		return new TextBox(loc_txt_UploadFile, getPageName(), "txt_UploadFile");
	}

	public Button getBtn_Upload() {
		return new Button(loc_btn_Upload, getPageName(), "btn_Upload");
	}

	public UIElement getLbl_TotalCount() {
		return new UIElement(loc_lbl_TotalCount, getPageName(), "lbl_TotalCount") {
			public String getText() {
				return this.getWrappedElement().getText().replace("Total:", "").trim();
			}
		};
	}

	@Override
	public UIElement getUniqueElementInPage() {
		return getH_ProductsList();
	}

}
