package com.internet.heroku.editortest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.internet.heroku.TestUtilities;
import com.internet.heroku.pages.EditorPage;
import com.internet.heroku.pages.WelcomePageObject;

public class EditorTests extends TestUtilities{
	
	@Test
	public void defaultEditorValueTest() {
		
		log.info("Starting defaultEditorValueText");
		
		// open main page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.openPage();
		
		//Click on WYSIWYG Editor link
		EditorPage editorPage = welcomePage.clickWYSIWYGEditorLink();
		
		//Get defualt editor text
		String editorText = editorPage.getEditorText();
		
		//Verification that new page contains expected text in source
		Assert.assertTrue(editorText.equals("Your content goes here."),
				"Editor default text is not expected. It is: " + editorText);
	}

}
