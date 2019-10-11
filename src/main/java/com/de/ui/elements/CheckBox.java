package com.de.ui.elements;

import com.de.core.DriverManager;
import com.de.reporting.Assertion;
import com.de.reporting.TestStep;
import com.de.reporting.Utility;
import org.fest.assertions.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckBox extends UIElement {
    /**
     * @deprecated
     */
    @Deprecated
    public CheckBox(By by, String pageName) {
        super(by, pageName);
    }

    public CheckBox(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }

    public CheckBox(WebElement webElement, String pageName, String elementName) {
        super(webElement, pageName, elementName);
    }

    @TestStep
    public void toggle() {
        this.report.info("Click [" + this.getElementName() + "] on [" + this.getPageName() + "]");
        this.click();
    }

    @TestStep
    public void check() {
        this.report.info("Check [" + this.getElementName() + "] on [" + this.getPageName() + "]");
        if (!this.isChecked()) {
            this.toggle();
        }

    }

    @TestStep
    public void unCheck() {
        this.report.info("Uncheck [" + this.getElementName() + "] on [" + this.getPageName() + "]");
        if (this.isChecked()) {
            this.toggle();
        }

    }

    @Utility
    public boolean isChecked() {
        return this.getWrappedElement().isSelected();
    }

    @Assertion
    public void assertChecked() {
        this.report.info("Assert [" + this.getElementName() + "] is checked on [" + this.getPageName() + "]");
        Assertions.assertThat(this.isChecked()).as(this.getElementName() + " is expected to be checked but is not").isEqualTo(true);
    }

    @Assertion
    public void assertUnChecked() {
        this.report.info("Assert [" + this.getElementName() + "] is un-checked on [" + this.getPageName() + "]");
        Assertions.assertThat(this.isChecked()).as(this.getElementName() + " is expected to be not checked but is").isEqualTo(false);
    }

    @Utility
    public void waitUntilChecked() {
        this.report.info("Wait until [" + this.getElementName() + "] is checked on [" + this.getPageName() + "]");

        try {
            DriverManager.getWebDriverElementWait().until(ExpectedConditions.elementSelectionStateToBe(this.getBy(), true));
        } catch (TimeoutException var2) {
        }

    }

    @Utility
    public void waitUntilUnChecked() {
        this.report.info("Wait until [" + this.getElementName() + "] is un-checked on [" + this.getPageName() + "]");

        try {
            DriverManager.getWebDriverElementWait().until(ExpectedConditions.elementSelectionStateToBe(this.getBy(), false));
        } catch (TimeoutException var2) {
        }

    }
}
