package test.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.fieldDecorator.FieldDecorator;
import webdriver.BasePage;
import webdriver.elements.interfaces.IButton;
import webdriver.elements.interfaces.ITextBox;

public class LoginPage extends BasePage {

	@FindBy(id = "Email")
	private ITextBox txbEmail;

	@FindBy(id = "next")
	private IButton btnNext;
	
	@FindBy(id="Passwd")
	private ITextBox txbPassword;
	
	@FindBy(id="signIn")
	private IButton btnSingIn;
	
	
	public LoginPage() {
		super(By.className("card signin-card pre-shift no-name"), "Login Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	
	}
	
	public void loginGmail(String username, String password){
		txbEmail.type(username);
		btnNext.click();
		txbPassword.type(password);
		btnSingIn.click();
	}


	
}
