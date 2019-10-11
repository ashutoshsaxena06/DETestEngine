
package com.de.core;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.log4j.Logger;
import org.fest.assertions.api.Assertions;
import org.fest.assertions.api.IntegerAssert;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileDownloader {
	private static final Logger LOG = Logger.getLogger(FileDownloader.class);
	private WebDriver driver;
	private String localDownloadPath;
	private boolean followRedirects;
	private boolean mimicWebDriverCookieState;
	private int httpStatusOfLastDownloadAttempt;

	public FileDownloader(WebDriver driverObject) {
		this.localDownloadPath = ExecutionConfig.TEMP_DATA_PATH;
		this.followRedirects = true;
		this.mimicWebDriverCookieState = true;
		this.httpStatusOfLastDownloadAttempt = 0;
		this.driver = driverObject;
	}

	public void followRedirectsWhenDownloading(boolean value) {
		this.followRedirects = value;
	}

	public String localDownloadPath() {
		return this.localDownloadPath;
	}

	public void localDownloadPath(String filePath) {
		this.localDownloadPath = filePath;
	}

	public String downloadFile(WebElement element, String fileName) throws Exception {
		return this.downloader(element, "href", fileName);
	}

	public String downloadImage(WebElement element, String fileName) throws Exception {
		return this.downloader(element, "src", fileName);
	}

	public int getHTTPStatusOfLastDownloadAttempt() {
		return this.httpStatusOfLastDownloadAttempt;
	}

	public void mimicWebDriverCookieState(boolean value) {
		this.mimicWebDriverCookieState = value;
	}

	private BasicCookieStore mimicCookieState(Set<Cookie> seleniumCookieSet) {
		BasicCookieStore mimicWebDriverCookieStore = new BasicCookieStore();
		Iterator var3 = seleniumCookieSet.iterator();

		while (var3.hasNext()) {
			Cookie seleniumCookie = (Cookie) var3.next();
			BasicClientCookie duplicateCookie = new BasicClientCookie(seleniumCookie.getName(),
					seleniumCookie.getValue());
			duplicateCookie.setDomain(seleniumCookie.getDomain());
			duplicateCookie.setSecure(seleniumCookie.isSecure());
			duplicateCookie.setExpiryDate(seleniumCookie.getExpiry());
			duplicateCookie.setPath(seleniumCookie.getPath());
			mimicWebDriverCookieStore.addCookie(duplicateCookie);
		}

		return mimicWebDriverCookieStore;
	}

	private String downloader(WebElement element, String attribute, String fileName)
			throws IOException, NullPointerException, URISyntaxException {
		String fileToDownloadLocation = element.getAttribute(attribute);
		if (fileToDownloadLocation.trim().equals("")) {
			throw new NullPointerException("The element you have specified does not link to anything!");
		} else {
			URL fileToDownload = new URL(fileToDownloadLocation);
			File downloadedFile = new File(this.localDownloadPath + "/" + fileName);
			if (!downloadedFile.canWrite()) {
				downloadedFile.setWritable(true);
			}

			HttpClient client = new DefaultHttpClient();
			BasicHttpContext localContext = new BasicHttpContext();
			LOG.info("Mimic WebDriver cookie state: " + this.mimicWebDriverCookieState);
			if (this.mimicWebDriverCookieState) {
				localContext.setAttribute("http.cookie-store",
						this.mimicCookieState(this.driver.manage().getCookies()));
			}

			HttpGet httpget = new HttpGet(fileToDownload.toURI());
			HttpParams httpRequestParameters = httpget.getParams();
			httpRequestParameters.setParameter("http.protocol.handle-redirects", this.followRedirects);
			httpget.setParams(httpRequestParameters);
			LOG.info("Sending GET request for: " + httpget.getURI());
			HttpResponse response = client.execute(httpget, localContext);
			((IntegerAssert) Assertions.assertThat(response.getStatusLine().getStatusCode())
					.as("File Downloading Failed: got status code other than 200")).isEqualTo(200);
			this.httpStatusOfLastDownloadAttempt = response.getStatusLine().getStatusCode();
			LOG.info("HTTP GET request status: " + this.httpStatusOfLastDownloadAttempt);
			LOG.info("Downloading file: " + downloadedFile.getName());
			FileUtils.copyInputStreamToFile(response.getEntity().getContent(), downloadedFile);
			response.getEntity().getContent().close();
			String downloadedFileAbsolutePath = downloadedFile.getAbsolutePath();
			LOG.info("File downloaded to '" + downloadedFileAbsolutePath + "'");
			return downloadedFileAbsolutePath;
		}
	}
}
