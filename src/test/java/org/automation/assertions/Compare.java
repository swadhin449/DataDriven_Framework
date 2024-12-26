package org.automation.assertions;

import org.openqa.selenium.WebDriver;

public class Compare {
    WebDriver driver;
    public Compare(WebDriver driver) {
        this.driver=driver;
    }
    public boolean validatePageUrl(String expUrl){
        boolean flag = false;
        if(driver.getCurrentUrl().equals(expUrl)){
            flag = true;
            System.out.println("The page url is: "+driver.getCurrentUrl());
        }
        return flag;
    }
    public boolean validatePageTitle(String expTitle){
        boolean flag = false;
        if(driver.getTitle().equals(expTitle)){
            flag = true;
            System.out.println("The Page Title is: "+driver.getTitle());
        }
        return flag;
    }
}
