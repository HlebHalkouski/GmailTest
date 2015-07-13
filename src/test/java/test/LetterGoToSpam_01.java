package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import test.Pages.LoginPage;
import webdriver.BaseTest;

public class LetterGoToSpam_01 extends BaseTest {

	@Test
	@Parameters({ "username1", "password1", "username2", "password2" })
	public void letterGoToSpam(String username1, String password1, String username2, String password2) {

		logger.step(1);
		step.loginGmail(username1, password1);
		step.sendMessageToUser(username2);

	}

}
