package com.de.ui.elements;

import java.util.Arrays;
import java.util.List;

import org.fest.assertions.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.de.core.DriverManager;
import com.de.reporting.Assertion;
import com.de.reporting.Reporter;
import com.de.reporting.TestStep;
import com.de.reporting.Utility;
import com.de.reporting.reports.Report;

public class UIElement implements WebElement, WrapsElement, Locatable {
    JavascriptExecutor js;
    WebDriver driver;
    Report report;
    private String elementName;
    private String pageName;
    private By by;
    private WebElement webElement;

    /**
     * @deprecated
     */
    @Deprecated
    public UIElement(By by, String elementName) {
        this.report = Reporter.report;
        this.by = by;
        this.pageName = "web-page";
        this.elementName = elementName;
        this.driver = DriverManager.getDriver();
        this.js = (JavascriptExecutor) this.driver;
    }

    public UIElement(By by, String pageName, String elementName) {
        this.report = Reporter.report;
        this.by = by;
        this.pageName = pageName;
        this.elementName = elementName;
        this.driver = DriverManager.getDriver();
        this.js = (JavascriptExecutor) this.driver;
    }

    public UIElement(WebElement webElement, String pageName, String elementName) {
        this.report = Reporter.report;
        this.webElement = webElement;
        this.pageName = pageName;
        this.elementName = elementName;
        this.driver = DriverManager.getDriver();
        this.js = (JavascriptExecutor) this.driver;
    }

    public UIElement(By by, String pageName, String elementName, Report report) {
        this.report = Reporter.report;
        this.by = by;
        this.pageName = pageName;
        this.elementName = elementName;
        this.driver = DriverManager.getDriver();
        this.js = (JavascriptExecutor) this.driver;
        this.report = report;
    }

    public String getPageName() {
        return this.pageName;
    }

    public String getElementName() {
        return this.elementName;
    }

    public By getBy() {
        return this.by;
    }

    @TestStep
    public void click() {
        this.report.info("Click [" + this.elementName + "] on [" + this.pageName + "]");
        ((JavascriptExecutor) this.driver).executeScript("arguments[0].click();", this.getWrappedElement());
    }

    private void highlightElement(WebElement element, int duration) throws InterruptedException {
        String original_style = element.getAttribute("style");
        this.js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 5px solid red; border-style: solid;");
        if (duration > 0) {
            Thread.sleep(duration * 500);
            this.js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", original_style);
        }

    }

    @TestStep
    public void sendKeys(CharSequence... keysToSend) {
        this.report.info("Enter text [" + Arrays.toString(keysToSend) + "] in [" + this.elementName + "] on [" + this.pageName + "]");
        this.getWrappedElement().sendKeys(keysToSend);
    }

    @Utility
    public Point getLocation() {
        return this.getWrappedElement().getLocation();
    }

    @TestStep
    public void submit() {
        this.report.info("Click [" + this.elementName + "] on [" + this.pageName + "] to submit");
        this.getWrappedElement().submit();
    }

    @Utility
    public String getAttribute(String name) {
        return this.getWrappedElement().getAttribute(name);
    }

    @Utility
    public String getCssValue(String propertyName) {
        return this.getWrappedElement().getCssValue(propertyName);
    }

    @Utility
    public Dimension getSize() {
        return this.getWrappedElement().getSize();
    }

    @Utility
    public Rectangle getRect() {
        throw new UnsupportedOperationException();
    }

    public List<WebElement> findElements(By by) {
        return this.getWrappedElement().findElements(by);
    }

    @Utility
    public String getText() {
        return this.getWrappedElement().getText();
    }

    @Utility
    public String getTagName() {
        return this.getWrappedElement().getTagName();
    }

    @Utility
    public boolean isSelected() {
        return this.getWrappedElement().isSelected();
    }

    public WebElement findElement(By by) {
        return this.getWrappedElement().findElement(by);
    }

    @Utility
    public boolean isEnabled() {
        return this.getWrappedElement().isEnabled();
    }

    @Utility
    public boolean isDisplayed() {
        return this.getWrappedElement().isDisplayed();
    }

    @TestStep
    public void clear() {
        this.report.info("Clear text in [" + this.elementName + "] on [" + this.pageName + "]");
        this.getWrappedElement().clear();
    }

    public WebElement getWrappedElement() {
        if (this.webElement == null) {
            try {
                this.webElement = DriverManager.getDriver().findElement(this.by);
            } catch (NoSuchElementException var2) {
                throw new NoSuchElementException(this.elementName + " is not found on " + this.pageName, var2);
            }
        }

        return this.webElement;
    }

    @Utility
    public Coordinates getCoordinates() {
        return ((Locatable) this.getWrappedElement()).getCoordinates();
    }

    public boolean elementWired() {
        return this.webElement != null;
    }

    public void focus() {
        this.report.info("Focus [" + this.elementName + "] on [" + this.pageName + "]");
        (new Actions(DriverManager.getDriver())).moveToElement(this.getWrappedElement()).perform();
    }

