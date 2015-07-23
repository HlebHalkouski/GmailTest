package webdriver;

import org.testng.annotations.BeforeMethod;

import test.Steps.Steps;

public abstract class BaseTest extends BaseEntity {

	protected Steps steps = new Steps();
	protected Asserts Assert = new Asserts();
	
	protected String formatLogMsg(final String message) {
		return message;
	}
	
	@BeforeMethod(alwaysRun = true)
	public void startTest(){
		Logger.getInstance().logTestName(this.getClass().getSimpleName());
	}
	
}
