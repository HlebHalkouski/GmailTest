package test.Pages;

import org.openqa.selenium.By;

import webdriver.elements.LabelElement;
import webdriver.utils.Letter;

public class SpamPage extends MainPage {

	public SpamPage(){
		super(By.xpath("//div[@class='ya']"), "Spam Page");
	}

	public boolean isLetterInFolder(String username, Letter letterUser) {
		lbLetter = new LabelElement(By.xpath(String.format(xPathLetter , username, letterUser.getTimeSend())));
		return lbLetter.isPresent();
	}
	
	
}
