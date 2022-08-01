package com.internet.heroku.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internet.heroku.TestUtilities;
import com.internet.heroku.pages.CheckboxesPage;
import com.internet.heroku.pages.WelcomePageObject;

public class CheckboxesTest extends TestUtilities{

    @Test
    public void selectingTwoCheckboxesTest(){
        log.info("Starting selecting Two Checkboxes Test");

        //open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select all Checkboxes
        checkboxesPage.selectAllCheckboxes();

        //Verify if all checkboxes checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesChecked(), "Not all checkboxes checked");

    }
    
}
