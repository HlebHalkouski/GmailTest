package test;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.Browser;
import webdriver.utils.Letter;
import webdriver.utils.RandomUtil;

public class Forward_02 extends BaseTest {

	private static final int SIZE_ATTACH_FILE = 1;
	private String username1;
	private String username2;
	private String password1;
	private String password2;
	private String username3;
	private String password3;
	private Letter letterForward;
	private Letter letterWithoutAttach;
	private File attachFile;
	private Letter letterWithAttach;

	@BeforeMethod
	@Parameters({ "username1", "password1", "username2", "password2", "username3", "password3" })
	public void beforForwardTest(String username1, String password1, String username2, String password2,
			String username3, String password3) {
		this.username1 = username1;
		this.username2 = username2;
		this.username3 = username3;

		this.password1 = password1;
		this.password2 = password2;
		this.password3 = password3;

		this.attachFile = RandomUtil.getFile(SIZE_ATTACH_FILE);
	}

	@Test
	public void ForwardTest() {

		step(1);
		steps.loginGmail(username2, password2);

		step(2, 3);
		steps.enterSetting();

		step(4, 5);
		letterForward = steps.setForwardToUser(username3);

		browser.deleteAllCookiesAndRefresh();

		step(6);
		steps.loginGmail(username3, password3);

		step(7);
		steps.confirmForward(letterForward);

		browser.deleteAllCookiesAndRefresh();

		step(8);
		steps.loginGmail(username2, password2);

		step(9, 12);
		steps.setForwardSetting(username1);

		browser.deleteAllCookiesAndRefresh();

		step(13);
		steps.loginGmail(username1, password1);

		step(14);
		letterWithoutAttach = steps.sendMessageToUser(username1, username2);

		step(15);
		letterWithAttach = steps.sendAttachMessageToUser(username1, username2, attachFile);

		browser.deleteAllCookiesAndRefresh();

		step(16);
		steps.loginGmail(username2, password2);

		step(17);
		Assert.assertTrue(steps.isletterInTrash(letterWithAttach), "Letter with attach in trash!",
				"Letter with attach isn't trash!");

		step(18);
		browser.navigate(Browser.getBaseUrl());
		Assert.assertTrue(steps.isletterInInbox(letterWithoutAttach), "Letter without attach in inbox!",
				"Letter without attach isn't inbox!");

		browser.deleteAllCookiesAndRefresh();

		step(19);
		steps.loginGmail(username3, password3);

		step(20);
		Assert.assertTrue(steps.isletterInInbox(letterWithoutAttach), "Letter without attach in inbox!",
				"Letter without attach isn't inbox!");

	}

	@AfterMethod
	public void afterForwardTest() {
		info("========== Postcondition========== ");
		Browser.getInstance().deleteAllCookiesAndRefresh();
		steps.loginGmail(username2, password2);
		steps.deleteForward();
		browser.exit();
	}
}
