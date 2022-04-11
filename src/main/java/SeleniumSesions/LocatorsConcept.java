package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsConcept {
	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CTRL + SHIFT +O
		WebDriverManager.chromedriver().setup();
	
		driver = new ChromeDriver();
	
		
		//demo.open cart .com
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		//DOM
		// Right Click and Inspect
		//tag   attributes and attribute values
		//For all links html tags is a
	
		//Use findElement method
		//By is a class
		//sendkeys used to enter text in webelement
		//WebElement + perform acions (click,sendkeys , isDisplayed,getText)
		//Locators
		//1.ID locator
		//id is static method of By class
//		driver.findElement(By.id("input-email")).sendKeys("saran@gmail.com");
//		driver.findElement(By.id("input-password")).sendKeys("test@123");
		
//		Other way  - More reusability - We need not create webelements again and again
//		WebElement emailId = driver.findElement(By.id("input-email"));
//		WebElement password = driver.findElement(By.id("input-password"));
//		emailID.sendKeys("saran@gmail.com");
//		password.sendKeys("test@123");
		
		// 3rd way -- By locators -- We are maintaining OR --We are not interacting with Selenium servers unecessarily
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		To interact with Selenium server we have to use driver.findelement
//		WebElement email = driver.findElement(emailId);
//		WebElement pwd = driver.findElement(password);
//		email.sendKeys("saran@gmail.com");
//		pwd.sendKeys("test@123");
		
		//4th way - By locator with generic functions
		//Code reusabiloity
		//Only once we have to write driver.findElement
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		getElement(emailId).sendKeys("test@gmail.com");
//		getElement(password).sendKeys("test@123");
		
		//5th  approach - create by locator using generic method
		//generic methods for actions
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		doSendKeys(emailId,"test@gmail.com");
//		doSendKeys(password,"test@123");
	
		//6th approach - By locators and generic functions in ElementUtils class
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(emailId, "test@gmail.com");
//		eleUtil.doSendKeys(password, "test@123");
		
		//7th approach - String locators - By locators
		
		String email_id = "input-email";
		String password = "input-password";
		ElementUtil eleUtil = new ElementUtil(driver);
		By email = eleUtil.getBy("id",email_id);
		By pwd = eleUtil.getBy("id",password);

		eleUtil.doSendKeys(email, "test@gmail.com");
		eleUtil.doSendKeys(pwd, "test@123");
	}
	
//	public static By getBy(String locatorType,String locatorValue) {
//		By locator = null;
//		switch (locatorType.toLowerCase()) {
//		case "id":
//			locator = By.id(locatorValue);
//			break;
//
//		default:
//			break;
//		}
//		
//		return locator;
//	}
	
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//	}
//	
//	public static void doSendKeys(By locator,String value) {
//		getElement(locator).sendKeys(value);
//	}

}
