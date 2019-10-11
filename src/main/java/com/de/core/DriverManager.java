package com.de.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverManager {
	private static final ThreadLocal<WebDriverWait> webDriverPageWait;
	public static ThreadLocal<Boolean> driverStatusThread;
	private static List<WebDriverThread> webDriverThreadPool;
	private static ThreadLocal<WebDriverThread> driverThread;
	private static ThreadLocal<WebDriverWait> webDriverElementWait;
	private static ThreadLocal<Boolean> captureScreenShot;
	private static ThreadLocal<String> platformName;
	private static ThreadLocal<String> browserName;
	private static ThreadLocal<String> mobileEmulation;
	private static ThreadLocal<String> userAgent;

	static {
		DriverManager.webDriverThreadPool = Collections.synchronizedList(new ArrayList<WebDriverThread>());
		DriverManager.driverStatusThread = new ThreadLocal<Boolean>() {
			@Override
			protected Boolean initialValue() {
				return false;
			}
		};
		driverThread = new ThreadLocal<WebDriverThread>() {
			@Override
			protected WebDriverThread initialValue() {
				return new WebDriverThread();
			}
		};
		webDriverPageWait = new ThreadLocal<WebDriverWait>() {
			@Override
			protected WebDriverWait initialValue() {
				return super.initialValue();
			}
		};
		DriverManager.webDriverElementWait = new ThreadLocal<WebDriverWait>() {
			@Override
			protected WebDriverWait initialValue() {
				return super.initialValue();
			}
		};
		DriverManager.captureScreenShot = new ThreadLocal<Boolean>() {
			@Override
			protected Boolean initialValue() {
				return true;
			}
		};
		DriverManager.platformName = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
				return ExecutionConfig.PLATFORM;
			}
		};
		DriverManager.browserName = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
				return ExecutionConfig.BROWSER;
			}
		};
		DriverManager.mobileEmulation = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
				return ExecutionConfig.MOBILE_EMULATION;
			}
		};
		DriverManager.userAgent = new ThreadLocal<String>() {
			@Override
			protected String initialValue() {
				return ExecutionConfig.USER_AGENT;
			}
		};
	}

	public static WebDriver getDriver() {
		final WebDriverThread webDriverThread = DriverManager.driverThread.get();
		if (webDriverThread.getWebDriver() != null && (!webDriverThread.getBrowser().equalsIgnoreCase(getBrowserName())
				|| !webDriverThread.getPlatform().equalsIgnoreCase(getPlatformName())
				|| !webDriverThread.getMobileEmulation().equalsIgnoreCase(getMobileEmulation())
				|| !webDriverThread.getUserAgent().equalsIgnoreCase(getUserAgent()))) {
			System.out.println("quitDriver() is called in getDriver()");
			webDriverThread.quitDriver();
		}
		final WebDriver driver = DriverManager.driverThread.get().getDriver();
		if (!DriverManager.driverStatusThread.get()) {
			DriverManager.webDriverPageWait.set(new WebDriverWait(driver, ExecutionConfig.MAX_PAGE_LOAD_WAIT_TIME));
			DriverManager.webDriverElementWait
					.set(new WebDriverWait(driver, ExecutionConfig.MAX_ELEMENT_LOAD_WAIT_TIME));
			DriverManager.driverStatusThread.set(true);
		}
		return driver;
	}

	public static WebDriver getCurrentWebDriver() {
		return DriverManager.driverThread.get().getWebDriver();
	}

	public static String getPlatformName() {
		return DriverManager.platformName.get();
	}

	public static void setPlatformName(final String platform) {
		DriverManager.platformName.set(platform);
	}

	public static String getBrowserName() {
		return DriverManager.browserName.get();
	}

	public static void setBrowserName(final String browser) {
		DriverManager.browserName.set(browser);
	}

	public static String getMobileEmulation() {
		return DriverManager.mobileEmulation.get();
	}

	public static void setMobileEmulation(final String mobileEmulationValue) {
		DriverManager.mobileEmulation.set(mobileEmulationValue);
	}

	public static String getUserAgent() {
		return DriverManager.userAgent.get();
	}

	public static void setUserAgent(final String userAgentValue) {
		DriverManager.userAgent.set(userAgentValue);
	}

	public static Boolean getCaptureScreenShot() {
		return DriverManager.captureScreenShot.get();
	}

	public static void setCaptureScreenShot(final Boolean captureScreenShot) {
		DriverManager.captureScreenShot.set(captureScreenShot);
	}

	public static WebDriverWait getWebDriverPageWait() {
		return DriverManager.webDriverPageWait.get();
	}

	public static void setWebDriverPageWait(final int seconds) {
		DriverManager.webDriverPageWait.set(new WebDriverWait(getDriver(), seconds));
	}

	public static WebDriverWait getWebDriverElementWait() {
		return DriverManager.webDriverElementWait.get();
	}

	public static void setWebDriverElementWait(final int seconds) {
		DriverManager.webDriverElementWait.set(new WebDriverWait(getDriver(), seconds));
	}

	public static void resetWebDriverPageWait() {
		if (DriverManager.driverThread.get().getWebDriver() != null) {
			DriverManager.webDriverPageWait
					.set(new WebDriverWait(getDriver(), ExecutionConfig.MAX_PAGE_LOAD_WAIT_TIME));
		}
	}

	public static void resetWebDriverElementWait() {
		if (DriverManager.driverThread.get().getWebDriver() != null) {
			DriverManager.webDriverElementWait
					.set(new WebDriverWait(getDriver(), ExecutionConfig.MAX_ELEMENT_LOAD_WAIT_TIME));
		}
	}

	public static void closeCurrentDriver() {
		DriverManager.driverThread.get().quitDriver();
	}

	public static void closeDriverObjects() {
		for (final WebDriverThread webDriverThread : DriverManager.webDriverThreadPool) {
			webDriverThread.quitDriver();
		}
	}
}