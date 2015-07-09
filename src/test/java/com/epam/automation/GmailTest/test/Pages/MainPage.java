package com.epam.automation.GmailTest.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.automation.GmailTest.webdriver.BasePage;

public class MainPage extends BasePage{

	@FindBy(xpath = "//div[text()='НАПИСАТЬ']")
	private WebElement btnWtriteNewMessage;
	
	public MainPage() {
		super(By.id("gbqf"), "Main Page");
		PageFactory.initElements(browser.getWebDriver(), this);
		
	}

	public void startWriteNewMessage() {
		btnWtriteNewMessage.click();	
	}

}
