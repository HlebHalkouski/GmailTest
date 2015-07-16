package test.Pages;

import java.util.GregorianCalendar;
import java.util.Set;

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

public class ForwardPage extends BasePage {

	private static final String FORWARDING_NOREPLY_GOOGLE_COM = "forwarding-noreply@google.com";
	private static final String URL_FORWARD_PAGE = "https://mail.google.com/mail/u/0/#settings/fwdandpop";
		
	@FindBy(xpath = "//input[@act='add']")
	private Button btnAddForward;
	
	@FindBy(xpath = "//div[@class='PN']/input")
	private TextBox txbForwardEmail;
	
	@FindBy(xpath = "//button[@name='next']")
	private Button btnForwardNext;
	
	@FindBy(xpath = "//button[@name='ok']")
	private Button btnForwardOk;
	
	@FindBy(xpath = "//input[@value='Продолжить']")
	private Button btnConfirmAdress;
	
	@FindBy(xpath = "//span[contains(text(),'Пересылать копии входящих сообщений на адреса')]/../preceding-sibling::td/input")
	private RadioButton rbForwardCopy;
	
	@FindBy(xpath = ".//button[@guidedhelpid='save_changes_button']")
	private Button btnSaveChanges;
	
	@FindBy(xpath = "//span[@act='filter']")
	private Label lbFilter;
	
	@FindBy(xpath = "//label[contains(text(),'От')]/../following-sibling::span/input")
	private TextBox txbFilterFrom;
		
	@FindBy(xpath = "//label[contains(text(),'Есть прикрепленные файлы')]/preceding-sibling::input")
	private Label lbCheckBoxFile;
		
	@FindBy(xpath = "//label[contains(text(),'Удалить')]/preceding-sibling::input")
	private Label lbCheckBoxDeleteIt;
		
	@FindBy(xpath = "//div[contains(text(),'Создать фильтр в соответствии с этим запросом')]")
	private Label lbCreateNextFilter;
	
	@FindBy(xpath = "//label[contains(text(),'Всегда помечать как важное')]/preceding-sibling::input")
	private Label lbCheckBoxMarkImporpant;
	
	@FindBy(xpath = "//div[contains(text(),'Создать фильтр')]")
	private Button btnCreateFilter;
	
	private final String xPathAlertFilterCreate = "//span[contains(text(),'Фильтр создан')]";
	@FindBy(xpath = xPathAlertFilterCreate)
	private Label lbAlertFilterCreate;
	
	@FindBy(xpath = ".//option[contains(text(),'(используется)')]/..")
	private Label lbSelectForward;
	
	@FindBy(xpath = ".//option[contains(text(),'Удалить')]")
	private Label lbDeleteOptionForward;
	
	private final String xPathAlertFilterDelete = "//span[contains(text(),'Адрес пересылки')]";
	@FindBy(xpath = xPathAlertFilterDelete)
	private Label lbAlertFilterDelete;
	
	@FindBy(xpath = "//span[@class='e kK7Ibd']")
	private Label lbForwardSetting;
	
	private final String xPathAlertLoading = "//*[contains(text(),'Загрузка')]";
	@FindBy(xpath = xPathAlertLoading)
	private Label lbLoading;
	

	
	public ForwardPage() {
		super(By.xpath(".//span[contains(text(), 'Пересылка')]"), "ForwardPage");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	}

	public Letter addForwardUser(String username3) {
		btnAddForward.click();
		txbForwardEmail.type(username3);
		String windowHandle = browser.getWebDriver().getWindowHandle();
		
		btnForwardNext.click();
		
		Set<String> Handles = browser.getWebDriver().getWindowHandles();
		for(String newHandle : Handles)
			if(!newHandle.equals(windowHandle))
				browser.getWebDriver().switchTo().window(newHandle);
				
		btnConfirmAdress.click();
		
		browser.getWebDriver().switchTo().window(windowHandle);
		btnForwardOk.click();
		
		return new Letter(GregorianCalendar.getInstance(), FORWARDING_NOREPLY_GOOGLE_COM);
	}

	public static String getUrlPage() {
		return URL_FORWARD_PAGE;
	}

	public void chooseRadioForwardCopy() {
		rbForwardCopy.click();
		btnSaveChanges.click();
		lbForwardSetting.click();
	}

	public void enterFilter() {
		lbFilter.click();		
	}

	public void setFilterSettings(String username) {
		boolean visible;
		txbFilterFrom.type(username);
		lbCheckBoxFile.click();
		lbCreateNextFilter.click();
		
		do{
			visible = lbLoading.isPresent(By.xpath(xPathAlertLoading));
		}while(visible);
		lbCheckBoxDeleteIt.click();
		lbCheckBoxMarkImporpant.click();
		btnCreateFilter.click();
		lbAlertFilterCreate.waitForIsElementPresent(By.xpath(xPathAlertFilterCreate));
	}

	public void deleteForward() {
		lbSelectForward.click();
		lbDeleteOptionForward.click();//TODO
		lbDeleteOptionForward.click();
		btnForwardOk.click();
		lbAlertFilterDelete.waitForIsElementPresent(By.xpath(xPathAlertFilterDelete));
	}

	
}
