package com.weborders.pages;

import com.weborders.common.Driver;
import com.weborders.common.PageBase;
import com.weborders.utils.SeleniumUtil;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class DashboardPage extends PageBase {
    private By usersNameLocator = By.cssSelector(".login_info");
    private By logoutLinkLocator = By.id("ctl00_logout");
    private By firstCheckBoxLocator = By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector");
    private By deleteButtonLocator = By.id("ctl00_MainContent_btnDelete");
    private By tableRowLocator = By.xpath("//table[@id=\"ctl00_MainContent_orderGrid\"]//td/..");

    public String getUsersNameFromDashboard(){
        String text = Driver.getDriver().findElement(usersNameLocator).getText();
        return text;
    }

    public void logout(){
        seleniumUtil.click(logoutLinkLocator);
    }

    public void checkFirstCheckbox(){
        seleniumUtil.click(firstCheckBoxLocator);

    }

    public void clickDeleteButton(){
        seleniumUtil.click(deleteButtonLocator);
    }
    public int getNumberOfRowsOnTable(){
        return seleniumUtil.findElements(tableRowLocator).size();
    }

    public void deleteFirstRow(){
        checkFirstCheckbox();
        clickDeleteButton();
    }

    @Override
    public void waitForPageToLoad() {
    seleniumUtil.waitForVisibility(logoutLinkLocator);
    
    }
}
