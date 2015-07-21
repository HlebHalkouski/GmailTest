package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.LabelElement;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.elements.interfaces.RadioButton;
import webdriver.elements.interfaces.TextBox;
import webdriver.fieldDecorator.FieldDecorator;

public class SettingPage extends BasePage {
	
	@FindBy(xpath ="//*[@name='sx_sg'][@value='1']")
	private RadioButton rbSelectSignature;
	
	@FindBy(xpath = ".//div[@aria-label='Подпись']")
	private TextBox tbxSignature;
	
	@FindBy(xpath = "//a[contains(text(),'Пересылка и POP/IMAP')]")
	private Label lbForwardSetting;

	@FindBy(xpath = "//button[@guidedhelpid='save_changes_button']")
	private Button btnSaveChanges;
	
	private String xPathDisabledSaveChanges = "//button[@guidedhelpid='save_changes_button'][@disabled]";
	private Label lbDisabledSaveChanges;
	
	public SettingPage() {
		super(By.xpath("//h2[contains(text(),'Настройки')]"), "Setting Page");
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
			lbDisabledSaveChanges = new LabelElement(By.xpath(xPathDisabledSaveChanges));
		}while (lbDisabledSaveChanges.isPresent());
		btnSaveChanges.click();		
	}

	
	
}
