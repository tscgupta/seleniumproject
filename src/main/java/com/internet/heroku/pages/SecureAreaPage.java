package com.internet.heroku.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/secure";
    private By logoutButton =  By.xpath("//a[@class='button secondary radius']");
    private By message = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** Get URL variable from Page Object */
    public String getPageUrl(){
        return pageUrl;
    }

    /** Verification if logoutButton is visible on page */
    public Boolean isLogoutButtonVisible(){
        return find(logoutButton).isDisplayed();

    }

    /** Return text from success message */
    public String getSuccessMessageText(){
        return find(message).getText();
    }

}
