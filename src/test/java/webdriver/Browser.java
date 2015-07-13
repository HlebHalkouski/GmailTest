package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Browser {
	
	private static RemoteWebDriver driver;
	private static Browser instance;
	public static PropertiesManager props;
	
	private static long timeoutForPageLoad;
	private static long implicitlyWait;
	
	private final static String PAGE_LOAD_TIMEOUT = "PageLoadTimeout";
	private final static String IMPLICITLY_WAIT = "ImplicitlyWait";
	
	private final static String PROPERTIES_FILE = "selenium.properties";
	
	
	
	private Browser(){
		Logger.getInstance().info("Browser is ready");
	};
	
	public static Browser getInstance(){
		initProperties();
		if(instance == null){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(timeoutForPageLoad, TimeUnit.SECONDS); 
			driver.get(getBaseUrl());
			instance = new Browser();
		}
		return instance;
	}

	public RemoteWebDriver getWebDriver() {
		return driver;
	}
	
	public static String getBaseUrl(){
		return System.getProperty("urlLoginPage", props.getProperty("urlLoginPage"));
	}
	
	private static void initProperties() {

		props = new PropertiesManager(PROPERTIES_FILE);
		timeoutForPageLoad = Long.parseLong(props.getProperty(PAGE_LOAD_TIMEOUT));
		implicitlyWait = Long.parseLong(props.getProperty(IMPLICITLY_WAIT));
	}

	
	public void exit() {
		try {
			driver.quit();
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
	}

	/**
	 * Navgates to the Url
	 * @param url Url
	 */
	public void navigate(final String url) {
		driver.navigate().to(url);
	}
	
	
}
