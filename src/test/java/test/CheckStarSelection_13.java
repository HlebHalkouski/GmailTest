package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.Browser;
import webdriver.utils.Letter;

public class CheckStarSelection_13 extends BaseTest {

	private Letter staredLetter;
	private String username1;
	private String password1;

	@BeforeMethod
	@Parameters({ "username1", "password1" })
	public void beforeMainMailBoxPageTest(String username1, String password1) {
		info("Precondition: ");
		this.username1 = username1;
		this.password1 = password1;
		steps.loginGmail(username1, password1);

	}

	@Test(alwaysRun = true)
	public void CheckStarSelection() {

		step(1);
		staredLetter = steps.starredTopMessage();
		Assert.assertTrue(steps.isStarSelect(), "Star is select status", "Star don't have select status");

		step(2, 3);
		steps.goToStared();
		Assert.assertTrue(steps.isletterInInbox(staredLetter), "Letter in starred!", "Letter  isn't starred!");

	}
	
	@AfterMethod
	public void afterMainMailBoxPageTest(){
		info("Postcondition: ");
		Browser.getInstance().deleteAllCookiesAndRefresh();
		steps.loginGmail(username1, password1);
		steps.starredTopMessage();
	}
	
}
