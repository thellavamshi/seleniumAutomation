package Tests;

import Pages.LoginPage;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestReporter_Listeners extends BaseTest {

    @Test(dataProvider = "testData", retryAnalyzer = Retry.class)
    public void checkLogin(String email, String password){
        LoginPage lp = new LoginPage(driver);
        lp.login(email,password);
        lp.logout();
    }

    @DataProvider(name="testData")
    public Object[][] dataProvider(){
        return new Object[][] {
                {"standard_user","secret_sauce"},
                {"locked_out_user","secret_sauce"},
                {"problem_user","secret_sauce"}
        };
    }



}
