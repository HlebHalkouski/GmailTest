package test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.Browser;
import webdriver.utils.Letter;

public class LetterGoToSpam_01 extends BaseTest {

	private Letter messageUser1;
	private String username1;
	private String username2;
	private String password1;
	private String password2;
	
	@BeforeMethod
	@Parameters({ "username1", "password1", "username2", "password2" })
	public void beforeSpamTest(String username1, String password1, String username2, String password2){
		this.username1 = username1;
		this.username2 = username2;
		this.password1 = password1;
		this.password2 = password2;
	}
	
	//Для работоспособности теста нужно чтобы у user2 в спаме находилось 4 письма от user1
	@Test
	public void letterGoToSpamTest() {

		step(1);
		steps.loginGmail(username1, password1);
		
		step(2);
		messageUser1 = steps.sendMessageToUser(username1, username2);
		
		browser.deleteAllCookiesAndRefresh();
		
		step(3);
		steps.loginGmail(username2, password2);
		
		step(4);
		steps.markLetterAsSpam(messageUser1);
		
		browser.deleteAllCookiesAndRefresh();
		
		step(5);
		steps.loginGmail(username1, password1);
		
		step(6);
		messageUser1 = steps.sendMessageToUser(messageUser1, username2);
		
		browser.deleteAllCookiesAndRefresh();
		
		step(7);
		steps.loginGmail(username2, password2);
		
		step(8);
		steps.goToSpam();
		Assert.assertTrue(steps.isLetterInSpam(messageUser1),"Letter in Spam!", "Letter doesn't in spam!");
		
	}
	
	@AfterMethod
	public void afterSpamTest(){
		info("========== Postcondition========== ");
		Browser.getInstance().deleteAllCookiesAndRefresh();
		steps.loginGmail(username2, password2);
		steps.goToSpam();
		steps.returnMessageFromSpam(messageUser1);
	}

}
