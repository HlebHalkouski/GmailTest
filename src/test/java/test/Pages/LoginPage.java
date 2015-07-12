package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;

public class LoginPage extends BasePage {

	@FindBy(id = "Email")
	private WebElement txbEmail;

	@FindBy(id = "next")
	private WebElement btnNext;
	
	@FindBy(id="Passwd")
	private WebElement txbPassword;
	
	@FindBy(id="signIn")
	private WebElement btnSingIn;
	
	
	public LoginPage() {
		super(By.className("card signin-card pre-shift no-name"), "Login Page");
		PageFactory.initElements(browser.getWebDriver(), this);
	
	}
	
	public MainPage loginGmail(String username, String password){
		txbEmail.sendKeys(username);
		btnNext.click();
		txbPassword.sendKeys(password);
		btnSingIn.click();
		return new MainPage();
	}

	public void openPage(){
		
	}

	
}
