package Tests;

import Pages.LoginPage;
import Pages.ProductCatalougePage;
import TestComponents.BaseTest;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class GoToCartTest extends BaseTest {

    @BeforeTest
    public void launch() throws IOException {
        launchApplication();
    }

    @Test
    public void test(){
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user","secret_sauce");
        ProductCatalougePage pc = new ProductCatalougePage(driver);
        pc.clickCart();
    }


}
