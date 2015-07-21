package test.Steps;

import java.io.File;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import test.Pages.ForwardPage;
import test.Pages.LoginPage;
import test.Pages.MainPage;
import test.Pages.MessagePage;
import test.Pages.NewMessageForm;
import test.Pages.SettingPage;
import test.Pages.SpamPage;
import test.Pages.ThemePage;
import test.Pages.TrashPage;
import webdriver.BaseEntity;
import webdriver.utils.Letter;
import webdriver.utils.RobotForAttachFile;

public class Steps extends BaseEntity {

	private static final String MAIL_SPAM = "https://mail.google.com/mail/u/0/#spam";

	protected String formatLogMsg(final String message) {
		return message;
	}

	public void loginGmail(String username, String password) {
		browser.navigate(LoginPage.getUrlPage());
		LoginPage loginPage = new LoginPage();
		loginPage.loginGmail(username, password);
	}

	/**
	 * Send Random message to user.
	 *
	 * @param username1 the sender email
	 * @param username2 the addresser email
	 * @return the message
	 */
	public Letter sendMessageToUser(String username1, String username2) {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();
		NewMessageForm newMessageForm = new NewMessageForm();
		return newMessageForm.sendMessageToUser(username1, username2);
	}

	/**
	 * Send message to user.
	 *
	 * @param messageUser1 the message
	 * @param username2 the addresser email
	 * @return the letter
	 */
	public Letter sendMessageToUser(Letter messageUser1, String username2) {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();
		NewMessageForm newMessageForm = new NewMessageForm();
		return newMessageForm.sendMessageToUser(messageUser1, username2);
	}

	
	
	public void markLetterAsSpam(Letter letterUser) {
		MainPage mainPage = new MainPage();
		mainPage.enterMessage(letterUser);
		MessagePage messagePage = new MessagePage();
		messagePage.markMessageAsSpam();
		
	}

	public boolean isLetterInSpam(String username, Letter letterUser) {
		SpamPage spamPage = new SpamPage();
		return spamPage.isLetterInFolder(letterUser);
	}

	public void goToSpam() {
		browser.navigate(MAIL_SPAM);	
		@SuppressWarnings("unused")
		SpamPage spamPage = new SpamPage();
	}

	public void returnMessageFromSpam(Letter letterUser) {
		SpamPage spamPage = new SpamPage();
		spamPage.enterMessage(letterUser);
		MessagePage messagePage = new MessagePage();
		messagePage.markMessageIsNoSpam();
		
	}

	public void clickBtnSetting() {
		MainPage mainPage = new MainPage();
		mainPage.clickBtnSetting();	
	}


	public Boolean isSettingDropDown() {
		MainPage mainPage = new MainPage();
		return mainPage.isSettingDropDown();
	}

	public void enterSettingTheme() {
		MainPage mainPage = new MainPage();	
		mainPage.clickSettingsTheme();
	}
	
	public void enterSetting() {
		MainPage mainPage = new MainPage();
		mainPage.clickBtnSetting();	
		mainPage.clickSettingSetting();
	}

	public Letter setForwardToUser(String username3) {
		SettingPage settingPage = new SettingPage();
		settingPage.enterForwardSetting();
		ForwardPage forwardPage = new ForwardPage();
		return forwardPage.addForwardUser(username3);	
	}

	public void confirmForward(Letter letteForward) {
		MainPage mainPage = new MainPage();
		mainPage.enterMessage(letteForward);
		MessagePage messagePage = new MessagePage();
		messagePage.confirmForward();
	}

	public void startWriteNewMessage() {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();		
	}

	public Boolean isAlertBigFile() {
		MainPage mainPage = new MainPage();
		return mainPage.isAlertBigFile();
	}

	public void setForwardSetting(String username) {
		browser.navigate(ForwardPage.getUrlPage());
		ForwardPage forwardPage = new ForwardPage();
		forwardPage.chooseRadioForwardCopy();
		forwardPage.enterFilter();
		forwardPage.setFilterSettings(username);
	}

