package com.internet.heroku.alertstests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.internet.heroku.TestUtilities;
import com.internet.heroku.pages.JavaScriptAlertsPage;
import com.internet.heroku.pages.WelcomePageObject;

public class AlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest() {
        log.info("Starting jsAlert test");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        // Click on JS Alerts link
        JavaScriptAlertsPage alertsPage = welcomePageObject.clickJavaScriptAlertsPageLink();

        // Click JS Alert button
        alertsPage.openJSAlert();

        // Get alert Text
        String alertMessage = alertsPage.getAlertText();

        // Click OK button
        alertsPage.acceptAlert();

        //Get Results text
        String result = alertsPage.getResultText();

        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but received " + alertMessage);
        
        //2 - Result text is expected
        Assert.assertTrue(result.equals("You successfully clicked an alert"),
        "result is not expected. \nShould be 'You successfully clicked an alert', but recevied " + result);

    }

    @Test
    public void jsDismissTest(){
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        // Click on JS Alerts link
        JavaScriptAlertsPage alertsPage = welcomePageObject.clickJavaScriptAlertsPageLink();

        // Click JS Alert button
        alertsPage.openJSConfirm();

        // Get alert Text
        String alertMessage = alertsPage.getAlertText();

        // Click Cancel button
        alertsPage.dismissAlert();

        //Get Results text
        String result = alertsPage.getResultText();

       // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but received " + alertMessage);
        
        //2 - Result text is expected
        Assert.assertTrue(result.equals("You clicked: Cancel"),
        "result is not expected. \nShould be 'You  clicked: Cancel', but recevied " + result);
    }

    @Test
    public void jsPromptTest(){
        log.info("Starting jsPromptTest");

        // open main page
        WelcomePageObject welcomePageObject = new WelcomePageObject(driver, log);
        welcomePageObject.openPage();

        // Click on JS Alerts link
        JavaScriptAlertsPage alertsPage = welcomePageObject.clickJavaScriptAlertsPageLink();

        // Click JS Prompt button
        alertsPage.openJSPrompt();

        // Get alert Text
        String alertMessage = alertsPage.getAlertText();

        // Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's Satish here");

        //Get Results text
        String result = alertsPage.getResultText();

       // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but received " + alertMessage);
        
        //2 - Result text is expected
        Assert.assertTrue(result.equals("You entered: Hello Alert, it's Satish here"),
        "result is not expected. \nShould be 'Hello Alert, it's Satish here', but recevied " + result);

    }
}
