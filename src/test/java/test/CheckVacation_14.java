package test;

import java.util.GregorianCalendar;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import webdriver.Browser;
import webdriver.utils.Letter;

public class CheckVacation_14 extends BaseTest {

	private String username1;
	private String username2;
	private String password2;
	private Letter letterResponder;
	private final String bodyResponder = "Автоответчик включен";
	private final String themeResponder = "Автоответчик";
	private String password1;

	@BeforeMethod
	@Parameters({ "username1", "password1" , "username2", "password2" })
	public void beforeCheckVacationTest(String username1, String password1, String username2, String password2) {
		info("Precondition: ");
		this.username1 = username1;
		this.username2 = username2;
		this.password1 = password1;
		this.password2 = password2;
		letterResponder = new Letter(themeResponder, bodyResponder, GregorianCalendar.getInstance(), username1);
		steps.loginGmail(username1, password1);
	}
	
	@Test(alwaysRun = true)
	public void CheckVacationTest(){
		
		step(1);
		steps.enterSetting();
		
		step(2,5);
		steps.vacationResponderOn(letterResponder);
		letterResponder.setTime(GregorianCalendar.getInstance());
		
		browser.deleteAllCookiesAndRefresh();
		
		step(6);
		steps.loginGmail(username2, password2);
		
		step(7);
		steps.sendMessageToUser(username1, username2);
		
		step(8);
		Assert.assertTrue(steps.isletterInInbox(letterResponder), "Vacation message is present", "Vacation message isn't present");
	}
	
	@AfterMethod
	public void afterCheckVacationTest(){
		info("Postcondition: ");
		Browser.getInstance().deleteAllCookiesAndRefresh();
		steps.loginGmail(username1, password1);
		steps.enterSetting();
		steps.vacationResponderOff();
	}
}
