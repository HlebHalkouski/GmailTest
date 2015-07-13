package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.utils.RandomString;

public class NewMessageForm extends BasePage {
	
	@FindBy(xpath = "//textarea[@aria-label='Кому']")
	private WebElement txbAdressTo;
	
	@FindBy(xpath = "//input[@placeholder='Тема']")
	private WebElement txbTheme;
	
	@FindBy(xpath = "//div[@aria-label='Тело письма']")
	private WebElement txbMessageBody;
	
	@FindBy(xpath = "//div[contains(text(), 'Отправить')]")
	private WebElement btnSend;
	
	
	public NewMessageForm() {
		super(By.xpath("//div[@role='dialog']"), "New Message Form");
		PageFactory.initElements(browser.getWebDriver(), this);	
	}

	public void sendMessageToUser(String username){
		txbAdressTo.sendKeys(username);
		txbTheme.sendKeys(RandomString.getRandomString(5));
		txbMessageBody.sendKeys(RandomString.getRandomString(30));
		btnSend.click();
	}

}
