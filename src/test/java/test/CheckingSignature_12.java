package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.utils.RandomUtil;

public class CheckingSignature_12 extends BaseTest {

	private String singnature;

	@BeforeMethod
	@Parameters({ "username1", "password1" })
	public void beforeMainMailBoxPageTest(String username1, String password1) {
		singnature = RandomUtil.getRandomString(10);
		info("Precondition: ");
		steps.loginGmail(username1, password1);

	}

	@Test
	public void CheckingSignatureTest() {
		step(1, 2);
		steps.enterSetting();

		step(3);
		steps.enterSignature(singnature);

		step(4);
		steps.saveSettingsChange();

		step(5);
		steps.startWriteNewMessage();

		step(6);
		Assert.assertTrue(steps.isSignatureInMessage(singnature), "Singnature in message", "Singnature isn't message");

	}
}
