package test.Steps;

import test.Pages.LoginPage;
import test.Pages.MainPage;
import test.Pages.NewMessageForm;
import webdriver.BaseEntity;

public class Steps extends BaseEntity {

	public void loginGmail(String username, String password) {
		LoginPage loginPage = new LoginPage();
		loginPage.loginGmail(username, password);
	}

	/**
	 * Send message to user.
	 *
	 * @param username email username addressee
	 */
	public void sendMessageToUser(String username) {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();
		NewMessageForm newMessageForm = new NewMessageForm();
		newMessageForm.sendMessageToUser(username);
	}


	
}
