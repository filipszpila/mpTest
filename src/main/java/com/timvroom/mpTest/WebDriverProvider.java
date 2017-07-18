package com.timvroom.mpTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverProvider {

	private static WebDriver driver;
	
	public static void init() {
		
		String webBrowser = "chrome";
		
		switch (webBrowser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		
		default:
			break;
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
	
	public static WebDriver get() {
		
		return driver;
	}
	
	public static void quit() {
		
		if(driver != null) {
		
			driver.quit();
			driver = null;
		}
	}
}
