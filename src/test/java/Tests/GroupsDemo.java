package Tests;

import org.testng.annotations.Test;

public class GroupsDemo {

    @Test(groups = {"Regression", "Smoke"})
    public void login(){
        System.out.println("login success");
    }

    @Test(groups = {"Regression", "Smoke"})
    public void logout(){
        System.out.println("logout success");
    }

    @Test(groups = {"Smoke"})
    public void placeOrder(){
        System.out.println("Order Placed Successfully");
    }

    @Test(groups = {"Regression"})
    public void verifyTitle(){
        System.out.println("Verified Title");
    }

    @Test(groups={"Regression"})
    public void verifyUrl(){
        System.out.println("Verified URL");
    }
}
