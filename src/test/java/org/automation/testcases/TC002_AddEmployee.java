package org.automation.testcases;

import org.automation.base.DriverInstance;
import org.automation.base.WaitStatement;
import org.automation.datagenerators.DataGenerator;
import org.automation.pages.AddEmployee;
import org.automation.pages.LoginPage;
import org.testng.annotations.Test;

public class TC002_AddEmployee extends DriverInstance {
    @Test(dataProvider="dp",dataProviderClass = DataGenerator.class)
    public void tc002_AddEmployee(String uname, String pwd) throws Exception {
        AddEmployee addEmp = new AddEmployee(driver);
        LoginPage lp = new LoginPage(driver);
        WaitStatement.threadWait(3000);
        lp.enterUserName(uname);
        WaitStatement.threadWait(2000);
        lp.enterPassword(pwd);
        WaitStatement.threadWait(2000);
        lp.clickLoginButton();
        WaitStatement.threadWait(2000);
        addEmp.clickOnPIM();
        WaitStatement.threadWait(2000);
        addEmp.AddEmployeeOne();
        WaitStatement.threadWait(2000);
    }
}
