package com.timvroom.mpTest;

import java.awt.GraphicsEnvironment;
import java.awt.Robot;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base 
{
	@BeforeSuite
	public void before() {
		
		WebDriverProvider.init();
		
		try {		
			int y = (int)GraphicsEnvironment.getLocalGraphicsEnvironment()
					.getMaximumWindowBounds().getHeight() + 100;
			new Robot().mouseMove(0,y);	
		} catch (Exception e) {
			System.out.println("Exception when moving mouse pointer out of browser window");
			e.printStackTrace();
		}
	}
	
	@AfterSuite
	public void after() {
		WebDriverProvider.get().quit();
	}
}
