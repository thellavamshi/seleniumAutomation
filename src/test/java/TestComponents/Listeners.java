package TestComponents;

import Resources.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {

    ExtentReports extentReports = ExtentReporter.getReport();
    ExtentTest test;

    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result){
        //gets the method name
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result){
        test.log(Status.PASS, "pass");
    }

    @Override
    public void onTestFailure(ITestResult result){
        //Exception will be included in the report
        extentTestThreadLocal.get().fail(result.getThrowable());
        //Capture ScreenShot when test fails

        try{
            driver = (WebDriver)
                            result.getTestClass().
                            getRealClass().
                            getField("driver").
                            get(result.getInstance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String filePath=null;
        try {
           filePath = getScreenShot(result.getMethod().getMethodName(), driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.fail("Screenshot Attached", MediaEntityBuilder.createScreenCaptureFromPath(filePath).build());
        //test.addScreenCaptureFromPath(filePath,result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext result){
        extentReports.flush();
    }

}
