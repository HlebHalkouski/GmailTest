package test.Pages;

import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.LabelElement;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.elements.interfaces.TextBox;
import webdriver.fieldDecorator.FieldDecorator;
import webdriver.utils.Letter;
import webdriver.utils.RandomString;

public class NewMessageForm extends BasePage {
	
	@FindBy(xpath = "//textarea[@aria-label='Кому']")
	private TextBox txbAdressTo;
	
	@FindBy(xpath = "//input[@placeholder='Тема']")
	private TextBox txbTheme;
	
	@FindBy(xpath = "//div[@aria-label='Тело письма']")
	private TextBox txbMessageBody;
	
	@FindBy(xpath = "//div[contains(text(), 'Отправить')]")
	private Button btnSend;
	
	private Label lbSendMessageLink;
	
	public NewMessageForm() {
		super(By.xpath("//div[@role='dialog']"), "New Message Form");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);	
	}

	/**
	 * Send message to user.
	 *
	 * @param username1 the sender email
	 * @param username2 the adresser email
	 * @return the message
	 */
	public Letter sendMessageToUser(String username1, String username2){
		String theme = RandomString.getRandomString(5);
		String body = RandomString.getRandomString(30);
		txbAdressTo.type(username2);
		txbTheme.type(theme);
		txbMessageBody.type(body);
		btnSend.click();
		lbSendMessageLink = new LabelElement(By.id("link_vsm"));
		lbSendMessageLink.waitForIsElementPresent();
		return new Letter(theme, body, GregorianCalendar.getInstance(), username1);
	}

}
