package com.de.reporting.reports;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class AllureReport implements Report {
    public AllureReport() {
    }

    public void step(String s, Object... valuesToBeReplacePlaceholders) {
        this.innerStep(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void info(String s, Object... valuesToBeReplacePlaceholders) {
        this.innerStep(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void warn(String s, Object... valuesToBeReplacePlaceholders) {
        this.innerStep(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void error(String s, Object... valuesToBeReplacePlaceholders) {
        this.innerStep(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void attachHtml(File file) {
        this.attachHTMLFile(file);
    }

    public void attachImage(File file, String imageName) {
        if (!imageName.isEmpty()) {
            this.attachScreenshot(file, imageName);
        } else {
            this.attachScreenshot(file, "Screenshot");
        }

    }

    private String formatLoggingString(String s, Object... valuesToBeReplacePlaceholders) {
        Object[] var3 = valuesToBeReplacePlaceholders;
        int var4 = valuesToBeReplacePlaceholders.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Object o = var3[var5];
            s = s.replaceFirst("\\{\\}", o.toString());
        }

        return s;
    }

    @Step("{0}")
    private void innerStep(String step) {
    }

    @Attachment(
        value = "{1}",
        type = "image/png"
    )
    private byte[] attachScreenshot(File file, String imageName) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException var4) {
            this.warn("Exception occured {}", var4);
            return null;
        }
    }

    @Attachment(
        value = "Screenshot",
        type = "image/png"
    )
    private byte[] attachScreenshot(File file) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException var3) {
            this.warn("Exception occured {}", var3);
            return null;
        }
    }

    @Attachment(
        value = "Response",
        type = "text/html"
    )
    private byte[] attachHTMLFile(File file) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException var3) {
            this.warn("Exception occured {}", var3);
            return null;
        }
    }
}
