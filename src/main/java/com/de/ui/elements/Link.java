

package com.de.ui.elements;

import org.openqa.selenium.By;

public class Link extends UIElement {
    /** @deprecated */
    @Deprecated
    public Link(By by, String pageName) {
        super(by, pageName);
    }

    public Link(By by, String pageName, String elementName) {
        super(by, pageName, elementName);
    }
}
