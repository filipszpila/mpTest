package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.Base;
import utils.Methods;

public class BaseTest extends Base{
	
	MainPage mainPage;
	
	//BEFORE-----------------------------------------------
	@BeforeSuite
	public void before() {
		
		super.setUp();
		mainPage = new MainPage(driver);
	}
	
	//TESTS------------------------------------------------
	
	@Test(priority=0,description="Launch timvroom.com")
	public void launchSite() {
		
		driver.get("http://timvroom.com/selenium/playground/");
	}
	
	@Test(priority=1,description="Task 1")
	public void getAndPasteTitle() {
		
		Methods.insertIntoField(mainPage.answer1, driver.getTitle());
	}
	
	@Test(priority=2,description="Task 2")
	public void fillNameSection() {
		
		Methods.insertIntoField(mainPage.nameTextBox, "Kilgore Trout");
	}
	
	@Test(priority=3,description="Task 3")
	public void selectOccupation() {
		
		Methods.chooseFromSelectBox(mainPage.selectbox, "Science Fiction Author");
	}
	
	@Test(priority=4,description="Task 4")
	public void countBlueBoxes() {
		
		int i = mainPage.blueBoxes.size();
		Methods.insertIntoField(mainPage.answer4, Integer.toString(i));
	}
	
	@Test(priority=5,description="Task 5")
	public void clickLink() {
		
		mainPage.clickMe.click();
	}
	
	@Test(priority=6,description="Task 6")
	public void extractClassName() {
		
		Methods.insertIntoField(mainPage.answer6, mainPage.redBox.getAttribute("class"));
	}
	
	@Test(priority=7,description="Task 7")
	public void runJSFunc1() {
		
		((JavascriptExecutor)driver).executeScript("ran_this_js_function();");
	}
	
	@Test(priority=8,description="Task 8")
	public void runJSFunc2() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Object o = js.executeScript("return got_return_from_js_function();");
		Methods.insertIntoField(mainPage.answer8, o.toString());
	}
	
	@Test(priority=9,description="Task 9")
	public void clickWroteBook() { 
		mainPage.wroteBook.click();
	}
	
	@Test(priority=10,description="Task 10")
	public void getRedTextAndPaste() { 
		Methods.insertIntoField(mainPage.answer10, mainPage.redBox.getText());
	}
	
	@Test(priority=11,description="Task 11")
	public void whichBoxOnTop() { 
		int yOrange = mainPage.orangeBox.getLocation().y;
		int yGreen = mainPage.greenBox.getLocation().y;
		
		String color;
		
		if (yOrange < yGreen) {
			color = "orange";
		} else {
			color = "green";
		}
		
		Methods.insertIntoField(mainPage.answer11, color);
	}
	
	@Test(priority=12,description="Task 12")
	public void setBrowserWidthAndHeight() {
		
		driver.manage().window().setPosition(new Point(0,0));
		driver.manage().window().setSize(new Dimension(850,650));
	}
	
	@Test(priority=13,description="Task 13")
	public void checkIfElementExists() {
		String s;
		
		if (!driver.findElements(By.id("ishere")).isEmpty()) {
			s="yes";
		} else {
			s="no";
		}
		
		Methods.insertIntoField(mainPage.answer13, s);
	}
	
	@Test(priority=14,description="Task 14")
	public void checkElementVisibility() {
		String s;
		
		if (driver.findElement(By.id("purplebox")).isDisplayed()) {
			s="yes";
		} else {
			s="no";
		}
		
		Methods.insertIntoField(mainPage.answer14, s);
	}
	
	@Test(priority=15,description="Task 15")
	public void waitingGame() {
		mainPage.clickThenWait.click();
		WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.linkText("click after wait")));
		myDynamicElement.click();
	}
	
	@Test(priority=16,description="Task 16")
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	@Test(priority=17,description="Task 17")
	public void confirmationClick() {
		mainPage.submit.click();
		mainPage.checkResults.click();
	}
	
	//AFTER------------------------------------------------
	@AfterMethod
	public void appendFinalHTMLReport(ITestResult result){
	    if(result.getStatus() == ITestResult.FAILURE) {
			driver.quit();
	    }
	}
	
	@AfterSuite
	public void after() throws InterruptedException {
		if(driver != null) {
			driver.quit();
		}
	}
}
