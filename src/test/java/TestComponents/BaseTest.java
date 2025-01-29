package TestComponents;

import AbstractComponents.AbstractComponent;
import Pages.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest{

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\globalData.properties");
        properties.load(fis);
        String browser = properties.getProperty("browser").toLowerCase();
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
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

    @BeforeTest
    public void launchApplication() throws IOException {
        driver = initializeDriver();
        LoginPage lp = new LoginPage(driver);
        lp.launchUrl();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


    public void getScreenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination =
                new File(System.getProperty("user.dir")+"//reports//"  + ".png");
        FileUtils.copyFile(source, destination);
    }

}
