package com.internet.heroku.windowstests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internet.heroku.TestUtilities;
import com.internet.heroku.pages.MultipleWindowsPage;
import com.internet.heroku.pages.NewWindowPage;
import com.internet.heroku.pages.WelcomePageObject;

public class WindowsTests extends TestUtilities {

    @Test
    public void newWindowTest(){
        log.info("Starting newWindowTest");

        //open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //Click on MutipleWindows link
        MultipleWindowsPage windowsPage = welcomePageObject.clickMultipleWindowsPageLink();

        // Click 'Click Here' link to open new window
        windowsPage.openNewWindow();

        //Find and switch to new window page
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();

        //Verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"), "New page source does not exist but received " + pageSource);

    }
    
}
