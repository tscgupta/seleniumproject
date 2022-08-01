package com.internet.heroku.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.name("password");
    private By loginButtonLocator = By.tagName("button");
    private By errorMessageLocator = By.id("flash-messages");

    /** Execute log in */
    public SecureAreaPage login(String username, String password){
        log.info("Executing Login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    public void negativeLoginPage(String username, String password){
        log.info("Executing Login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(loginButtonLocator);
    }

    public void waitForErrorMessage(){
        waitForVisbilityOf(errorMessageLocator, Duration.ofSeconds(5));
    }

    public String getErrorMessageText(){
        return find(errorMessageLocator).getText();
    }
}
