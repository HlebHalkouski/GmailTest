package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.Browser;
import webdriver.utils.Letter;

public class MarkItemAsSpam_11 extends BaseTest {

	private Letter markedLetter;

	@BeforeMethod
	@Parameters({ "username1", "password1" })
	public void beforeMainMailBoxPageTest(String username1, String password1) {
		info("Precondition: ");
		steps.loginGmail(username1, password1);
	}

	@Test
	public void MarkItemAsSpamTest() {

		step(1, 2);
		markedLetter = steps.selectTopMessage();

		step(3);
		steps.markSelectedMessageAsSpam();
		Assert.assertTrue(steps.isLetterIsNotFolder(markedLetter), "Letter isn't in inbox", "Letter is in inbox");

		step(4);
		steps.goToSpam();

		step(5);
		steps.enterMessage(markedLetter);

		step(6);
		steps.markMessageIsNoSpam();
		Assert.assertTrue(steps.isLetterIsNotFolder(markedLetter), "Letter isn't in spam", "Letter is in spam");

		step(7, 8);
		browser.navigate(Browser.getBaseUrl());
		Assert.assertTrue(steps.isletterInInbox(markedLetter), "Letter in inbox!", "Letter  isn't inbox!");

	}

}
