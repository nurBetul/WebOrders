package com.weborders.tests;
import com.weborders.common.Driver;
import com.weborders.common.TestBase;
import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends TestBase {
    @Test
    public void verifyUserCanLoginWithCorretCredentials(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("Tester", "test");
        Assert.assertEquals( Driver.getDriver().getCurrentUrl(),
                "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/default.aspx");
    }

    @Test
    public void verifyUserCanNotLoginWithCorretCredentials(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("Tester", "test123");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Invalid Login or Password.");

    }
}
