package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.utils.Letter;

public class CheckStarSelection_13 extends BaseTest {

	private Letter staredLetter;

	@BeforeMethod
	@Parameters({ "username1", "password1" })
	public void beforeMainMailBoxPageTest(String username1, String password1) {
		info("Precondition: ");
		steps.loginGmail(username1, password1);

	}

	@Test
	public void CheckStarSelection() {

		step(1);
		staredLetter = steps.starredTopMessage();
		Assert.assertTrue(steps.isStarSelect(), "Star is select status", "Star don't have select status");

		step(2, 3);
		steps.goToStared();
		Assert.assertTrue(steps.isletterInInbox(staredLetter), "Letter in starred!", "Letter  isn't starred!");

	}
}
