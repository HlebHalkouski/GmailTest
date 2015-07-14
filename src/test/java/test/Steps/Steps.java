package test.Steps;

import org.testng.Assert;

import test.Pages.LoginPage;
import test.Pages.MainPage;
import test.Pages.MessagePage;
import test.Pages.NewMessageForm;
import test.Pages.SpamPage;
import webdriver.BaseEntity;
import webdriver.utils.Letter;

public class Steps extends BaseEntity {

	private static final String MAIL_SPAM = "https://mail.google.com/mail/u/0/#spam";

	protected String formatLogMsg(final String message) {
		return message;
	}

	public void loginGmail(String username, String password) {
		browser.navigate(LoginPage.getUrlPage());
		LoginPage loginPage = new LoginPage();
		loginPage.loginGmail(username, password);
	}

	/**
	 * Send message to user.
	 *
	 * @param username1 the sender email
	 * @param username2 the adresser email
	 * @return the message
	 */
	public Letter sendMessageToUser(String username1, String username2) {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();
		NewMessageForm newMessageForm = new NewMessageForm();
		return newMessageForm.sendMessageToUser(username1, username2);

	}

	
	public void markLetterAsSpam(String username, Letter letterUser) {
		MainPage mainPage = new MainPage();
		mainPage.enterUserMessage(username, letterUser);
		MessagePage messagePage = new MessagePage();
		messagePage.markMessageAsSpam();
		
	}

	public void assertLetterInSpam(String username, Letter letterUser) {
		SpamPage spamPage = new SpamPage();
		Assert.assertTrue(spamPage.isLetterInSpam(username, letterUser), "Letter doesn't in spam!");
	}

	public void goToSpam() {
		browser.navigate(MAIL_SPAM);		
	}
	
}
