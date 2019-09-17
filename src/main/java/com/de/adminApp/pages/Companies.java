package com.de.adminApp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Companies extends GlobalPage {


    @FindBy(xpath = "//input[@id='companies_name']")
    public WebElement txt_CompanyName;

    public Companies(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
