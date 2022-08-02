package com.internet.heroku.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

     /** open page with given url */
    protected void openUrl(String url){
        driver.get(url);
    }

    /** Find element using given locator */
    protected WebElement find(By locator){
       return driver.findElement(locator);
        
    }

    /** Find all elements using given locator */
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    /** Click on element with given locator when it's visible */
    protected void click(By locator){
        waitForVisbilityOf(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    /** Type given text into element with given locator */
    protected void type(String text, By locator){
        waitForVisbilityOf(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    /** Get URL of current page of browser*/
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    /** Get title of current page */
    public String getCurrentPageTitle(){
        return driver.getTitle();
    }

    /** Get source of current Page */
    public String getCurrentPageSource(){
        return driver.getPageSource();
    }

    /** Wait for specific ExpectedCondition for given amount of time */
    private void waitFor(ExpectedCondition<WebElement> condition, Duration timeOut){
        timeOut =  timeOut !=null ? timeOut : Duration.ofSeconds(30);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.until(condition);

    }

    /** Wait for the given no of seconds for element with givien locator and  to be visible
     * on the page
    */
    protected void waitForVisbilityOf(By locator, Duration...timeOut) {
        int attempts = 0;
        while (attempts < 2){
            try {
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                (timeOut.length > 0 ? timeOut[0] : null));
                break;
            } catch (StaleElementReferenceException e) {      
            }
            attempts++;
            
        }
    }

    /** Wait for alert present and switch to it */
    protected Alert switchToAlert(){
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public void switchToWindowWithTitle(String expectedTitle){
        //Switching to new window
        String firstWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while(windowsIterator.hasNext()){
            String windowHandle = windowsIterator.next().toString();
            if(!windowHandle.equals(firstWindow)){
                driver.switchTo().window(windowHandle);
                if(getCurrentPageTitle().equals(expectedTitle)){
                    break;
                }
            }

        }
    }

}
