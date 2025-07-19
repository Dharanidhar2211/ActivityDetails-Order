package Order.DataComponents;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public  class ExtentReportTest
{
    public static ExtentReports ExtentReportNG()
    {
        File filepath= new File(System.getProperty("user.dir") + "\\Reports\\ExtentReport.html");
        ExtentSparkReporter reporter=new ExtentSparkReporter(filepath);
        reporter.config().setDocumentTitle("Automation Test Report");
        reporter.config().setReportName("ActivityDetails-Order");
        ExtentReports extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Name","Dharanidhar");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("Build","Version 138.0.7204.158 (Official Build) (64-bit)");
        extent.setSystemInfo("Browser","Chrome");
        extent.setSystemInfo("OS","Windows 10");
        extent.setSystemInfo("Java Version","1.8");

        return extent;


    }

}
