package TestComponents;

import Pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public abstract class BaseTest{

    public WebDriver driver;
    ExtentReports extentReports;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\globalData.properties");
        properties.load(fis);

        String browser =
                System.getProperty("browser")!=null ?
                System.getProperty("browser").toLowerCase() :
                properties.getProperty("browser").toLowerCase();


        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-infobars");
                options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
                options.setExperimentalOption("useAutomationExtension", false);
                driver = new ChromeDriver(options);
                break;
            case "firefox" :
                driver = new FirefoxDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Please set the driver correctly");
        }
//        if(browser.equalsIgnoreCase("chrome")){
//             driver = new ChromeDriver();
//        }else {
//             driver = new FirefoxDriver();
//        }
        return driver;
    }

    @BeforeMethod
    public void launchApplication() throws IOException {

        String reportPath = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Automation Report");
        reporter.config().setDocumentTitle("Automation Document");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester","Vamshi Thella");



        driver = initializeDriver();
        LoginPage lp = new LoginPage(driver);
        lp.launchUrl();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination =
                new File(System.getProperty("user.dir")+"//screenshots//"+testCaseName+".png");
        FileUtils.copyFile(source, destination);
        return System.getProperty("user.dir")+"//screenshots//"+testCaseName+".png";
    }


}
