package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.fieldDecorator.FieldDecorator;

public class MessagePage extends BasePage{

	@FindBy(xpath = "//div[@aria-label='Ещё']")
	private Button btnMore;
	
	@FindBy(xpath = "//div[contains(text(), 'В спам!')]")
	private Label lbInSpam;
	
	public MessagePage() {
		super(By.xpath("//div[@class='G3 G2']"), "Message Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	}

	public void markMessageAsSpam() {
		btnMore.click();
		lbInSpam.click();
	}
	
	

}
