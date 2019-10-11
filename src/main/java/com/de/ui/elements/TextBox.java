package com.de.ui.elements;

import com.de.reporting.TestStep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextBox extends UIElement {
    /**
     * @deprecated
     */
    @Deprecated
    public TextBox(By by, String pageName) {
        super(by, pageName);
    }

    public TextBox(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }

    @TestStep
    public void clearAndType(CharSequence... keysToSend) {
        this.clear();
        this.type(keysToSend);
    }

    @TestStep
    public void clearEscAndType(CharSequence... keysToSend) {
        this.clear();
        this.getWrappedElement().sendKeys(Keys.ESCAPE);
        this.type(keysToSend);
    }

    @TestStep
    public void type(CharSequence... keysToSend) {
        this.sendKeys(keysToSend);
    }
}