    @Assertion
    public void assertVisible() {
        this.report.info("Assert [" + this.elementName + "] is visible on [" + this.pageName + "]");
        if (!this.isElementPresent() || ExpectedConditions.visibilityOfElementLocated(this.by).apply(this.driver) == null) {
            throw new AssertionError(this.elementName + " is expected to be visible but it is not");
        }
    }

    @Assertion
    public void assertNotVisible() {
        this.report.info("Assert [" + this.elementName + "] is not visible on [" + this.pageName + "]");
        if (this.isElementPresent() && ExpectedConditions.visibilityOfElementLocated(this.by).apply(this.driver) instanceof WebElement) {
            throw new AssertionError(this.elementName + " is expected to be not visible but it is");
        }
    }

    @Assertion
    public void assertText(String text) {
        this.report.info("Assert [" + this.elementName + "] text equals [" + text + "] on [" + this.pageName + "]");
        if (!this.isElementPresent() || !ExpectedConditions.textToBe(this.by, text).apply(this.driver)) {
            throw new AssertionError("text of " + this.elementName + " is expected to be equal to " + text + " but it is not");
        }
    }

    @Assertion
    public void assertContainsText(String text) {
        this.report.info("Assert [" + this.elementName + "] contains text [" + text + "] on [" + this.pageName + "]");
        if (!this.isElementPresent() || !ExpectedConditions.textToBePresentInElementLocated(this.by, text).apply(this.driver)) {
            throw new AssertionError(this.elementName + " is expected to contain text - '" + text + "' but it is not");
        }
    }

    @Assertion
    public void assertDoesNotContainText(String text) {
        this.report.info("Assert [" + this.elementName + "] doesn't contain text [" + text + "] on [" + this.pageName + "]");
        if (this.isElementPresent() && ExpectedConditions.textToBePresentInElementLocated(this.by, text).apply(this.driver)) {
            throw new AssertionError(this.elementName + " is expected to not contain text - '" + text + "' but it does");
        }
    }

    @Assertion
    public void assertValue(String value) {
        this.report.info("Assert [" + this.elementName + "] value equals [" + value + "] on [" + this.pageName + "]");
        if (!this.isElementPresent() || !ExpectedConditions.attributeToBe(this.by, "value", value).apply(this.driver)) {
            throw new AssertionError("value of " + this.elementName + " is expected to be equal to " + value + " but it is not");
        }
    }

    @Assertion
    public void assertAttribute(String attribute, String value) {
        this.report.info("Assert [" + this.elementName + "] value equals [" + value + "] on [" + this.pageName + "]");
        if (!this.isElementPresent() || !ExpectedConditions.attributeToBe(this.by, attribute, value).apply(this.driver)) {
            throw new AssertionError("element attribute - " + attribute + " is expected to have value equals to " + value + " but it does not");
        }
    }

    @Assertion
    public void assertContainsValue(String value) {
        this.report.info("Assert [" + this.elementName + "] contains value [" + value + "] on [" + this.pageName + "]");
        String assertionMsg = "value of " + this.elementName + " is expected to be contain value - " + value + " but it is does not";

        try {
            WebElement webElement = ExpectedConditions.presenceOfElementLocated(this.by).apply(this.driver);
            Assertions.assertThat(webElement.getAttribute("value")).as(assertionMsg).containsIgnoringCase(value);
        } catch (NoSuchElementException var4) {
            throw new AssertionError(assertionMsg);
        }
    }

    @Assertion
    public void assertDoesNotContainValue(String value) {
        this.report.info("Assert [" + this.elementName + "] doesn't contain value [" + value + "] on [" + this.pageName + "]");
        String assertionMsg = "value of " + this.elementName + " is expected to be not contain value - " + value + " but it is does";

        try {
            WebElement webElement = ExpectedConditions.presenceOfElementLocated(this.by).apply(this.driver);
            Assertions.assertThat(webElement.getAttribute("value")).as(assertionMsg).doesNotContain(value);
        } catch (NoSuchElementException var4) {
        }

    }

    @Utility
    private boolean isFocused() {
        return this.getWrappedElement().equals(DriverManager.getDriver().switchTo().activeElement());
    }

    @Utility
    public void switchToFrame() {
        DriverManager.getDriver().switchTo().frame(this.getWrappedElement());
    }

    @Assertion
    public void assertIsFocused() {
        this.report.info("Assert [" + this.elementName + " is focused on [" + this.pageName + "]");
        Assertions.assertThat(this.isFocused()).as(this.elementName + " is expected to be focused but is not").isEqualTo(true);
    }

    @Assertion
    public void assertIsNotFocused() {
        this.report.info("Assert [" + this.elementName + " is not focused on [" + this.pageName + "]");
        Assertions.assertThat(this.isFocused()).as(this.elementName + " is expected to be not focused but is").isEqualTo(false);
    }

    @Utility
    public void waitUntilContainsText(String text) {
        String debugMsg = "Wait until [" + this.elementName + "] contains text [" + text + "] on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.textToBePresentInElementLocated(this.getBy(), text));
    }

