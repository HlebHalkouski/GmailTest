package test.Steps;

import test.Pages.LoginPage;
import test.Pages.MainPage;
import test.Pages.NewMessageForm;
import webdriver.BaseEntity;

public class Steps extends BaseEntity {

	public void loginGmail(String username1, String password1) {
		LoginPage loginPage = new LoginPage();
		loginPage.loginGmail(username1, password1);
	}

	public void sendMessageToUser2() {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();
		NewMessageForm newMessageForm = new NewMessageForm();
		newMessageForm.sendMessageToUser2();
	}


	
}
