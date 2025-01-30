package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {

    public static ExtentReports getReport(){
        String reportPath = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportPath);
        extentSparkReporter.config().setReportName("Automation results");
        extentSparkReporter.config().setDocumentTitle("Test Results");

        ExtentReports extentReports= new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        return extentReports;
    }
}
