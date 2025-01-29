package Tests;

import Data.JsonDataReader;
import Pages.LoginPage;
import TestComponents.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends BaseTest {


    @Test(dataProvider ="TestData")
    public void loginTest(String email, String password){
        System.out.println("Launched Application");
        LoginPage lp = new LoginPage(driver);
        lp.login(email,password);
        lp.logout();
    }

    @DataProvider(name = "TestData")
    public Object[][] testData(){
        return  new Object[][] {
                {"standard_user","secret_sauce"},
                {"problem_user","secret_sauce"}

        };
    }

    @DataProvider
    public Object[][] hashMapData(){

        HashMap<Object, Object> map = new HashMap<Object, Object>();
        map.put("email","standard_user");
        map.put("password","secret_sauce");

        return new Object[][]{{map}};
    }

    @Test(dataProvider = "hashMapData")
    public void testHashMap(HashMap<Object, Object> input){
        System.out.println(input.get("email"));
        System.out.println(input.get("password"));

    }

    @Test(dataProvider="TestData")
    public void testDataProvider(String email, String password){
        System.out.println(email + "   "  + password);

    }


    @DataProvider(name="JsonToHashMap")
    public Object[][] getData() throws IOException {

        JsonDataReader jsonDataReader = new JsonDataReader();

        List<HashMap<String, String>> map= jsonDataReader.jsonToHashmap();

        return  new Object[][] {
                {map.get(0)},
                {map.get(1)}
        };
    }
}
