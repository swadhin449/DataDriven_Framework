package org.automation.testcases;


import org.automation.assertions.Compare;
import org.automation.base.DriverInstance;
import org.automation.base.Generics;
import org.automation.base.WaitStatement;
import org.automation.datagenerators.DataGenerator;
import org.automation.pages.LoginPage;

import org.automation.utility.Utility;
import org.testng.annotations.Test;


public class TC001_ValidateLogin extends DriverInstance {
    @Test(dataProvider="dp",dataProviderClass = DataGenerator.class)
    public void validateLogin(String uname,String pwd) throws Exception{
        try{
            LoginPage lp = new LoginPage(driver);
            Compare cp = new Compare(driver);
            cp.validatePageUrl(Utility.fetchCompareValue("expUrl"));
            cp.validatePageTitle(Utility.fetchCompareValue("expTitle"));
            WaitStatement.threadWait(2000);
            lp.enterUserName(uname);
            WaitStatement.threadWait(2000);
            lp.enterPassword(pwd);
            WaitStatement.threadWait(3000);
            lp.clickLoginButton();
            WaitStatement.threadWait(2000);
        }catch (Exception e){
            Generics.takeScreenShot(driver,"ValidateLogin");
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }
}