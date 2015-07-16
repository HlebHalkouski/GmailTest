package webdriver;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity {

	protected Browser browser = Browser.getInstance();
	protected Logger logger = Logger.getInstance();
	
	
	@BeforeClass
	public void before() {
		browser = Browser.getInstance();
		logger = Logger.getInstance();
	}

	@AfterClass
	public void after() {
		if (browser.isBrowserAlive()) {
			browser.exit();
		}
	}

	/**
	 * Format message.
	 * 
	 * @param message
	 *            message
	 * @return null
	 */
	protected abstract String formatLogMsg(String message);

	/**
	 * Informative message.
	 * 
	 * @param message
	 *            Message
	 */
	protected void info(final String message) {
		logger.info(formatLogMsg(message));
	}

	/**
	 * Warning.
	 * 
	 * @param message
	 *            Message
	 */
	protected void warn(final String message) {
		logger.warn(formatLogMsg(message));
	}

	/**
	 * Error message without stopping the test.
	 * 
	 * @param message
	 *            Message
	 */
	protected void error(final String message) {
		logger.error(formatLogMsg(message));
	}

	/**
	 * Fatal error message.
	 * 
	 * @param message
	 *            Message
	 */
	protected void fatal(final String message) {
		logger.fatal(formatLogMsg(message));
		Assert.assertTrue(false, formatLogMsg(message));
	}

	/**
	 * Step.
	 *
	 * @param number the step number
	 */
	protected void step(int number){
		logger.step(number);	
	}
	
	
}
