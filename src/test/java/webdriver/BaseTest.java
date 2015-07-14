package webdriver;

import org.testng.annotations.BeforeTest;

import test.Steps.Steps;

public abstract class BaseTest extends BaseEntity {

	protected Steps steps = new Steps();
	
	protected String formatLogMsg(final String message) {
		return message;
	}
	
	@BeforeTest
	public void startTest(){
		Logger.getInstance().logTestName(this.getClass().getName());
	}
	
	
}
