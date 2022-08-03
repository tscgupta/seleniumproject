package com.internet.heroku.keypressestests;

import com.internet.heroku.TestUtilities;
import com.internet.heroku.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {

    @Test
    public  void pressKeyTest(){
        log.info("Starting pressKeyTest");

        //open KeyPresses Page
        KeyPressesPage  keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openPage();

        //Press Keyboard key
        keyPressesPage.pressKey(Keys.ENTER);

        //Get Results text
        String result = keyPressesPage.getResultText();

        //Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You entered: Enter' but received " + result);

    }

    @Test
    public  void pressKeyWithActionsTest(){
        log.info("Starting pressKeyWithActionsTest");

        //open KeyPresses Page
        KeyPressesPage  keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openPage();

        //Press Keyboard key
        keyPressesPage.pressKeyWithActions(Keys.SPACE);

        //Get Results text
        String result = keyPressesPage.getResultText();

        //Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: ENTER' but received " + result);

    }
}
