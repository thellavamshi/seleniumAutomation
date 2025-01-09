package Tests;

import BaseTest.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login extends BaseTest {

    WebDriver driver;


    @BeforeClass
    public void setUpDriver(){
        getBrowser(getBrowserName());
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
