package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Methods {
	
	public static void insertIntoField(WebElement e, String s) {
		e.sendKeys(s);
	}
	
	public static void chooseFromSelectBox(WebElement selectbox, String string) {
		Select select = new Select(selectbox);
		select.selectByVisibleText(string);
	}
}
