package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    public static void initReport(String reportFilePath) {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);
            sparkReporter.config().setDocumentTitle("API Automation Test Report");
            sparkReporter.config().setReportName("Test Execution Results");
            sparkReporter.config().setTheme(Theme.DARK);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
            extent.setSystemInfo("User Name", System.getProperty("user.name"));
        }
    }

    public static ExtentTest createTest(String testName, String testDescription) {
        ExtentTest test = extent.createTest(testName, testDescription);
        testThread.set(test);
        return test;
    }

    public static ExtentTest getTest() {
        ExtentTest test = testThread.get();
        if (test == null) {
            throw new IllegalStateException("ExtentTest is not initialized. Ensure createTest() is called.");
        }
        return test;
    }
    public static void logInfo(String message) {
        ExtentTest test = testThread.get();
        if (test != null) {
            test.info(message);
        }
    }

    public static void logPass(String message) {
        ExtentTest test = testThread.get();
        if (test != null) {
            test.pass(message);
        }
    }

    public static void logFail(String message, Throwable throwable) {
        ExtentTest test = testThread.get();
        if (test != null) {
            test.fail(message);
            test.fail(throwable);
        }
    }

    public static void logSkip(String message) {
        ExtentTest test = testThread.get();
        if (test != null) {
            test.skip(message);
        }
    }

    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
