package org.automation.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Generics {

        public WebDriver driver;
        public void clickOnWebElement(WebElement element, long time){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
            WebElement elements = null;
            elements = wait.until(ExpectedConditions.elementToBeClickable(element));
            elements.click();
        }
        public void sendKeysToField(WebElement ele,String text){
            ele.click();
            ele.clear();
            ele.sendKeys(text);
        }
        public void selectFromDropDown(WebElement ele,String value){
            Select st = new Select(ele);
            List<WebElement> allOptions = st.getOptions();
            for(WebElement option : allOptions){
                if(option.getText().equalsIgnoreCase(value)){
                    option.click();
                    break;
                }
            }
        }
        public void acceptAlert(){
            driver.switchTo().alert().accept();
        }
        public void dismissAlert(){
            driver.switchTo().alert().dismiss();
        }
        public void mouseOverAndClickElement(WebElement ele, WebDriver driver){
            Actions act = new Actions(driver);
            act.moveToElement(ele).click().perform();
        }
        public static void takeScreenShot(WebDriver driver, String screenShotName) throws IOException {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File trg = new File("./Screenshots/"+screenShotName+".png");
            FileUtils.copyFile(src,trg);
        }
}
