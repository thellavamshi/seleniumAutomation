package Tests;

import Pages.LoginPage;
import TestComponents.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportTest{

    ExtentReports extentReports;

    @BeforeTest
    public void configReporter(){
        String reportsPath=System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(reportsPath);
        extentSparkReporter.config().setReportName("Automation Report");
        extentSparkReporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("Tester", "Vamshi Thella");

    }

    @Test
    public void test(){

        extentReports.createTest("Demo Test");
        String a = "Abcdef12345@#$%";
        String b = a.replaceAll("[^a-zA-Z0-9]","");
        System.out.println("Before String : " + a);
        System.out.println("After String: " + b);

    }

    @AfterTest
    public void tearDown(){
        extentReports.flush();
    }
}
