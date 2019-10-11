package com.de.reporting.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.de.reporting.Extent;
import org.testng.IInvokedMethod;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class ExtentListener implements Listener {
    private final ThreadLocal<ExtentTest> test;
    private final ExtentReports extent;

    public ExtentListener() {
        this.test = Extent.TEST;
        this.extent = Extent.REPORT;
    }

    public void onTestSuccess(ITestResult result) {
        ((ExtentTest)this.test.get()).pass("Passed");
        this.extent.flush();
    }

    public void onTestFailure(ITestResult result) {
        ((ExtentTest)this.test.get()).fail(result.getThrowable());
        this.extent.flush();
    }

    public void onTestSkipped(ITestResult result) {
        ((ExtentTest)this.test.get()).skip(result.getThrowable());
        this.extent.flush();
    }

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
    }

    public void onConfigurationSuccess(ITestResult itr) {
    }

    public void onConfigurationFailure(ITestResult itr) {
    }

    public void onConfigurationSkip(ITestResult itr) {
    }

    public void onExecutionStart() {
    }

    public void onExecutionFinish() {
    }

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    }

    public boolean retry(ITestResult result) {
        return false;
    }

    public void onStart(ISuite suite) {
    }

    public void onFinish(ISuite suite) {
    }

    public void onTestStart(ITestResult result) {
        this.test.set(this.extent.createTest(result.getName()));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
    }

    public void onFinish(ITestContext context) {
    }
}
