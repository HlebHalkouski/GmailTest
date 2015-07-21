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
	protected static final String xpathSettingDropDown = "//div[text()='Интерфейс:']";
	protected Label lbAlertBigFile;
	protected Label lbSettingDropDown;
	
	protected final String xPathLetter = "//*[@email='%s']/ancestor::td/following-sibling::td[@class='xY a4W']"
			+ "//*[contains(text(),'%s')]/ancestor::td/following-sibling::td"
			+ "//span[@aria-label='%s']";
	protected Label lbLetter;
	
	@FindBy(xpath = "//div[text()='НАПИСАТЬ']")
	protected Button btnWtriteNewMessage;

	@FindBy(xpath = "//div[@class='Cr aqJ']/div[@class='G-Ni J-J5-Ji']/div")
	protected Button btnSettings;
	
	@FindBy(xpath = "//div[@id='ms']/div")
	protected Label lbSettingsSetting;
		
	@FindBy(xpath = "//div[@id='pbwc']/div")
	protected Label lbSettingsTheme;
	
	@FindBy(xpath = "//a[@class='J-Ke n0 aBU']")
	protected Label lbInbox;
	
	@FindBy(xpath = "(//table[@class='F cf zt']//td[@class='oZ-x3 xY'])[1]")
	protected Label lbSelectTopMessage;
	
	@FindBy(xpath = "//*[@*='В спам!']")
	protected Button btnMarkAsSpam;
		
	protected final String xPathSendersEmail = "(//table[@class='F cf zt']//div[@class='yW']/span)";
	protected static final String SENDER_TIME_ATRIBUTE = "aria-label";
	protected static final String SENDER_EMAIL_ATRIBUTE = "email";
	protected static final String xPathSendersTheme = "(//table[@class='F cf zt']//div[@class='y6']/span[1])";
	protected static final String xPathSendersTime = "(//table[@class='F cf zt']//td[@class='xW xY ']/span)";
	
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
		lbLetter = new LabelElement(By.xpath(String.format(xPathLetter , letterUser.getSenderUsername(),  letterUser.getTheme(), letterUser.getTimeSend())));
		return lbLetter.isPresent();
	}	
	
	
	public void enterMessage(Letter letterUser) {
		lbLetter = new LabelElement(By.xpath(String.format(xPathLetter , letterUser.getSenderUsername(), letterUser.getTheme(), letterUser.getTimeSend())));
		lbLetter.click();
	}

	public void clickBtnSetting() {
		btnSettings.click();
		
	}

	public void clickSettingSetting() {
		lbSettingsSetting.click();
	}

	public Boolean isAlertBigFile() {
		lbAlertBigFile = new LabelElement(By.xpath(xpathAlertBigFile));
		lbAlertBigFile.click();
		return lbAlertBigFile.isPresent();
	}

	public static String getUrlTrash() {
		return URL_TRASH;
	}

	public Boolean isSettingDropDown() {
		lbSettingDropDown = new LabelElement(By.xpath(xpathSettingDropDown));
		return lbAlertBigFile.isPresent();
	}

	public void clickSettingsTheme() {
		lbSettingsTheme.click();		
	}

	public Letter selectTopMessage() {
		lbSelectTopMessage.click();
		String senderName = new LabelElement(By.xpath(xPathSendersEmail + "[1]")).getElement().getAttribute(SENDER_EMAIL_ATRIBUTE);
		String senderTheme = new LabelElement(By.xpath(xPathSendersTheme + "[1]")).getElement().getText();
		String senderTime = new LabelElement(By.xpath(xPathSendersTime  +"[1]")).getElement().getAttribute(SENDER_TIME_ATRIBUTE);
		return new Letter(senderTheme, "" , senderTime, senderName);
	}

	public void markSelectedMessageAsSpam() {
		btnMarkAsSpam.click();
	}

	public Boolean isLetterIsNotFolder(Letter markedLetter) {
		return !lbLetter.isPresent(By.xpath(String.format(xPathLetter , markedLetter.getSenderUsername(),  markedLetter.getTheme(), markedLetter.getTimeSend())));
	}

	
	

}
