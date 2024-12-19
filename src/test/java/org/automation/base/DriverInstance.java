package org.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
    public WebDriver driver;
    @BeforeMethod
    public void initiateDriver() throws Exception{
        if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }else{
            System.out.println("Invalid browser name");
        }
        driver.get(Utility.fetchPropertyValue("applicationUrl").toString());
    }
    @AfterMethod
    public void closeDriverInstance(){
        driver.quit();
    }
}
