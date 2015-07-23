package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.Browser;
import webdriver.utils.Letter;

public class SendMailWithAttachement_05 extends BaseTest {

	private static final int COUNT_ICONS = 3;
	private String username1;
	private Letter sendingLetter;
	private ArrayList<String> listSendingIcons;

	@BeforeMethod
	@Parameters({ "username1", "password1" })
	public void beforeMainMailBoxPageTest(String username1, String password1) {
		info("Precondition: ");
		this.username1 = username1;
		steps.loginGmail(username1, password1);
	}

	@Test(alwaysRun = true)
	public void SendMailWithAttachementTest() {
		step(1);
		steps.startWriteNewMessage();

		step(2);
		sendingLetter = steps.typeMessageFields(username1, username1);

		step(3);
		steps.openParseEmotion();
		Assert.assertTrue(steps.isParseEmotionPresent(), "Window this emotion appers",
				"Window this emotion don't appers");

		step(4, 5);
		listSendingIcons = steps.chooseEmotionsIcons(COUNT_ICONS);

		step(6);
		Assert.assertTrue(steps.isIconsInBody(listSendingIcons), "Icons in body message", "Icons isn't body message");

		step(7);
		steps.clickSendMessage();
		sendingLetter.setTime(GregorianCalendar.getInstance());

		step(8);
		browser.navigate(Browser.getBaseUrl());
		steps.enterMessage(sendingLetter);
		Assert.assertTrue(steps.isIconsInLetter(listSendingIcons), "Icons in input letter", "Icons isn't input letter");

	}

}
