package test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import webdriver.BasePage;
import webdriver.elements.LabelElement;
import webdriver.elements.interfaces.Button;
import webdriver.elements.interfaces.Label;
import webdriver.fieldDecorator.FieldDecorator;

public class ThemePage extends BasePage{


	@FindBy(xpath = "//div[contains(text(),'Мои фото')]")
	private Button btnMyPhoto;
	
	@FindBy(xpath = "//div[contains(text(),'Загрузка фото')]")
	private Button btnUploadPhoto;
	
	@FindBy(xpath = "//div[contains(text(),'Выберите файл на компьютере')]")
	private Button btnChooseFile;
	
	private final static String xPathFrameChangeThemeLocator = "//iframe[@class='KA-JQ']";
	@FindBy(xpath = xPathFrameChangeThemeLocator) 
	private Label frameChangeThemeLocator; 

	private final static String xPathUploadError = "//div[contains(text(),'Формат выбранного файла')]";
	private Label lbUploadError;
	
	
	public ThemePage() {
		super(By.xpath("//div[@class='Kj-JD a8j']"), "Theme Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);
	}
	
	public ThemePage(By frameChangeThemeLocator) {
		super(frameChangeThemeLocator, "Theme Page");
		PageFactory.initElements(new FieldDecorator(browser.getWebDriver()), this);	
	}

	public void enterUploadTheme() {
		btnMyPhoto.click();
		browser.getWebDriver().switchTo().frame(frameChangeThemeLocator.getElement());
		btnUploadPhoto.click();
		btnChooseFile.click();
	}


	public Boolean isAlertWrongFilePresent() {
		browser.getWebDriver().switchTo().frame(frameChangeThemeLocator.getElement());
		lbUploadError = new LabelElement(By.xpath(xPathUploadError));
		return lbUploadError != null;
	}

	public static By getFrameChangeThemeLocator() {
		return By.xpath(xPathUploadError);
	}
}
