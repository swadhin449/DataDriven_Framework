package org.automation.assertions;

import org.openqa.selenium.WebDriver;

public class Compare {
    public static WebDriver driver;
    public Compare(WebDriver driver) {
        this.driver=driver;
    }
    public static boolean validatePageUrl(String expUrl){
        boolean flag = false;
        if(driver.getCurrentUrl().equals(expUrl)){
            flag = true;
            System.out.println("The page url is: "+driver.getCurrentUrl());
        }
        return flag;
    }
    public static boolean validatePageTitle(String expTitle){
        boolean flag = false;
        if(driver.getTitle().equals(expTitle)){
            flag = true;
            System.out.println("The Page Title is: "+driver.getTitle());
        }
        return flag;
    }
}
