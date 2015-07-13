package webdriver;


import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

	private Properties properties;

	/**
	 * Constructor
	 * @param resourceName Name of resource
	 */
	public PropertiesManager(final String resourceName) {
		try {
			properties = new Properties();
			properties.load(this.getClass().getClassLoader().getResourceAsStream(resourceName));
		} catch (IOException e) {
			System.err.println(String.format("Resource \"%1$s\" could not be found", resourceName));
		}
	}	


	/**
	 * Получение значения параметра по ключу
	 * @param key Key
	 * @return Value
	 */
	public String getProperty(final String key) {
		return properties.getProperty(key);
	}

	

}
