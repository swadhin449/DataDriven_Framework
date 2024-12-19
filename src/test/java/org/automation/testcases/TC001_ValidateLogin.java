package org.automation.testcases;


import org.automation.base.DriverInstance;
import org.automation.datagenerators.DataGenerator;
import org.automation.pages.LoginPage;

import org.testng.annotations.Test;


public class TC001_ValidateLogin extends DriverInstance {
    @Test(dataProvider="Excel",dataProviderClass = DataGenerator.class)
    public void validateLogin(String uname,String pwd) throws Exception{
        LoginPage lp = new LoginPage(driver);
        Thread.sleep(3000);
        lp.enterUserName(uname);
        Thread.sleep(2000);
        lp.enterPassword(pwd);
        Thread.sleep(2000);
        lp.clickLoginButton();
        Thread.sleep(2000);
    }
}
