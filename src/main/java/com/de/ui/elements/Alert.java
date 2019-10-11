
package com.de.ui.elements;

import com.de.reporting.TestStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

public class Alert extends UIElement {
	
    /** @deprecated */
    @Deprecated
    public Alert(By by, String pageName) {
        super(by, pageName);
    }

    public Alert(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }

    @TestStep
    public void accept() {
        this.report.info("Accept alert [" + this.getElementName() + " on [" + this.getPageName() + "]", new Object[0]);
        WebElement button = this.getWrappedElement().findElement(By.tagName("button"));

        try {
            button.click();
        } catch (WebDriverException var5) {
            if (!var5.getMessage().contains("unknown error: Element is not clickable at point")) {
                throw var5;
            }

            this.report.info("Retrying due to the error: Element is not clickable at point(X, Y)", new Object[0]);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }

            button.click();
        }

    }

    @TestStep
    public void close() {
        this.report.info("Close alert [" + this.getElementName() + " on [" + this.getPageName() + "]", new Object[0]);
        WebElement cross = this.getWrappedElement().findElement(By.cssSelector(".ui-icon.ui-icon-closethick"));

        try {
            cross.click();
        } catch (WebDriverException var5) {
            if (!var5.getMessage().contains("unknown error: Element is not clickable at point")) {
                throw var5;
            }

            this.report.info("Retrying due to the error: Element is not clickable at point(X, Y)<br>", new Object[0]);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var4) {
                var4.printStackTrace();
            }

            cross.click();
        }

    }
}
