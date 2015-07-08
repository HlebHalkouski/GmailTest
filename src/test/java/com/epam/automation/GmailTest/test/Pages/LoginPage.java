package com.epam.automation.GmailTest.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.automation.GmailTest.webdriver.BasePage;
import com.epam.automation.GmailTest.webdriver.elements.Button;
import com.epam.automation.GmailTest.webdriver.elements.TextBox;

public class LoginPage extends BasePage {

	@FindBy(id = "Email")
	private TextBox txbEmail;
	
	@FindBy(id="next")
	private Button btnNext;
	
	public LoginPage() {
		super(By.id("Email"), "Login Page");
		PageFactory.initElements(browser.getWebDriver(), this);
	}
	
	public void login(String username, String password){
		
		txbEmail.type(username);
		btnNext.click();
		
	}

	

	
}
