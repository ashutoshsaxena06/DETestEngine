
package com.de.listener.decorator;

import org.testng.Reporter;

import java.io.File;

public class ReportNGReport implements Report {
    public ReportNGReport() {
    }

    public void step(String s, Object... valuesToBeReplacePlaceholders) {
        Reporter.log("<b><br><font color=\"blue\">STEP:</font> " + this.formatLoggingString(s, valuesToBeReplacePlaceholders), true);
    }

    public void info(String s, Object... valuesToBeReplacePlaceholders) {
        Reporter.log("<br><font color=\"banana yellow\">INFO:</font> " + this.formatLoggingString(s, valuesToBeReplacePlaceholders), true);
    }

    public void warn(String s, Object... valuesToBeReplacePlaceholders) {
        Reporter.log("<br><font color=\"orange\">WARN:</font> " + this.formatLoggingString(s, valuesToBeReplacePlaceholders), true);
    }

    public void error(String s, Object... valuesToBeReplacePlaceholders) {
        Reporter.log("<br><font color=\"red\">ERROR:</font> " + this.formatLoggingString(s, valuesToBeReplacePlaceholders), true);
    }

    public void attachHtml(File file) {
        Reporter.log("<br><a href=\"" + file.getName() + "\" target=\"_blank\"><b>API Response: </b></a>");
    }

    public void attachImage(File file, String imageName) {
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
