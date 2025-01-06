package org.automation.testcases;
import org.automation.base.DriverInstance;
import org.automation.base.Generics;
import org.automation.base.WaitStatement;
import org.automation.datagenerators.DataGenerator3;
import org.automation.pages.LoginPage;

import org.automation.utility.Utility;
import org.testng.annotations.Test;


public class TC001_ValidateLogin extends DriverInstance {
    @Test(dataProvider="Excel4",dataProviderClass = DataGenerator3.class)
    public void validateLogin(String uname,String pwd) throws Exception{
        try{
            LoginPage lp = new LoginPage(driver);
            WaitStatement.threadWait(5000);
            //Compare.validatePageUrl(Utility.fetchCompareValue("expUrl"));
            //Compare.validatePageTitle(Utility.fetchCompareValue("expTitle"));
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