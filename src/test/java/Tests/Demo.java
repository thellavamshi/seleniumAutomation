package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo {

    WebDriver driver;

    @BeforeClass
    public void setUpDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void login(){
        LoginPage lp = new LoginPage(driver);
        lp.launchUrl();
        lp.login();
    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
