package ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;

import static Pages.PlayWrightFactory.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;

public class ExtentTestNGListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    private static final String REPORT_DIR = "test-output/reports/";
    private static final String REPORT_NAME = "ExtentReport.html";

    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(REPORT_DIR + REPORT_NAME);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Environment", "Web");
        extent.setSystemInfo("Author", "Youssef Sewalm");
        extent.setSystemInfo("Website", "AutomationExercise");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build());
        extentTest.get().getModel().setEndTime(getTime(result.getEndMillis()));       
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build());
        extentTest.get().getModel().setEndTime(getTime(result.getEndMillis())); 
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped");
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        extentTest.get().info("Test failed but is within success percentage: " + result.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }
    public static String captureScreenshot(){
      
    	String path = System.getProperty("user.dir")+"/screenshot/"+System.currentTimeMillis()+".png";
    	
    	page.screenshot(new Page.ScreenshotOptions()
    			.setPath(Paths.get(path))
    			.setFullPage(true));
    	return path; 	
    }
    public static Date getTime(long millis)
    {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTimeInMillis(millis);
    	return calendar.getTime();
    }

}
