package com.internet.heroku;


import org.testng.Assert;
import org.testng.annotations.*;
import com.internet.heroku.pages.LoginPage;
import com.internet.heroku.pages.*;

/**
 * Unit test for simple App.
 */
public class LoginTest extends TestUtilities
{   
   
    @Test(priority = 1, groups = { "positiveTest", "smokeTest" })
    public void positiveLoginTest()
    {
        log.info("Starting login test");

        //open welcome page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //Click on Form Authentication Link
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();        

        //Execute login
        SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");

        //verifications:
        //New Page  url is expectd
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl(), "Actual page url is not the same as expected");


        //logout button is visible
        Assert.assertTrue(secureAreaPage.isLogoutButtonVisible(), "Log Out button is not visible");

        //successful login page
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        //Assert.assertEquals(actualMessage, expectedMessage, "Actual message is not the same as expected");
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), 
                        "Actual message doesn't contain expected message. \nActualMessage: " + actualSuccessMessage 
                        + "\nExpected: " + expectedSuccessMessage);
    }

    @Test(priority = 2, groups = { "negativeTest", "smokeTest" })
    public void negativeLoginTest(){

        //open welcome page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        //Click on Form Authentication Link
        LoginPage loginPage = welcomePageObject.clickFormAuthenticationLink();  

         //Execute negative login
         loginPage.negativeLoginPage("tomsmit", "SuperSecretPassword!");

        
        //Wait for Error Message
        loginPage.waitForErrorMessage();
        
        //Verifications
        String expectedSuccessMessage = "Your username is invalid!";
        String actualSuccessMessage = loginPage.getErrorMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage), "Actual Message is not equals to expected message " + actualSuccessMessage + "instead of " + expectedSuccessMessage);
    }

}
