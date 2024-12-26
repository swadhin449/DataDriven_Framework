package org.automation.pages;

import org.automation.base.Generics;
import org.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class AddEmployee  {
    public WebDriver driver;
    Generics gr = new Generics();
    public AddEmployee(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnPIM() throws IOException {
        WebElement ele = driver.findElement(By.xpath(Utility.fetchLocatorValue("pim_xpath")));
        gr.mouseOverAndClickElement(ele,driver);
    }
    public void AddEmployeeOne() throws IOException {
        driver.findElement(By.xpath(Utility.fetchLocatorValue("add_employee_xpath"))).click();
    }
}
