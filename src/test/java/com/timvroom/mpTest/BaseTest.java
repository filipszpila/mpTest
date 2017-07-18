package com.timvroom.mpTest;

import org.testng.annotations.Test;

public class BaseTest extends Base {
	
	@Test(description="Launch timvroom.com")
	public void launchSite() {
		
		WebDriverProvider.get().get("http://timvroom.com/selenium/playground/");
	}
	
	@Test(description="Task 1")
	public void grabAndPastePageTitle() {
		
	}
}
