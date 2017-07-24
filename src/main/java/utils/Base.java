package utils;

import java.awt.GraphicsEnvironment;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	protected WebDriver driver;
	
	public void setUp() {
		
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
		
		try {		
			int y = (int)GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getMaximumWindowBounds().getHeight() + 100;
			new Robot().mouseMove(0,y);	
		} catch (Exception e) {
			System.out.println("Exception when moving mouse pointer out of browser window");
			e.printStackTrace();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
}
