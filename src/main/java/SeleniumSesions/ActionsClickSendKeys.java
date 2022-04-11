package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClickSendKeys {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		By emailID = By.id("input-email");
		By password = By.id("input-password");
		By loginBtn = By.xpath("//input[@value = 'Login']");
	
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(emailID),"Test@gmail.com").perform();
		act.sendKeys(driver.findElement(password),"Test@123").perform();
		act.click(driver.findElement(loginBtn)).perform();
		
		//ElementNotInteractableException - We use action class to enter text on webelement of 
		//click on Webelement
		
		//Actions click - moves to moiddle of Selenium webelement click on it
		//Actions sendkeys - moves Selenium to WebElkement and enters text
		//There is no chance of element overlapping and we will not get ElementNotInteractableException exception
		//Simple click do not click on middle of webelement
		
		}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public static void doActionsSendkeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}
}
