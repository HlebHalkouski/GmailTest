package webdriver;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseEntity{

	protected Browser browser = Browser.getInstance();
	protected Logger logger = Logger.getInstance();
			
	
	@BeforeClass
	public void before() {
		browser = Browser.getInstance();	
		logger = Logger.getInstance();
	}

	
	@AfterClass
	public void after() {
		browser.exit();
	}	
}
