package test;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.utils.Letter;

public class LetterGoToSpam_01 extends BaseTest {

	private Cookie cookieUser1;
	private Cookie cookieUser2;
	private Letter messageUser1;
	
	
	@Test
	@Parameters({ "username1", "password1", "username2", "password2" })
	public void letterGoToSpam(String username1, String password1, String username2, String password2) {

		step(1);
		steps.loginGmail(username1, password1);
		
		step(2);
		messageUser1 = steps.sendMessageToUser(username1, username2);
		
		cookieUser1 = browser.getSessionCookie();
		browser.deleteAllCookiesAndRefresh();
		
		step(3);
		steps.loginGmail(username2, password2);
		
		step(4);
		steps.markLetterAsSpam(username1, messageUser1);
		
		cookieUser2 = browser.getSessionCookie();
		browser.deleteAllCookiesAndRefresh();
		browser.addCookieAndRefresh(cookieUser1);
		
		step(5);
		messageUser1 = steps.sendMessageToUser(username1, username2);
		
		browser.deleteAllCookiesAndRefresh();
		browser.addCookieAndRefresh(cookieUser2);
		
		step(6);
		steps.goToSpam();
		steps.assertLetterInSpam(username1, messageUser1);
		//Вывести асерт на уровень выше?
		
	}

}
