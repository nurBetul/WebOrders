package com.weborders.pages;

import com.weborders.common.Driver;
import com.weborders.common.PageBase;
import com.weborders.utils.SeleniumUtil;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginPage extends PageBase {
    private String goToPageUrl = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx";
    private By userNameLocator = By.id("ctl00_MainContent_username");
    private By passwordLocator = By.id("ctl00_MainContent_password");
    private By loginButtonLocator = By.id("ctl00_MainContent_login_button");
    private By errorMessageTextLocator = By.id("ctl00_MainContent_status");


    public void goToPage(){
        Driver.getDriver().get(goToPageUrl);
    }
    public void enterUserName(String username){
        seleniumUtil.sendKeys(userNameLocator, username);
    }
    public void enterPassword(String password){
        seleniumUtil.sendKeys(passwordLocator, password);
    }
    public void clickLoginButton(){
        seleniumUtil.click(loginButtonLocator);
    }

    public String getErrorMessageText(){
        return seleniumUtil.getText(errorMessageTextLocator);
    }
    public void login(String username, String password){
        goToPage();
        enterUserName(username);
        enterPassword(password);
        clickLoginButton();

    }
    public boolean isLoginButtonDisplayed(){
        return seleniumUtil.isDisplayed(loginButtonLocator);
    }

    @Override
    public void waitForPageToLoad() {
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
