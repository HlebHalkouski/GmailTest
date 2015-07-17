package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.interfaces.Label;
import webdriver.fieldDecorator.FieldDecorator;

public class SettingPage extends BasePage {
	
	
	
	@FindBy(xpath = "//a[contains(text(),'Пересылка и POP/IMAP')]")
	private Label lbForwardSetting;

		
	public SettingPage() {
		super(By.xpath("//h2[contains(text(),'Настройки')]"), "Setting Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);	
	}

	public void enterForwardSetting() {
		lbForwardSetting.click();
	}

	
	
}