    @Utility
    public void waitUntilDoesNotContainText(String text) {
        String debugMsg = "Wait until [" + this.elementName + "] contains text [" + text + "] on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElementLocated(this.getBy(), text)));
    }

    @Utility
    public void waitUntilVisible() {
        String debugMsg = "Wait until [" + this.elementName + "] is visible on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.visibilityOfElementLocated(this.getBy()));
    }

    @Utility
    public void waitUntilPresent() {
        String debugMsg = "Wait until [" + this.elementName + "] is present on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.presenceOfElementLocated(this.getBy()));
    }

    @Utility
    public void waitUntilNotVisible() {
        String debugMsg = "Wait until [" + this.elementName + "] is not visible on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.invisibilityOfElementLocated(this.getBy()));
    }

    @Utility
    public void waitUntilEditable() {
        String debugMsg = "Wait until [" + this.elementName + "] is editable on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.elementToBeClickable(this.getBy()));
    }

    @Utility
    public void waitUntilNotEditable() {
        String debugMsg = "Wait until [" + this.elementName + "] is not editable on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(this.getBy())));
    }

//    @Utility
//    public void waitUntilContainsAttributeValue(String attributeName, String attributeValue) {
//        String debugMsg = "Wait until [" + this.elementName + "] attribute [" + attributeName + "] contains value [" + attributeValue + "] on [" + this.pageName + "]";
//        this.report.info(debugMsg);
//        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(MoreExpectedConditions.attributeValueToBeContainedInElement(this.getBy(), attributeName, attributeValue));
//    }
//
//    @Utility
//    public void waitUntilDoesNotContainAttributeValue(String attributeName, String attributeValue) {
//        String debugMsg = "Wait until [" + this.elementName + "] attribute [" + attributeName + "] does not contains value [" + attributeValue + "] on [" + this.pageName + "]";
//        this.report.info(debugMsg);
//        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.not(MoreExpectedConditions.attributeValueToBeContainedInElement(this.getBy(), attributeName, attributeValue)));
//    }
//
//    @Utility
//    public void waitUntilContainsAttribute(String attributeName) {
//        String debugMsg = "Wait until [" + this.elementName + "] contains attribute [" + attributeName + "] on [" + this.pageName + "]";
//        this.report.info(debugMsg);
//        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(MoreExpectedConditions.attributeToBeContainedInElement(this.getBy(), attributeName));
//    }
//
//    @Utility
//    public void waitUntilDoesNotContainAttribute(String attributeName) {
//        String debugMsg = "Wait until [" + this.elementName + "] does not contains attribute [" + attributeName + "] on [" + this.pageName + "]";
//        this.report.info(debugMsg);
//        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.not(MoreExpectedConditions.attributeToBeContainedInElement(this.getBy(), attributeName)));
//    }

    public UIElement and() {
        return this;
    }

    public void scrollToView() {
        this.report.info("Scroll [" + this.elementName + "] to view on [" + this.pageName + "]");
        String script = "arguments[0].scrollIntoView(true);";
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript(script, this.getWrappedElement());
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }

    @Assertion
    public void assertDisabled() {
        this.report.info("Assert [" + this.elementName + " is disabled on [" + this.pageName + "]");
        if (this.isElementPresent() && ExpectedConditions.elementToBeClickable(this.by).apply(this.driver) instanceof WebElement) {
            throw new AssertionError(this.elementName + " is expected to be disabled but it is not");
        }
    }

    @Assertion
    public void assertEnabled() {
        this.report.info("Assert [" + this.elementName + " is enabled on [" + this.pageName + "]");
        if (!this.isElementPresent() || ExpectedConditions.elementToBeClickable(this.by).apply(this.driver) == null) {
            throw new AssertionError(this.elementName + " is expected to be enabled but is not");
        }
    }

    @Assertion
    public void assertClickable() {
        this.report.info("Assert [" + this.getElementName() + "] is clickable on [" + this.getPageName() + "]");
        if (!this.isElementPresent() || ExpectedConditions.elementToBeClickable(this.by).apply(this.driver) == null) {
            throw new AssertionError(this.elementName + " is expected to be clickable but is not");
        }
    }

    @Assertion
    public void assertNotClickable() {
        this.report.info("Assert [" + this.getElementName() + "] is not clickable on [" + this.getPageName() + "]");
        if (this.isElementPresent() && ExpectedConditions.elementToBeClickable(this.by).apply(this.driver) instanceof WebElement) {
            throw new AssertionError(this.elementName + " is expected to be not clickable but is");
        }
    }

    @Utility
    public void waitUntilClickable() {
        String debugMsg = "Wait until [" + this.elementName + "] is clickable on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.elementToBeClickable(this.getBy()));
    }

    @Utility
    public void waitUntilNotClickable() {
        String debugMsg = "Wait until [" + this.elementName + "] is not clickable on [" + this.pageName + "]";
        this.report.info(debugMsg);
        DriverManager.getWebDriverElementWait().withMessage(debugMsg).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(this.getBy())));
    }

    private boolean isElementPresent() {
        try {
            ExpectedConditions.presenceOfElementLocated(this.by).apply(this.driver);
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }
    }
}
