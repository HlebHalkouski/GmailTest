package com.epam.automation.GmailTest.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.epam.automation.GmailTest.webdriver.BasePage;
import com.epam.automation.GmailTest.webdriver.elements.TextBox;

public class LoginPage extends BasePage{

	@FindBy(id = "Email")
	TextBox txbEmail;
	
	public LoginPage() {
		super(By.id("Email"), "Login Page");
	}
	
	


	
}
