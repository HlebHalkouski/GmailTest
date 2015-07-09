package com.epam.automation.GmailTest.test.steps;

import com.epam.automation.GmailTest.test.Pages.LoginPage;
import com.epam.automation.GmailTest.test.Pages.MainPage;
import com.epam.automation.GmailTest.test.Pages.NewMessageForm;
import com.epam.automation.GmailTest.webdriver.BaseEntity;

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
