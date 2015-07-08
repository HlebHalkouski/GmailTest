package com.epam.automation.GmailTest.webdriver.elements;

public class TextBox extends BaseElement{

	public void type(String username) {
		
		element.sendKeys(username);
		
	}

}
