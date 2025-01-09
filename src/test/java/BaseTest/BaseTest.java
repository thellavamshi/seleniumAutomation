package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    WebDriver driver;
    Properties properties;

    public BaseTest() throws IOException {
         properties = new Properties();
        FileInputStream fis = new FileInputStream("src/test/java/Resources/config.properties");
        properties.load(fis);
    }

    public void getBrowser(String browser){
        switch (browser.toLowerCase()){
            case("chrome"):
                driver = new ChromeDriver();
                break;
            case("firefox"):
                driver = new FirefoxDriver();
                break;
            case("explorer"):
                driver = new EdgeDriver();
                break;
        }
    }

    public String getBrowserName(){
        String browser = properties.getProperty("browser");
        return  browser;
    }

}
