
package com.de.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

class WebDriverThread {
    private WebDriver webDriver;
    private DesiredCapabilities capabilities;
    private String browser;
    private String platform;
    private String mobileEmulation;
    private String userAgent;

    WebDriverThread() {
    }

    private void setPlatform() {
        if (ExecutionConfig.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
            String var1 = this.platform.toUpperCase();
            byte var2 = -1;
            switch(var1.hashCode()) {
            case 76079:
                if (var1.equals("MAC")) {
                    var2 = 1;
                }
                break;
            case 72440020:
                if (var1.equals("LINUX")) {
                    var2 = 0;
                }
                break;
            case 2067476067:
                if (var1.equals("WINDOWS")) {
                    var2 = 2;
                }
            }

            switch(var2) {
            case 0:
                this.capabilities.setPlatform(Platform.LINUX);
                break;
            case 1:
                this.capabilities.setPlatform(Platform.MAC);
                break;
            case 2:
                this.capabilities.setPlatform(Platform.WINDOWS);
                break;
            default:
                throw new RuntimeException("Invalid execution environment: " + this.platform);
            }
        }

    }

    public WebDriver getDriver() {
        if (null == this.webDriver || ((RemoteWebDriver)this.webDriver).getSessionId() == null) {
            this.browser = DriverManager.getBrowserName();
            this.platform = DriverManager.getPlatformName();
            this.mobileEmulation = DriverManager.getMobileEmulation();
            this.userAgent = DriverManager.getUserAgent();
            String var1 = this.browser.toUpperCase();
            byte var2 = -1;
            switch(var1.hashCode()) {
            case -1856568448:
                if (var1.equals("SAFARI")) {
                    var2 = 2;
                }
                break;
            case -131469639:
                if (var1.equals("FIREFOX")) {
                    var2 = 0;
                }
                break;
            case 2332:
                if (var1.equals("IE")) {
                    var2 = 3;
                }
                break;
            case 1987167866:
                if (var1.equals("CHROME")) {
                    var2 = 1;
                }
            }

            switch(var2) {
            case 0:
                this.capabilities = DesiredCapabilities.firefox();
                this.setPlatform();
                FirefoxProfile profile = new FirefoxProfile();
                profile.setAcceptUntrustedCertificates(true);
                profile.setPreference("browser.download.folderList", 2);
                profile.setPreference("browser.download.manager.showWhenStarting", false);
                profile.setPreference("browser.download.dir", ExecutionConfig.TEMP_DATA_PATH);
                profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;application/pdf;application/vnd.openxmlformats-officedocument.wordprocessingml.document;text/plain;text/csvapplication/zip");
//                this.capabilities.setAcceptInsecureCerts(true);
                this.capabilities.setCapability("firefox_profile", profile);
                if (!ExecutionConfig.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
                    WebDriverManager.firefoxdriver().setup();
                    this.webDriver = new FirefoxDriver(this.capabilities);
                }
                break;
            case 1:
                this.capabilities = DesiredCapabilities.chrome();
                this.setPlatform();
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable("performance", Level.INFO);
                this.capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
                this.capabilities.setCapability("loggingPrefs", logPrefs);
                HashMap<String, String> chromePreferences = new HashMap();
                chromePreferences.put("profile.password_manager_enabled", "false");
                chromePreferences.put("profile.default_content_settings.popups", "0");
                chromePreferences.put("download.prompt_for_download", "false");
                chromePreferences.put("download.default_directory", ExecutionConfig.TEMP_DATA_PATH);
                this.capabilities.setCapability("chrome.prefs", chromePreferences);
                ChromeOptions options = new ChromeOptions();
                options.addArguments(new String[]{"--test-type"});
                options.addArguments(new String[]{"start-maximized"});
                options.addArguments(new String[]{"--disable-web-security"});
                options.addArguments(new String[]{"--disable-dev-shm-usage"});
                options.addArguments(new String[]{"--no-sandbox"});
                options.addArguments(new String[]{"--disable-extensions"});
                options.addArguments(new String[]{"--allow-running-insecure-content"});
                if (!this.mobileEmulation.isEmpty()) {
                    Map<String, String> mobileEmulationMap = new HashMap();
                    mobileEmulationMap.put("deviceName", this.mobileEmulation);
                    options.setExperimentalOption("mobileEmulation", mobileEmulationMap);
                }

                if (!this.userAgent.isEmpty()) {
                    options.addArguments(new String[]{"--user-agent=" + this.userAgent});
                }

                this.capabilities.setCapability("goog:chromeOptions", options);
                if (!ExecutionConfig.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
                    WebDriverManager.chromedriver().setup();
                    this.webDriver = new ChromeDriver(this.capabilities);
                }
                break;
            case 2:
                this.capabilities = DesiredCapabilities.safari();
                this.setPlatform();
                if (!ExecutionConfig.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
                    this.webDriver = new SafariDriver(this.capabilities);
                }
                break;
            case 3:
                this.setPlatform();
                this.capabilities = DesiredCapabilities.internetExplorer();
                this.capabilities.setCapability("ensureCleanSession", true);
                this.capabilities.setCapability("enablePersistentHover", true);
                this.capabilities.setCapability("requireWindowFocus", true);
                if (!ExecutionConfig.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
                    WebDriverManager.iedriver().setup();
                    this.webDriver = new InternetExplorerDriver(this.capabilities);
                }
                break;
            default:
                throw new RuntimeException("Invalid browser: " + this.browser);
            }

            if (ExecutionConfig.EXECUTION_ENVIRONMENT.equalsIgnoreCase("remote")) {
                try {
                    this.webDriver = new RemoteWebDriver(new URL(ExecutionConfig.HUB_NODE_URL), this.capabilities);
                } catch (MalformedURLException var8) {
                    throw new RuntimeException("Malformed HUB_URL", var8);
                }
            }

            this.webDriver.manage().timeouts().pageLoadTimeout((long)ExecutionConfig.MAX_PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
            this.webDriver.manage().timeouts().setScriptTimeout((long)ExecutionConfig.MAX_ELEMENT_LOAD_WAIT_TIME, TimeUnit.SECONDS);
            this.webDriver.manage().timeouts().implicitlyWait((long)ExecutionConfig.MAX_ELEMENT_LOAD_WAIT_TIME, TimeUnit.SECONDS);
            if (!this.browser.equalsIgnoreCase("chrome")) {
                this.webDriver.manage().window().maximize();
            }
        }

        return this.webDriver;
    }

    public void quitDriver() {
        if (null != this.webDriver) {
            this.webDriver.quit();
            this.webDriver = null;
            DriverManager.driverStatusThread.set(false);
        }

    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public String getBrowser() {
        return this.browser;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getMobileEmulation() {
        return this.mobileEmulation;
    }

    public String getUserAgent() {
        return this.userAgent;
    }
}
