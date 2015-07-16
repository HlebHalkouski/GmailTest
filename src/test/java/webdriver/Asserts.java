package webdriver;

public class Asserts extends BaseEntity {

	/**
	 * Universal method
	 * 
	 * @param isTrue
	 *            Condition
	 * @param passMsg
	 *            Positive message
	 * @param failMsg
	 *            Negative message
	 */
	public void assertTrue(final Boolean isTrue, final String passMsg, final String failMsg) {
		if (isTrue)
			info("Assert true: " + passMsg);
		else
			fatal("Assert fail:" + failMsg);

	}

	
	/**
	 * Assert Objects are Equal
	 * 
	 * @param expected
	 *            Expected Value
	 * @param actual
	 *            Actual Value
	 */
	public void assertEquals(final Object expected, final Object actual) {
		if (expected.equals(actual))
			info("Value is correct");
		else {
			fatal("Expected value: '" + expected + "', but was: '" + actual + "'");
		}
	}

	/**
	 * Assert Objects are Equal
	 * 
	 * @param message
	 *            Fail Message
	 * @param expected
	 *            Expected Value
	 * @param actual
	 *            Actual Value
	 */
	public void assertEquals(final Object expected, final Object actual, final String message) {
		if (expected.equals(actual))
			info(message + " is correct");
		else {
			fatal(message + " Expected value: '" + expected + "', but was: '" + actual + "'");
		}
	}

	@Override
	protected String formatLogMsg(String message) {

		return message;
	}

}