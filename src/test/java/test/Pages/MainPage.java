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

	protected static final String URL_TRASH = "https://mail.google.com/mail/u/1/#trash";
	protected static final String xpathAlertBigFile = "//div[@class='Kj-JD-K7 Kj-JD-K7-GIHV4']";
	protected Label lbAlertBigFile;
	
	protected final String xPathLetter = "//*[@email='%s']/ancestor::td/following-sibling::td[@class='xY a4W']"
			+ "//*[contains(text(),'%s')]/ancestor::td/following-sibling::td"
			+ "//span[@aria-label='%s']";
	protected Label lbLetter;
	
	@FindBy(xpath = "//div[text()='НАПИСАТЬ']")
	protected Button btnWtriteNewMessage;

	@FindBy(xpath = "//div[@class='Cr aqJ']/div[@class='G-Ni J-J5-Ji']/div")
	protected Button btnSettings;
	
	@FindBy(xpath = "//div[@id='ms']/div")
	protected Label lbSettings;
			
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

	public boolean isLetterInFolder(Letter letterUser) {
		System.out.println(String.format(xPathLetter , letterUser.getSenderUsername(), letterUser.getTheme(), letterUser.getTimeSend()));
		lbLetter = new LabelElement(By.xpath(String.format(xPathLetter , letterUser.getSenderUsername(),  letterUser.getTheme(), letterUser.getTimeSend())));
		return lbLetter.isPresent();
	}	
	
	public boolean isLetterMarked(Letter letterWithoutAttach) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void enterMessage(Letter letterUser) {
		lbLetter = new LabelElement(By.xpath(String.format(xPathLetter , letterUser.getSenderUsername(), letterUser.getTheme(), letterUser.getTimeSend())));
		lbLetter.click();
	}

	public void clickBtnSetting() {
		btnSettings.click();
		
	}

	public void clickLblSetting() {
		lbSettings.click();
	}

	public Boolean isAlertBigFile() {
		lbAlertBigFile = new LabelElement(By.xpath(xpathAlertBigFile));
		return lbAlertBigFile.isPresent();
	}

	public static String getUrlTrash() {
		return URL_TRASH;
	}

	

}
