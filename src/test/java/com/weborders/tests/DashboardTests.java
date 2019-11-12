package com.weborders.tests;

import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTests extends TestBase {
    @Test
    public void verifyUsernameDashboardMatches(){
      //  LoginPage loginPage = new LoginPage();
        new LoginPage().login("Tester", "test");
       // DashboardPage dashBoardPage = new DashboardPage();
        String userNameOnDashboard = new DashboardPage().getUsersNameFromDashboard();
        Assert.assertTrue(userNameOnDashboard.contains("Tester"));

    }

    @Test
    public void verifyUserCanLogout(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("Tester", "test");
        new DashboardPage().logout();
        Assert.assertTrue(loginPage.isLoginButtonDisplayed());

    }

    @Test
    public void verifyDeleteRowFunctionality() throws InterruptedException {
        new LoginPage().login("Tester", "test");
        DashboardPage dashboardPage = new DashboardPage();
        int initialNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
        dashboardPage.deleteFirstRow();
        int finalNumberOfRows = dashboardPage.getNumberOfRowsOnTable();
        Thread.sleep(2000);
        System.out.println("initial number of rows: " + initialNumberOfRows);
        System.out.println("final number of rows: " + finalNumberOfRows);
        Assert.assertEquals(finalNumberOfRows, initialNumberOfRows-1);

    }

}
