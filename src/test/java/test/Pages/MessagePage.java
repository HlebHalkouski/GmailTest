package test.Pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.LabelElement;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.fieldDecorator.FieldDecorator;

public class MessagePage extends BasePage{

	@FindBy(xpath = "//div[@aria-label='Ещё']")
	private Button btnMore;
	
	@FindBy(xpath = "//div[contains(text(), 'В спам!')]")
	private Label lbInSpam;
	
	@FindBy(xpath = "//span[@title='Удалить ярлык Спам из данной цепочки']")
	private Label lbNotSpam;
	
	private final static String xPathSpamMessages = "//span[@class='bofITb']";
	private static final String xPathEmotionsIconsInBody = "//img[@goomoji='%s']";
	
	@FindBy(xpath = xPathSpamMessages)
	private Label lbSpamMessages;
	
	@FindBy(xpath = "//a[contains(@href,'isolated.mail.google.com' )]")
	private Label lbLinkConfirmForward;
	
	public MessagePage() {
		super(By.xpath("//div[@class='G3 G2']"), "Message Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	}

	public void markMessageAsSpam() {
		btnMore.click();
		lbInSpam.click();
		lbSpamMessages.waitForIsElementPresent(By.xpath(xPathSpamMessages));
	}

	public void markMessageIsNoSpam() {
		btnMore.click();
		lbNotSpam.click();
		lbSpamMessages.waitForIsElementPresent(By.xpath(xPathSpamMessages));
	}

	public void confirmForward() {
		String windowHandle = browser.getWebDriver().getWindowHandle();
		lbLinkConfirmForward.click();
		browser.closeWindowsExcept(windowHandle);
		
	}

	public Boolean isIconsInLetter(ArrayList<String> listSendingIcons) {
		Boolean isPresents = true;
		LabelElement lbIconsInBody;
		for (String iconStringNumber : listSendingIcons) {
			lbIconsInBody = new LabelElement(By.xpath(String.format(xPathEmotionsIconsInBody, iconStringNumber)));
			isPresents = lbIconsInBody.isPresent();
		}
		return isPresents;
	}

	

}