	public Letter sendAttachMessageToUser(String username1, String username2, File attachFile) {
		MainPage mainPage = new MainPage();
		mainPage.startWriteNewMessage();
		NewMessageForm newMessageForm = new NewMessageForm();
		Letter sendingLetter = newMessageForm.typeMessageFields(username1, username2);
		newMessageForm.clickAttachFile();
		newMessageForm.chooseAttachFile(attachFile);
		newMessageForm.clickSendMessage();
		sendingLetter.setTime(GregorianCalendar.getInstance());
		return sendingLetter;
	}

	public Boolean isletterInTrash(Letter letterWithAttach) {
		@SuppressWarnings("unused")
		MainPage mainPage = new MainPage();
		browser.navigate(MainPage.getUrlTrash());
		TrashPage trashPage = new TrashPage();
		return trashPage.isLetterInFolder(letterWithAttach);
	}

	public Boolean isletterInInbox(Letter letterWithoutAttach) {
		MainPage mainPage = new MainPage();
		return mainPage.isLetterInFolder(letterWithoutAttach);
	}

	public void deleteForward() {
		browser.navigate(ForwardPage.getUrlPage());
		ForwardPage forwardPage = new ForwardPage();
		forwardPage.deleteForward();
		
	}

	

	public void enterUploadTheme() {
		ThemePage themePage = new ThemePage();
		themePage.enterUploadTheme();
	}

	
	public void uploadThemeFile(File attachFile) {
		RobotForAttachFile.attachFile(attachFile);		
	}

	public Boolean isAlertWrongFilePresent() {
		browser.getWebDriver().switchTo().parentFrame();
		ThemePage themePage = new ThemePage();
		return themePage.isAlertWrongFilePresent();
	}

	public Letter typeMessageFields(String username1, String username2) {
		NewMessageForm newMessageForm = new NewMessageForm();
		Letter sendingLetter = newMessageForm.typeMessageFields(username1, username2);
		return sendingLetter;	
		
	}

	public void openParseEmotion() {
		NewMessageForm newMessageForm = new NewMessageForm();
		newMessageForm.openParseEmotion();
	}

	public Boolean isParseEmotionPresent() {
		NewMessageForm newMessageForm = new NewMessageForm();
		return newMessageForm.isParseEmotionPresent();
	}

	public ArrayList<String> chooseEmotionsIcons(int countIcons) {
		NewMessageForm newMessageForm = new NewMessageForm();
		return newMessageForm.chooseEmotionsIcons(countIcons);
		
	}

	public Boolean isIconsInBody(ArrayList<String> listSendingIcons) {
		NewMessageForm newMessageForm = new NewMessageForm();
		return newMessageForm.isIconsInBody(listSendingIcons);
	}

	public void clickSendMessage() {
		NewMessageForm newMessageForm = new NewMessageForm();
		newMessageForm.clickSendMessage();
	}

	public void enterMessage(Letter sendingLetter) {
		MainPage mainPage = new MainPage();
		mainPage.enterMessage(sendingLetter);
	}

	public Boolean isIconsInLetter(ArrayList<String> listSendingIcons) {
		MessagePage messagePage = new MessagePage();
		return messagePage.isIconsInLetter(listSendingIcons);
	}

	public Letter selectTopMessage() {
		MainPage mainPage = new MainPage();
		return mainPage.selectTopMessage();
	}

	public void markSelectedMessageAsSpam() {
		MainPage mainPage = new MainPage();
		mainPage.markSelectedMessageAsSpam();
	}

	public Boolean isLetterIsNotFolder(Letter markedLetter) {
		MainPage mainPage = new MainPage();
		return mainPage.isLetterIsNotFolder(markedLetter);
	}

	public void markMessageIsNoSpam() {
		MessagePage messagePage = new MessagePage();
		messagePage.markMessageIsNoSpam();		
	}

	
				
}
