package com.framework.commonUtils;

//import static org.hamcrest.Matchers.assertThat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.de.base.page.BasePage;
import com.de.core.DriverManager;
import com.de.ui.elements.UIElement;

public abstract class Page extends BasePage{

	public Page(String pageName) {
		super(pageName);
	}

	public static WebDriver getDriver() {
		return DriverManager.getDriver();
	}

	public abstract UIElement getUniqueElementInPage();

	private static String parentHandle;
	private static String childHandle;
	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}

	public String getParentHandle() {
		
		return parentHandle;
	}

	public void setParentHandle() {
		parentHandle = getDriver().getWindowHandle();
	}

	public String getChildHandle() {
		return childHandle;
	}

	public void setChildHandle() {
		for (String winHandle : getDriver().getWindowHandles()) {
			if (!parentHandle.equals(winHandle)) {
				childHandle = winHandle;
				break;
			}
		}
	}

	public void maximize() {
		getDriver().manage().window().maximize();
	}

	public void switchToChildWindow() {
		setChildHandle();
		getDriver().switchTo().window(childHandle);
		maximize();
	}

	public void switchToParentWindow() {
		getDriver().switchTo().window(parentHandle);
	}

	public void switchToFrame(String frameName, int... waitTime) {
		WaitForFrameToLoad(frameName, waitTime);
		getDriver().switchTo().frame(frameName);
	}

	public Wait<WebDriver> Wait(int... waitTime) {
		int waitTimeInSeconds;
		if (waitTime.length > 0) {
			waitTimeInSeconds = waitTime[0];
		} else {
			waitTimeInSeconds = 5;
		}
		return new FluentWait<WebDriver>(getDriver()).withTimeout(waitTimeInSeconds, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class).ignoring(WebDriverException.class);
	}

	public void WaitForPageToLoad(int... waitTime) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		if (waitTime.length > 0) {
			Wait(waitTime).until(expectation);
		} else {
			Wait(30).until(expectation);
		}
	}

	public void WaitForFrameToLoad(final String frameName, int... waitTime) {
		getDriver().switchTo().defaultContent();
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.switchTo().frame(frameName) != null;
			}
		};
		if (waitTime.length > 0) {
			Wait(waitTime).until(expectation);
		} else {
			Wait(30).until(expectation);
		}
		getDriver().switchTo().defaultContent();
	}

	public void shouldExist(Page page, int... waitTime) {
		WaitForPageToLoad(waitTime);
		if (!page.getUniqueElementInPage().isDisplayed()) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
//		assertThat("User is not in the page : " + page.getClass().getSimpleName(),
//				page.getUniqueElementInPage().isDisplayed());
	}

	public boolean isExist(Page page, int... waitTime) {
		WaitForPageToLoad(waitTime);
		return page.getUniqueElementInPage().isDisplayed();
	}
}
