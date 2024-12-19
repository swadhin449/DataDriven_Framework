package org.automation.pages;

import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUserName(String uname) throws Exception{
        driver.findElement(By.name(Utility.fetchLocatorValue("login_username_name"))).sendKeys(uname);
    }
    public void enterPassword(String pwd) throws Exception{
        driver.findElement(By.name(Utility.fetchLocatorValue("login_password_name"))).sendKeys(pwd);
    }
    public void clickLoginButton() throws Exception{
        driver.findElement(By.id(Utility.fetchLocatorValue("login_logbtn_id"))).click();
    }
}
