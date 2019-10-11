

package com.de.reporting.reports;

import java.io.File;

public class MultiReport implements Report {
    private final Report[] reports;

    public MultiReport(Report... reports) {
        this.reports = reports;
    }

    public void step(String s, Object... valuesToBeReplacePlaceholders) {
        Report[] var3 = this.reports;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Report report = var3[var5];
            report.step(s, valuesToBeReplacePlaceholders);
        }

    }

    public void info(String s, Object... valuesToBeReplacePlaceholders) {
        Report[] var3 = this.reports;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Report report = var3[var5];
            report.info(s, valuesToBeReplacePlaceholders);
        }

    }

    public void warn(String s, Object... valuesToBeReplacePlaceholders) {
        Report[] var3 = this.reports;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Report report = var3[var5];
            report.warn(s, valuesToBeReplacePlaceholders);
        }

    }

    public void error(String s, Object... valuesToBeReplacePlaceholders) {
        Report[] var3 = this.reports;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Report report = var3[var5];
            report.error(s, valuesToBeReplacePlaceholders);
        }

    }

    public void attachImage(File file, String imageName) {
        Report[] var3 = this.reports;
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            Report report = var3[var5];
            report.attachImage(file, imageName);
        }

    }

    public void attachHtml(File file) {
        Report[] var2 = this.reports;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Report report = var2[var4];
            report.info("<a href=\"" + file.getName() + "\" target=\"_blank\"><b>API Response</b></a><br>", new Object[]{""});
        }

    }
}
