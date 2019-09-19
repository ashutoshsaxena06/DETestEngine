package com.framework.commonUtils;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CommonActions {
    private static WebDriver driver;
    private static String defaultBrowser="";
    private static String defaultPath= "C:\\Users\\sony\\Downloads\\chromedriver_win32\\chromedriver.exe";
    private DesiredCapabilities capabilities;
	private static Logger logger = Logger.getLogger(CommonActions.class);

	
	public void clearTextBoxes(List<WebElement> li) {
		if (li != null) {
			try {
				for (WebElement webElement : li) {
					logger.info("clearing values from textbox - "+ webElement.getAttribute("value"));
					webElement.clear();
				}
			} catch (Exception e) {
				logger.error("exception occured while clearing a textbox");
				e.printStackTrace();
			}
		}
	}

    public WebDriver setDriver(String browser, String path){
        if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", path);
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("gecko")) {
            System.setProperty("webdriver.gecko.driver", path);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else {
//            HashMap<String, String> chromePreferences = new HashMap();
//            chromePreferences.put("profile.password_manager_enabled", "false");
//            chromePreferences.put("profile.default_content_settings.popups", "0");
//            chromePreferences.put("download.prompt_for_download", "false");
//            chromePreferences.put("download.default_directory",  System.getProperty("user.home") + "\\Downloads\\");
//            this.capabilities.setCapability("chrome.prefs", chromePreferences);
            ChromeOptions options = new ChromeOptions();
            options.addArguments(new String[]{"--test-type"});
            options.addArguments(new String[]{"start-maximized"});
            options.addArguments(new String[]{"--disable-web-security"});
            options.addArguments(new String[]{"--disable-dev-shm-usage"});
            options.addArguments(new String[]{"--no-sandbox"});
            options.addArguments(new String[]{"--disable-extensions"});
            options.addArguments(new String[]{"--allow-running-insecure-content"});
            System.setProperty("webdriver.chrome.driver", path);
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static WebDriver setDriver(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            System.setProperty("webdriver.chrome.driver", defaultPath);
            return new ChromeDriver(options);
    }

    public static WebDriver getDriver(){
    return driver;
    }
}
