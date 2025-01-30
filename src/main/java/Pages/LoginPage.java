package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponent {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="user-name")
    WebElement userName;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="login-button")
    WebElement submit;

    @FindBy(css = ".bm-burger-button")
    WebElement hamBurgerMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;

    By lg = By.xpath("//a[text()='Logout']");

    public void launchUrl(){
        maximizeWindow();
        driver.get("https://www.saucedemo.com/");
    }




    public void login(String email, String pswd){
        userName.sendKeys(email);
        password.sendKeys(pswd);
        submit.click();
    }

    public void logout(){
        hamBurgerMenu.click();
        waitElementToAppear(lg);
        logout.click();


    }
}
