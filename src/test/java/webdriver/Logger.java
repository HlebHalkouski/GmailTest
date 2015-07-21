package webdriver;

import org.testng.Assert;
import org.testng.Reporter;

/**
 * This class is using for a creating extended log. It implements a Singleton
 * pattern
 */
public final class Logger {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Logger.class);
	private static Logger instance = null;

	

	private Logger() {
	}

	/**
	 * Implementation of the Singleton pattern
	 * 
	 * @return Logger instance
	 */
	public static synchronized Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	/**
	 * Logging a step number
	 * 
	 * @param step
	 *            - step number
	 */
	public void step(final int step) {
		logDelimMsg("step " + String.valueOf(step));
	}
	
	
	/**
	 *  Logging a step number
	 *
	 * @param step1 - from step number
	 * @param step2 - to step number
	 */
	public void step(final int step1, final int step2) {
		logDelimMsg(String.format("steps: %s-%s", String.valueOf(step1) , String.valueOf(step2)));
	}

	/**
	 * This method is using for formatting almost all log records
	 * 
	 * @param msg
	 *            Formatted message
	 */
	private void logDelimMsg(final String msg) {
		info(String.format("--------==[ %1$s ]==--------", msg));

	}

	/**
	 * This method logs test's name
	 * 
	 * @param testName
	 *            test's name
	 */
	public void logTestName(final String testName) {
		String formattedName = String.format("==========  %1$s: '%2$s' ==========", "Test case",
				testName);
		info(formattedName);
		Reporter.log(formattedName + "<br>");
	}


	/**
	 * Info log
	 * 
	 * @param message
	 *            Message
	 */
	public void info(final String message) {
		logger.info(message);
		Reporter.log(message + "<br>");
	}

	/**
	 * Warning log
	 * 
	 * @param message
	 *            Message
	 */
	public void warn(final String message) {
		String msg = message;
		logger.warn(message);
		msg = "<div class=\"skipped\">" + msg + "</div>"; // yellow color from
															// reportng css
		Reporter.log(msg + "<br>");
	}


	/**
	 * Error log
	 * 
	 * @param message
	 *            Message
	 */
	public void error(final String message) {
		String msg = message;
		logger.error(message);
		msg = "<div class=\"failedConfig\">" + msg + "</div>"; // red color from
																// reportng css
		Reporter.log(msg + "<br>");
	}

	/**
	 * Fatal log
	 * 
	 * @param message
	 *            Message
	 */
	public void fatal(final String message) {
		String msg = message;
		logger.fatal(message);
		msg = "<div class=\"failedConfig\">" + msg + "</div>"; // red color from
																// reportng css
		Reporter.log(msg + "<br>");
		Assert.assertTrue(false, message);
	}
}
