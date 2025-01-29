package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalougePage {

    WebDriver driver;

    public ProductCatalougePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name ']")
    List<WebElement> products;

    @FindBy(className = "shopping_cart_link")
    WebElement cartBtn;

    By product = By.xpath("//button[text()='Add to cart']");



    public void addProductToCart(){
        WebElement productName = products.stream().filter(product ->
                product.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"))
                        .getText().equals("Sauce Labs Bolt T-Shirt")).findFirst().orElse(null);

        productName.findElement(By.xpath("//button[text()='Add to cart']")).click();

    }

    public void clickCart(){
        cartBtn.click();
    }








}
