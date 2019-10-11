
package com.de.listener.decorator;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.de.reporting.Extent;

import java.io.File;
import java.io.IOException;

public class ExtentReport implements Report {
    private final ExtentReports extent;
    private final ThreadLocal<ExtentTest> test;

    public ExtentReport(File file) {
        this.extent = Extent.REPORT;
        this.test = Extent.TEST;
        file.getParentFile().mkdirs();

        try {
            file.createNewFile();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(file.getPath());
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(false);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(file.getName());
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(file.getName());
        this.extent.attachReporter(new ExtentReporter[]{htmlReporter});
    }

    public ExtentReport() {
        this(new File(System.getProperty("REPORT_MAIN_DIRECTORY") + "/html/extentReport.html"));
    }

    public void step(String s, Object... valuesToBeReplacePlaceholders) {
        ((ExtentTest)this.test.get()).info(this.formatLoggingString("<b>" + s, valuesToBeReplacePlaceholders));
    }

    public void info(String s, Object... valuesToBeReplacePlaceholders) {
        ((ExtentTest)this.test.get()).info(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void warn(String s, Object... valuesToBeReplacePlaceholders) {
        ((ExtentTest)this.test.get()).warning(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void error(String s, Object... valuesToBeReplacePlaceholders) {
        ((ExtentTest)this.test.get()).error(this.formatLoggingString(s, valuesToBeReplacePlaceholders));
    }

    public void attachImage(File file, String imageName) {
        try {
            ((ExtentTest)this.test.get()).addScreenCaptureFromPath(file.getName());
        } catch (IOException var4) {
            this.warn("Exception occured {}", var4);
        }

    }

    public void attachHtml(File file) {
        ((ExtentTest)this.test.get()).info("<a href=\"" + file.getName() + "\" target=\"_blank\"><b>API Response</b></a><br>");
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
}
