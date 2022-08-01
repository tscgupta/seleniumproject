package com.internet.heroku.dropdowntests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internet.heroku.TestUtilities;
import com.internet.heroku.pages.DropdownPage;
import com.internet.heroku.pages.WelcomePageObject;

public class DropdownTest extends TestUtilities {

    @Test
    public void optionTwoTest(){
        log.info("Starting option two test");

        //Open Welcome page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        //Click on Dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownPageLink();

        //Select option 2
        dropdownPage.selectOption(2);

        //Verify Option 2 is selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"),
                            "Option2 is not selected. Instead selected - " + selectedOption);
    }
    
}
