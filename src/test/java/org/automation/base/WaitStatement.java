package org.automation.base;

import org.openqa.selenium.WebDriver;

public class WaitStatement {
    WebDriver driver;
    public WaitStatement(WebDriver driver){
        this.driver = driver;
    }

    public static void threadWait(int time) throws InterruptedException {
        Thread.sleep(time);
    }

/*    public static void explicitWait(WebDriver driver, int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocatorValue(""))));
        driver.findElement(By.xpath(Utility.fetchLocatorValue(""))).click();
    }*/
}
