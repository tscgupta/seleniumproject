package com.internet.heroku.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage extends BasePageObject{

    private By clickForJSAlertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
    private By clickForJSConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
    private By clickForJSPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultTextLocator = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Clicking on JS Alert button to get alert */
    public void openJSAlert(){
        log.info("Clicking on 'Click for JS 'alert' button to open alert");
        click(clickForJSAlertButtonLocator);

    }

    /** Clicking on JS Alert button to get alert */
    public void openJSConfirm(){
        log.info("Clicking on 'Click for JS confirm' button to open alert");
        click(clickForJSConfirmButtonLocator);

    }

    /** Clicking on JS Prompt button to get alert */
    public void openJSPrompt(){
        log.info("Clicking on 'Click for JS Prompt' button to open alert");
        click(clickForJSPromptButtonLocator);

    }
    
    /** Switch to alert and get it's message */
    public String getAlertText(){
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText ;
    }

    /** Switch to alert and press ok */
    public void acceptAlert(){
        log.info("Switching to alert and pressing ok");
        Alert alert = switchToAlert();
        alert.accept();
    }

    /** Switch to alert and press cancel */
    public void dismissAlert(){
        log.info("Switching to alert and pressing cancel");
        Alert alert = switchToAlert();
        alert.dismiss();
    }

    /** Type text into alert and press ok */
    public void typeTextIntoAlert(String text){
        log.info("Typing text into alert and pressing ok");
        Alert alert = switchToAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    /** Get result text */
    public String getResultText(){
        String result = find(resultTextLocator).getText();
        log.info("Result text: " + result);
        return result;
    }


    
}
