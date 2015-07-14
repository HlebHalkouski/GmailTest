package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.LabelElement;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.fieldDecorator.FieldDecorator;
import webdriver.utils.Letter;

public class MainPage extends BasePage{

	protected Label lbLetter;
	
	@FindBy(xpath = "//div[text()='НАПИСАТЬ']")
	protected Button btnWtriteNewMessage;

	protected String xPathLetter = "//*[@email='%s']/ancestor::td/following-sibling::td//b[contains(text(), '%s')]";

	protected MainPage(By locale, String title) {
		super(locale, title);
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	}
	
	public MainPage() {
		super(By.id("gbqf"), "Main Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	}

	public void startWriteNewMessage() {
		btnWtriteNewMessage.click();	
	}

	public void enterUserMessage(String username, Letter messageUser) {
		lbLetter = new LabelElement(By.xpath(String.format(xPathLetter , username, messageUser.getTimeSend())));
		lbLetter.click();
	}
	

}
