package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage {
	
	//Locators------------------------
	
	@FindBy(id="answer1")
	public WebElement answer1;
	
	@FindBy(id="answer4")
	public WebElement answer4;
	
	@FindBy(id="answer6")
	public WebElement answer6;
	
	@FindBy(id="answer8")
	public WebElement answer8;
	
	@FindBy(id="answer10")
	public WebElement answer10;
	
	@FindBy(id="answer11")
	public WebElement answer11;
	
	@FindBy(id="answer13")
	public WebElement answer13;
	
	@FindBy(id="answer14")
	public WebElement answer14;
	
	@FindBy(xpath="//span[contains(@style,'background:#00f')]")
	public List<WebElement> blueBoxes;
	
	@FindBy(id="checkresults")
	public WebElement checkResults;
	
	@FindBy(linkText="click me")
	public WebElement clickMe;
	
	@FindBy(linkText="click then wait")
	public WebElement clickThenWait;
	
	@FindBy(id="greenbox")
	public WebElement greenBox;
	
	@FindBy(id="name")
	public WebElement nameTextBox;
	
	@FindBy(id="orangebox")
	public WebElement orangeBox;
	
	@FindBy(id="redbox")
	public WebElement redBox;
	
	@FindBy(id="occupation")
	public WebElement selectbox;
	
	@FindBy(id="submitbutton")
	public WebElement submit;
	
	@FindBy(name="wrotebook")
	public WebElement wroteBook;
	
	//Constructor---------------------
	
	public MainPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
