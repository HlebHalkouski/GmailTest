package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.elements.interfaces.RadioButton;
import webdriver.elements.interfaces.TextBox;
import webdriver.fieldDecorator.FieldDecorator;
import webdriver.utils.Letter;

public class SettingPage extends BasePage {
	
	@FindBy(xpath ="//*[@name='sx_sg'][@value='1']")
	private RadioButton rbSelectSignature;
	
	@FindBy(xpath = ".//div[@aria-label='Подпись']")
	private TextBox tbxSignature;
	
	@FindBy(xpath = "//a[contains(text(),'Пересылка и POP/IMAP')]")
	private Label lbForwardSetting;

	@FindBy(xpath = "//button[@guidedhelpid='save_changes_button']")
	private Button btnSaveChanges;
	
	@FindBy(xpath = "//label[contains(text(), 'Включить автоответчик')]/ancestor::td/preceding-sibling::td/input")
	private RadioButton rbSelectResponderOn;
	
	@FindBy(xpath = "//label[contains(text(), 'Отключить автоответчик')]/ancestor::td/preceding-sibling::td/input")
	private RadioButton rbSelectResponderOff;
	
	@FindBy(xpath = "//input[@aria-label='Тема']")
	private TextBox tbxThemeResponder;
	
	@FindBy(xpath = "//div[@aria-label='Автоответчик']")
	private TextBox tbxBodyResponder;
	
	private final String xPathDisabledSaveChanges = "//button[@guidedhelpid='save_changes_button'][@disabled]";
	@FindBy(xpath = xPathDisabledSaveChanges)
	private Label lbDisabledSaveChanges;
	
	public SettingPage() {
		super(By.xpath("//h2[contains(text(),'Настройки')]"), "Setting");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);	
	}

	public void enterForwardSetting() {
		lbForwardSetting.click();
	}

	public void enterSignature(String signature) {
		rbSelectSignature.click();
		tbxSignature.clearAndType(signature);
	}

	public void saveSettingsChange() {
		do{
		}while (lbDisabledSaveChanges.isPresent(By.xpath(xPathDisabledSaveChanges)));
		btnSaveChanges.click();		
	}

	public void vacationResponderOn(Letter letterResponder) {
		rbSelectResponderOn.click();		
		tbxThemeResponder.clearAndType(letterResponder.getTheme());
		tbxBodyResponder.clearAndType(letterResponder.getBody());
		saveSettingsChange();
	}

	public void vacationResponderOff() {
		rbSelectResponderOff.click();
		saveSettingsChange();
	}
	
	
}
