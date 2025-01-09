package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement submit;

    public void launchUrl(){
        driver.get("https://www.saucedemo.com/");
    }

    public void login(){
        userName.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        submit.click();
        driver.manage().window().maximize();
        driver.findElement(By.className(".product_sort_container")).click();
        driver.findElement(By.cssSelector(".product_sort_container option[value='az']")).click();
    }
}
