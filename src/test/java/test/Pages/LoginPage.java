package test.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.TextBox;
import webdriver.fieldDecorator.FieldDecorator;

public class LoginPage extends BasePage {

	private static final String URL_PAGE = "https://accounts.google.com/";
	
	@FindBy(id = "Email")
	private TextBox txbEmail;

	@FindBy(id = "next")
	private Button btnNext;
	
	@FindBy(id="Passwd")
	private TextBox txbPassword;
	
	@FindBy(id="signIn")
	private Button btnSingIn;
	
	
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
	
	public String getUrlPage(){
		return URL_PAGE;
	}


	
}
