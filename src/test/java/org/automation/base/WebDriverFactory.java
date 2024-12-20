package org.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverFactory {
    public Map<String , Supplier<WebDriver>> driverMap = null;
    public WebDriverFactory() {
        driverMap = new HashMap<>();
        driverMap.put("chrome",this::createChromeDriver);
        driverMap.put("firefox",this::createFirefoxDriver);
        driverMap.put("edge",this::createEdgeDriver);
    }
    public WebDriver getDriver(String browserName){
        return driverMap.getOrDefault(browserName.toLowerCase().trim(), () -> {
            System.out.println("Browser Not Found: " + browserName);
            return null;
        }).get();
    }
    public WebDriver createChromeDriver(){
        return new ChromeDriver();
    }
    public WebDriver createFirefoxDriver(){
        return new FirefoxDriver();
    }
    public WebDriver createEdgeDriver(){
        return new EdgeDriver();
    }


    private WebDriver driver;
    public void setUp(){
        WebDriverFactory factory = new WebDriverFactory();
        driver=factory.getDriver("chrome");
    }
}

