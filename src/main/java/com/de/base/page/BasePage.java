package com.de.base.page;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.fest.assertions.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.de.core.DriverManager;
import com.de.core.ExecutionConfig;
import com.de.reporting.Reporter;
import com.de.reporting.reports.Report;
import com.de.ui.elements.UIElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public abstract class BasePage {
    protected String pageName;
    protected String pageURL;
    private Report report;

    public BasePage(String pageName) {
        this.report = Reporter.report;
        this.pageName = pageName;
    }

    public BasePage(String pageName, Report report) {
        this.report = Reporter.report;
        this.pageName = pageName;
        this.report = report;
    }

    public static synchronized Object executeJavaScript(String javaScript, Object... args) {
        Reporter.report.info("Execute javascript [" + javaScript + "]");
        WebDriver driver = DriverManager.getDriver();

        try {
            return ((JavascriptExecutor) driver).executeScript(javaScript, args);
        } catch (Throwable var4) {
            throw (RuntimeException) var4;
        }
    }

    public static synchronized void takeScreenshot(String pageName) {
        WebDriver driver = DriverManager.getCurrentWebDriver();
        if (driver != null) {
            DateFormat timeFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss_SSS");
            String aShotFileName = org.testng.Reporter.getCurrentTestResult().getMethod().getMethodName() + "_" + timeFormat.format(new Date()) + ".png";
            String defaultFileName = org.testng.Reporter.getCurrentTestResult().getMethod().getMethodName() + "_" + timeFormat.format(new Date()) + "_default.png";
            String outputDir = org.testng.Reporter.getCurrentTestResult().getTestContext().getOutputDirectory();
            outputDir = outputDir.substring(0, outputDir.lastIndexOf(File.separator)) + "/html";
            File aShotFile = new File(outputDir, aShotFileName);
            File defaultFile = new File(outputDir, defaultFileName);
            AShot aShot = (new AShot()).shootingStrategy(ShootingStrategies.viewportPasting(100));
            File tempFile;
            Screenshot screenshot;
            if (driver.getClass().equals(RemoteWebDriver.class)) {
                screenshot = aShot.takeScreenshot((new Augmenter()).augment(driver));
                tempFile = ((TakesScreenshot) (new Augmenter()).augment(driver)).getScreenshotAs(OutputType.FILE);
            } else {
                screenshot = aShot.takeScreenshot(driver);
                tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            }

            try {
                ImageIO.write(screenshot.getImage(), "PNG", aShotFile);
                FileUtils.copyFile(tempFile, defaultFile);
                FileUtils.deleteQuietly(tempFile);
            } catch (IOException var12) {
                Reporter.report.info("Exception occurred while saving screenshot to file", var12);
            }

            Reporter.report.attachImage(aShotFile, pageName);
            Reporter.report.attachImage(defaultFile, pageName);
        } else {
            Reporter.report.info("Couldn't capture screen-shot as WebDriver is null.");
        }

    }

    public String getPageURL() {
        return this.pageURL;
    }
    
    public void setPageURL(String url) {
        this.pageURL = url;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void launch() {
        this.report.info("Launch URL [{}]", this.pageURL);
        DriverManager.getDriver().get(this.pageURL);
    }

    public void assertContainsText(String text) {
        this.report.info("Assert [{}] contains text [{}]", this.pageName, text);
        Assertions.assertThat(DriverManager.getDriver().findElement(By.tagName("body")).getText()).containsIgnoringCase(text);
    }

    public void assertDoesNotContainText(String text) {
        this.report.info("Assert [{}] doesn't contain text [{}]", this.pageName, text);
        Assertions.assertThat(DriverManager.getDriver().findElement(By.tagName("body")).getText()).doesNotContain(text);
    }

    public void assertContainsTitle(String title) {
        this.report.info("Assert [{}] title contains [{}]", this.pageName, title);
        Assertions.assertThat(DriverManager.getDriver().getTitle()).containsIgnoringCase(title);
    }

    public void waitUntilLoads() {
        this.report.info("Wait until [{}] loads ", this.pageName);
        byte timeToWaitTillDocumentStartsLoading = 5;

        try {
            DriverManager.setWebDriverPageWait(timeToWaitTillDocumentStartsLoading);
//            DriverManager.getWebDriverPageWait().until(MoreExpectedConditions.documentIsLoading());
            DriverManager.setWebDriverPageWait(ExecutionConfig.MAX_PAGE_LOAD_WAIT_TIME - timeToWaitTillDocumentStartsLoading);
//            DriverManager.getWebDriverPageWait().until(MoreExpectedConditions.documentIsReady());
        } catch (Throwable var6) {
        } finally {
            DriverManager.resetWebDriverPageWait();
        }

    }

    public void waitUntilContainsTitle(String title) {
        this.report.info("Wait until [{}] contains title [{}]", this.pageName, title);
        DriverManager.getWebDriverPageWait().until(ExpectedConditions.titleContains(title));
    }

    public void waitUntilContainsText(String text) {
        this.report.info("Wait until [{}] contains text [{}]", this.pageName, text);
        DriverManager.getWebDriverPageWait().until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text));
    }

    public void waitUntilDoesNotContainText(String text) {
        this.report.info("Wait until [{}] doesn't contain text [{}]", this.pageName, text);
        DriverManager.getWebDriverPageWait().until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), text)));
    }

    public void waitUntilAllAJAXCallsFinish() {
        this.report.info("Wait until all ajax requests complete on [{}]", this.pageName);
        WebDriverWait wait = DriverManager.getWebDriverPageWait();
        long timeOutInMilliSeconds = ExecutionConfig.MAX_PAGE_LOAD_WAIT_TIME * 1000;
        long startTime = System.currentTimeMillis();

        try {
            if (timeOutInMilliSeconds > 0L) {
//                wait.withTimeout(timeOutInMilliSeconds, TimeUnit.MILLISECONDS).until(MoreExpectedConditions.jQueryAJAXCallsHaveCompleted());
            }

            this.pause(1);
            timeOutInMilliSeconds -= System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis();
            if (timeOutInMilliSeconds > 0L) {
//                wait.withTimeout(timeOutInMilliSeconds, TimeUnit.MILLISECONDS).until(MoreExpectedConditions.jQueryAJAXCallsHaveCompleted());
            }

            this.pause(1);
            timeOutInMilliSeconds -= System.currentTimeMillis() - startTime;
            if (timeOutInMilliSeconds > 0L) {
//                wait.withTimeout(timeOutInMilliSeconds, TimeUnit.MILLISECONDS).until(MoreExpectedConditions.jQueryAJAXCallsHaveCompleted());
            }
        } catch (Throwable var7) {
        }

    }

    public void waitUntilAngularProcessingFinish() {
        this.report.info("Wait until angular js has finished processing on [{}]", this.pageName);
//        DriverManager.getWebDriverPageWait().until(MoreExpectedConditions.angularHasFinishedProcessing());
    }

    public void waitUntilFrameAppearsAndSwitchToIt(String frameLocator) {
        this.report.info("Wait until frame with locator [" + frameLocator + "] appears and switch to it on [{}]", this.pageName);
        DriverManager.getWebDriverPageWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void waitUntilFrameAppearsAndSwitchToIt(UIElement frameElement) {
        this.report.info("Wait until frame element [" + frameElement.getElementName() + "] appears and switch to it on [{}]", this.pageName);
        DriverManager.getWebDriverPageWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement.getWrappedElement()));
    }

    public void pause(int seconds) {
        this.report.info("Pause for [" + seconds + "] seconds");

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

    }

    public void assertPageURL(String url) {
        this.report.info("Assert [" + this.pageName + "] URL [" + url + "]");
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).isEqualToIgnoringCase(url);
    }

    public void assertPageContainsURL(String url) {
        this.report.info("Assert [" + this.pageName + "] URL contains [" + url + "]");
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).containsIgnoringCase(url);
    }

    public void assertPageURL() {
        String url = DriverManager.getDriver().getCurrentUrl();
        this.report.info("Assert [" + this.pageName + "] URL [" + url + "]");
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).isEqualToIgnoringCase(this.getPageURL());
    }

    public void assertPageContainsURL() {
        String url = DriverManager.getDriver().getCurrentUrl();
        this.report.info("Assert [" + this.pageName + "] URL contains [" + url + "]");
        Assertions.assertThat(DriverManager.getDriver().getCurrentUrl()).containsIgnoringCase(this.getPageURL());
    }

    public void refresh() {
        this.report.info("Refresh [" + this.pageName + "]");
        DriverManager.getDriver().navigate().refresh();
        this.waitUntilLoads();
    }

    public void navigateBack() {
        this.report.info("Navigate back [" + this.pageName + "]");
        DriverManager.getDriver().navigate().back();
        this.waitUntilLoads();
    }

    public void navigateForward() {
        this.report.info("Navigate forward [" + this.pageName + "]");
        DriverManager.getDriver().navigate().forward();
        this.waitUntilLoads();
    }
}
