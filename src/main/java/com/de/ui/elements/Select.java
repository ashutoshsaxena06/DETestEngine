package com.de.ui.elements;

import com.de.core.DriverManager;
import com.de.reporting.TestStep;
import com.de.reporting.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Select extends UIElement {
    /**
     * @deprecated
     */
    @Deprecated
    public Select(By by, String pageName) {
        super(by, pageName);
    }

    public Select(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }

    @Utility
    public boolean isMultiple() {
        return (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).isMultiple();
    }

    @TestStep
    public void deselectByIndex(int index) {
        this.report.info("De-select [" + this.getElementName() + "] option at position [" + index + "] on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).deselectByIndex(index);
    }

    @TestStep
    public void selectByValue(String value) {
        this.report.info("Select [" + this.getElementName() + "] option with value [" + value + "] on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).selectByValue(value);
    }

    @Utility
    public WebElement getFirstSelectedOption() {
        return (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).getFirstSelectedOption();
    }

    @TestStep
    public void selectByVisibleText(String text) {
        this.report.info("Select [" + this.getElementName() + "] option with text [" + text + "] on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).selectByVisibleText(text);
    }

    @TestStep
    public void deselectByValue(String value) {
        this.report.info("De-Select [" + this.getElementName() + "] option with value [" + value + "] on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).deselectByValue(value);
    }

    @TestStep
    public void deselectAll() {
        this.report.info("De-select [" + this.getElementName() + "] all options on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).deselectAll();
    }

    @Utility
    public List<WebElement> getAllSelectedOptions() {
        return (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).getAllSelectedOptions();
    }

    @Utility
    public List<WebElement> getOptions() {
        return (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).getOptions();
    }

    @TestStep
    public void deselectByVisibleText(String text) {
        this.report.info("De-select [" + this.getElementName() + "] option with text [" + text + "] on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).deselectByVisibleText(text);
    }

    @TestStep
    public void selectByIndex(int index) {
        this.report.info("Select [" + this.getElementName() + "] option at position [" + index + "] on [" + this.getPageName() + "]");
        (new org.openqa.selenium.support.ui.Select(this.getWrappedElement())).selectByIndex(index);
    }

    @Utility
    public void waitUntilSelected() {
        this.report.info("Wait until [" + this.getElementName() + "] option is selected on [" + this.getPageName() + "]");

        try {
            DriverManager.getWebDriverElementWait().until(ExpectedConditions.elementSelectionStateToBe(this.getBy(), true));
        } catch (TimeoutException var2) {
        }

    }

    @Utility
    public void waitUntilDeSelected() {
        this.report.info("Wait until [" + this.getElementName() + "] option is de-selected on [" + this.getPageName() + "]");

        try {
            DriverManager.getWebDriverElementWait().until(ExpectedConditions.elementSelectionStateToBe(this.getBy(), false));
        } catch (TimeoutException var2) {
        }

    }

    @Utility
    public void waitUntilOptionToBeSelectedByVisibeText(String optionText) {
        this.report.info("Wait until [" + this.getElementName() + "] option with text [" + optionText + "] is selected on [" + this.getPageName() + "]");

        try {
//            DriverManager.getWebDriverElementWait().until(MoreExpectedConditions.optionToBeSelectedInElement(new org.openqa.selenium.support.ui.Select(this.getWrappedElement()), optionText, true));
        } catch (TimeoutException var3) {
        }

    }

    @Utility
    public void waitUntilOptionToBeSelectedByValue(String optionValue) {
        this.report.info("Wait until [" + this.getElementName() + "] option with value [" + optionValue + "] is selected on [" + this.getPageName() + "]");

        try {
//            DriverManager.getWebDriverElementWait().until(MoreExpectedConditions.optionToBeSelectedInElement(new org.openqa.selenium.support.ui.Select(this.getWrappedElement()), optionValue, false));
        } catch (TimeoutException var3) {
        }

    }
}
