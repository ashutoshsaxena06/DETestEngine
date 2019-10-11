package com.de.ui.elements;

import org.fest.assertions.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.de.core.DriverManager;
import com.de.reporting.Assertion;
import com.de.reporting.TestStep;
import com.de.reporting.Utility;

public class RadioButton extends UIElement {
	/**
	 * @deprecated
	 */
	@Deprecated
	public RadioButton(By by, String pageName) {
		super(by, pageName);
	}

	public RadioButton(By by, String pageName, String elementName) {
		super(by, pageName, elementName);
	}

	public RadioButton(WebElement webElement, String pageName, String elementName) {
		super(webElement, pageName, elementName);
	}

	@TestStep
	public void select() {
		this.report.info("Select [" + this.getElementName() + "] on [" + this.getPageName() + "]");
		if (!this.isSelected()) {
			this.click();
		}

	}

	@Utility
	public boolean isSelected() {
		return this.getWrappedElement().isSelected();
	}

	@Assertion
	public void assertSelected() {
		this.report.info("Assert [" + this.getElementName() + "] is selected on [" + this.getPageName() + "]");
		Assertions.assertThat(this.getWrappedElement().isSelected())
				.as(this.getElementName() + " is expected to be selected but is not").isEqualTo(true);
	}

	@Assertion
	public void assertDeSelected() {
		this.report.info("Assert [" + this.getElementName() + "] is not selected on [" + this.getPageName() + "]");
		Assertions.assertThat(this.getWrappedElement().isSelected())
				.as(this.getElementName() + " is expected to be not selected but is").isEqualTo(false);
	}

	@Utility
	public void waitUntilSelected() {
		this.report.info("Wait until [" + this.getElementName() + "] is selected on [" + this.getPageName() + "]");

		try {
			DriverManager.getWebDriverElementWait()
					.until(ExpectedConditions.elementSelectionStateToBe(this.getBy(), true));
		} catch (TimeoutException var2) {
		}

	}

	@Utility
	public void waitUntilDeSelected() {
		this.report.info("Wait until [" + this.getElementName() + "] is not selected on [" + this.getPageName() + "]");

		try {
			DriverManager.getWebDriverElementWait()
					.until(ExpectedConditions.elementSelectionStateToBe(this.getBy(), false));
		} catch (TimeoutException var2) {
		}

	}
}
