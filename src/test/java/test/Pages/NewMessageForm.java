package test.Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.ButtonElement;
import webdriver.elements.LabelElement;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.elements.interfaces.TextBox;
import webdriver.fieldDecorator.FieldDecorator;
import webdriver.utils.Letter;
import webdriver.utils.RandomUtil;
import webdriver.utils.RobotForAttachFile;


public class NewMessageForm extends BasePage {
	
	private static final int BODY_LENGHT = 30;

	private static final int THEME_LENGTH = 5;

	@FindBy(xpath = "//textarea[@aria-label='Кому']")
	private TextBox txbAdressTo;
	
	@FindBy(xpath = "//input[@placeholder='Тема']")
	private TextBox txbTheme;
	
	@FindBy(xpath = "//div[@aria-label='Тело письма']")
	private TextBox txbMessageBody;
	
	@FindBy(xpath = "//div[contains(text(), 'Отправить')]")
	private Button btnSend;
	
	private final static String idSendMessageLink = "link_vsm";

	@FindBy(id = idSendMessageLink)
	private Label lbSendMessageLink;
	
	@FindBy(xpath = "//div[@aria-label='Прикрепить файлы']//div[@class='a1 aaA aMZ']")
	private Button btnAttachFile;
	
	private static final String xPathLinkAttachFile = "//a[@class='dO']";
	@FindBy(xpath = xPathLinkAttachFile)
	private Label lbLinkAttachFile;
	
	private static final String xPathParseEmotionWindow = "//div[@class='a8u']";
	private Label ParseEmotionWindow;
	
	@FindBy(xpath = "//div[@class='QT aaA aMZ']")
	private Button btnOpenParseSmile;
	
	@FindBy(xpath = "//button[@ title='Эмоции']")
	private Button btnOpenParseEmotion;

	private final String xPathEmotionsIcons = "//button[@string='%s']";
	private final String xPathEmotionsIconsInBody = "//img[@goomoji='%s']";
	
	public NewMessageForm() {
		super(By.xpath("//div[@role='dialog']"), "New Message Form");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);	
	}

	/**
	 * Send random message to user.
	 *
	 * @param username1 the sender email
	 * @param username2 the addresser email
	 * @return the message
	 */
	public Letter sendMessageToUser(String username1, String username2){
		Letter sendingLetter =  typeMessageFields(username1, username2);
		clickSendMessage();
		return sendingLetter;
	}

	public Letter typeMessageFields(String username1, String username2) {
		String theme = RandomUtil.getRandomString(THEME_LENGTH);
		String body = RandomUtil.getRandomString(BODY_LENGHT);
		txbAdressTo.type(username2);
		txbTheme.type(theme);
		txbMessageBody.type(body);
		return new Letter(theme, body, GregorianCalendar.getInstance(), username1);
	}

	/**
	 * Send message to user.
	 *
	 * @param messageUser the message 
	 * @param username2 the addresser email
	 * @return the letter
	 */
	public Letter sendMessageToUser(Letter messageUser, String username2) {
		String theme = messageUser.getTheme();
		String body = messageUser.getBody();
		String username = messageUser.getSenderUsername();
		txbAdressTo.type(username2);
		txbTheme.type(theme);
		txbMessageBody.type(body);
		clickSendMessage();
		return new Letter(theme, body, GregorianCalendar.getInstance(), username);
	}

	public void enterAdresserThemeAndBodyMessage(String username2) {
		txbAdressTo.type(username2);
		txbTheme.type(RandomUtil.getRandomString(THEME_LENGTH));
		txbMessageBody.type(RandomUtil.getRandomString(BODY_LENGHT));	
	}

	public void clickAttachFile() {
		btnAttachFile.click();		
	}

	public void chooseAttachFile(File attachFile) {
		RobotForAttachFile.attachFile(attachFile);
		lbLinkAttachFile.waitForIsElementPresent(By.xpath(xPathLinkAttachFile));
				
	}

	public void clickSendMessage() {
		btnSend.click();
		lbSendMessageLink.waitForIsElementPresent(By.id(idSendMessageLink));
	}

	public void openParseEmotion() {
		btnOpenParseSmile.click();	
		btnOpenParseEmotion.click();
	}

	public Boolean isParseEmotionPresent() {
		ParseEmotionWindow = new LabelElement(By.xpath(xPathParseEmotionWindow));
		return ParseEmotionWindow.isPresent();
	}

	/**
	 * Choose emotions icons.
	 * Add emotions in body message and return String numbers
	 *
	 * @param count the count icons
	 * @return the array list of String numbers of icons
	 */
	public ArrayList<String> chooseEmotionsIcons(int count) {
		ArrayList<String> listSeningEmotions = new ArrayList<String>();
		
		String iconStringNumber;
		for(int i=0; i<count; i++){
			iconStringNumber = RandomUtil.generateIconNumber();
			listSeningEmotions.add(iconStringNumber);
			new ButtonElement(By.xpath(String.format(xPathEmotionsIcons , iconStringNumber ))).click();;
		}
		return listSeningEmotions;
				
	}

	public Boolean isIconsInBody(ArrayList<String> listSendingIcons) {
		Boolean isPresents = true;
		LabelElement lbIconsInBody;
		for(String iconStringNumber: listSendingIcons)
		{
			lbIconsInBody = new LabelElement(By.xpath(String.format(xPathEmotionsIconsInBody, iconStringNumber)));
			isPresents = lbIconsInBody.isPresent();
		}
		return isPresents;
	}

}
