package com.de.adminApp.pages;

import com.de.ConstantsPool.Constants;
import com.framework.commonUtils.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminAppLogin extends Page{

    @FindBy(xpath = "//input[@id='username']")
    public WebElement txt_Usrename;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txt_Password;

    @FindBy(xpath = "//input[@id='remember_me']")
    public WebElement chk_RememberMe;

    @FindBy(xpath = "//input[@id='_submit']")
    public WebElement btn_Submit;

    public AdminAppLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean doLogin() {
        boolean flag = false;
        try {
            txt_Usrename.sendKeys(Constants.AdminApp.getAdmin_Username());
            txt_Password.sendKeys(Constants.AdminApp.getAdmin_Password());
            btn_Submit.click();
            Thread.sleep(10000);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
    
    public WebElement getUniqueElementInPage() {
		return btn_Submit;
	}
}
