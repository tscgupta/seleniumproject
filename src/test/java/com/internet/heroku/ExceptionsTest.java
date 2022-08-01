package com.internet.heroku;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class ExceptionsTest extends TestUtilities{
    
    @Test(priority = 1)
    public void notVisibleTest() {

        // Open the page http://the-internet.herokuapp.com/dynamic_loading/1
        String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);

        // Find Locator for start button and click it
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        // Get Finish element
        WebElement finishElement = driver.findElement(By.id("finish"));

        // Add Explicit wait time for text to be visible after clicking on start
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(finishElement));

        String actualText = finishElement.getText();

        // compare actual finish element text with "Hello World!" using TestNg Asser
        // class
        Assert.assertTrue(actualText.contains("Hello World!"), "Finish text: " + actualText);

    }

    @Test(priority = 2)
    public void timeoutTest() {

        // Open the page http://the-internet.herokuapp.com/dynamic_loading/1
        String url = "http://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);

        // Find Locator for start button and click it
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        // Get Finish element
        WebElement finishElement = driver.findElement(By.id("finish"));

        // Add Explicit wait time for text to be visible after clicking on start
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        try {
            wait.until(ExpectedConditions.visibilityOf(finishElement));
        } catch (TimeoutException exception) {
            System.out.println("Expection caught: " + exception.getMessage());
            sleep(3000);
        }

        String actualText = finishElement.getText();

        // compare actual finish element text with "Hello World!" using TestNg Asser
        // class
        Assert.assertTrue(actualText.contains("Hello World!"), "Finish text: " + actualText);

    }

    @Test(priority = 3)
    public void noSuchElementTest() {

        // Open the page http://the-internet.herokuapp.com/dynamic_loading/1
        String url = "http://the-internet.herokuapp.com/dynamic_loading/2";
        driver.get(url);

        // Find Locator for start button and click it
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']/button"));
        startButton.click();

        // Add Explicit wait time for text to be visible after clicking on start
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertTrue(
                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("finish"), "Hello World!")),
                "Couldn't verify message Hello World!");

        // WebElement finishElement =
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));
        // //Get Finish element
        // String actualText = finishElement.getText();

        // //compare actual finish element text with "Hello World!" using TestNg Asser
        // class
        // Assert.assertTrue(actualText.contains("Hello World!"), "Finish text: " +
        // actualText);

    }

    @Test
    public void staleElementTest() {

        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBox = driver.findElement(By.id("checkbox"));
        WebElement removeButton = driver.findElement(By.xpath("//button[contains(text(), 'Remove')]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        removeButton.click();
        // wait.until(ExpectedConditions.invisibilityOf(checkBox));
        // Assert.assertFalse(checkBox.isDisplayed());
        // Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkBox)),
        // "Checkbox is still visible, but shouldn't be");

        Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkBox)),
                "Checkbox is still visible, but shouldn't be");
        
        WebElement addButton = driver.findElement(By.xpath("//button[contains(text(), 'Add')]"));
        addButton.click();

        checkBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
        Assert.assertTrue(checkBox.isDisplayed(), "Checkbox isn't visible, but it should be");

    }

    @Test
    public void disableElementTest(){

        System.out.println("disable Element test started");
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WebElement buttonEnable = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
        WebElement textElement = driver.findElement(By.xpath("(//input)[2]"));
        buttonEnable.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(textElement));

        textElement.sendKeys("Hi User");
        Assert.assertEquals(textElement.getAttribute("value"), "Hi User");
    }
}
