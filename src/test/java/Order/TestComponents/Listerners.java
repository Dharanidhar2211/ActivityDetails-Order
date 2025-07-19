package Order.TestComponents;


import Order.DataComponents.ExtentReportTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;


public class Listerners extends BestTest implements ITestListener
{
    ExtentReports extent= ExtentReportTest.ExtentReportNG();
    public ExtentTest test;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
    @Override
    public void onTestStart(ITestResult result)
    {

        test= extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
    }


    @Override
    public void onTestFailure(ITestResult result)
    {
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extentTest.get().fail(result.getThrowable());
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        String FilePath= null;
        try {
            FilePath = getScreenShot(result.getMethod().getMethodName(),driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.get().addScreenCaptureFromPath(FilePath,result.getMethod().getMethodName());

    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public  void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public  void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    @Override
    public  void onStart(ITestContext context) {

    }
    @Override
    public  void onFinish(ITestContext context)
    {
        extent.flush();


    }

}
