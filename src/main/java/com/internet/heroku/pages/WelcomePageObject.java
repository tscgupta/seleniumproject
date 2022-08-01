package com.internet.heroku.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");

    public WelcomePageObject(WebDriver driver, Logger log) {
        super(driver, log);
    }

    /** open WelcomePage with it's url */
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    /** Open LoginPage by clicking on Form Authentication Link */
    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking Form Authentication on welcome page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    /** Open CheckboxesPage by clicking on checkboxes link */
    public CheckboxesPage clickCheckboxesLink(){
        log.info("Cllcking Checkboxes on welcome page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    /** Open DropdownPage by clicking on dropdown link */
    public DropdownPage clickDropdownPageLink(){
        log.info("Clicking Dropdown on welcome page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }
}
