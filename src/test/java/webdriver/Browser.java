package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {
	
	private static final String SESSION_COOKIE_NAME = "APISID";
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
			Logger.getInstance().info("driver is quit");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			instance = null;
		}
	}
	
	/**
	 * Checks is Browser alive
	 * @return true\false
	 */
	public boolean isBrowserAlive(){
		 return instance != null;
		
	}

	/**
	 * Navigates to the Url
	 * @param url Url
	 */
	public void navigate(final String url) {
		driver.navigate().to(url);
	}

	public int getImplicitlyWait() {
		return  Integer.parseInt(props.getProperty(IMPLICITLY_WAIT));
	}
	
	public int getPageLoadTimeout() {
		return  Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT));
	}

	public Cookie getSessionCookie() {
		return driver.manage().getCookieNamed(SESSION_COOKIE_NAME);
	}
	
	public void addCookieAndRefresh(Cookie cookie){
		driver.manage().addCookie(cookie);
		driver.navigate().refresh();
	}
	
	/**
	 * wait the download page (on Javascript readyState)
	 */
	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, getPageLoadTimeout());

		try {
			wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>() {
				public Boolean apply(final WebDriver d) {
					if (!(d instanceof JavascriptExecutor)) {
						return true;
					}
					Object result = ((JavascriptExecutor) d)
							.executeScript("return document['readyState'] ? 'complete' == document.readyState : true");
					if (result != null && result instanceof Boolean && (Boolean) result) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception e) {
			Logger.getInstance().warn("Page timeout!");
		}
	}

	public void deleteAllCookiesAndRefresh() {
		waitForPageToLoad();
		do {
			driver.manage().deleteAllCookies();
			driver.navigate().refresh();
		} while (driver.manage().getCookieNamed("LSID") != null);

	}

	/**
	 * Close windows except parentPage.
	 *
	 * @param windowHandle the window parentPage
	 */
	public void closeWindowsExcept(String windowHandle) {
		 Set<String> Handles = driver.getWindowHandles();
		  for(String newHandle : Handles)
		   if(!newHandle.equals(windowHandle)){
			   driver.switchTo().window(newHandle);
			   driver.close();
		   }
		  driver.switchTo().window(windowHandle);
	}
	
	
}
