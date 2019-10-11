

package com.de.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Extent {
    public static ThreadLocal<ExtentTest> TEST = new ThreadLocal<ExtentTest>();
    public static ExtentReports REPORT = new ExtentReports();

    public Extent() {
    }
}
