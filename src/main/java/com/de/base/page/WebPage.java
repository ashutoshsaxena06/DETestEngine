
package com.de.base.page;

import com.de.core.DriverManager;
import com.de.reporting.TestStep;
import java.util.function.BooleanSupplier;


public abstract class WebPage {
    private final String url;

    public WebPage(String url) {
        this.url = url;
    }

    public WebPage() {
        this((String)null);
    }

    @TestStep
    public void launch() {
        DriverManager.getDriver().get(this.url);
    }

    public BooleanSupplier isLoading() {
        return new BooleanSupplier() {
            public boolean getAsBoolean() {

            return false;}
        };
    }

    public BooleanSupplier hasLoaded() {
        return new BooleanSupplier() {
            public boolean getAsBoolean() {

                return false;}
        };
    }

//    public abstract String toString();
}
