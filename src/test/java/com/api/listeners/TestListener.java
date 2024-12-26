package com.api.listeners;

import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporting.ExtentReportManager;

public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test Started: {}", result.getName());
        ExtentReportManager.createTest(result.getName(), result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test Passed: {}", result.getName());
        ExtentReportManager.getTest().log(Status.PASS, "Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test Failed: {}", result.getName());
        logger.error("Exception: ", result.getThrowable());
        ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getName());
        ExtentReportManager.getTest().log(Status.FAIL, result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("Test Skipped: {}", result.getName());
        ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getName());
        ExtentReportManager.getTest().log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test Execution Started");
        ExtentReportManager.initReport("target/ExtentReport/report.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Test Execution Finished");
        ExtentReportManager.flushReport();
    }
}
