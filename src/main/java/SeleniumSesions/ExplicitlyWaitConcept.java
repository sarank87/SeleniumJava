package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitlyWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Explicit Wait can be for specific webelements
		//WebDriverWait and Fluent Wait
		
		//Types of Wait in Selenium 
		//1. Implicitly Wait - Global Wait
		//2. Explicitly Wait - for a specific element , custom wait
		//    a. WebDriver Wait
		//    b. Fluent Wait
		
		//IMP
		//WebDriver Wait (Class) is extending the Fluent Wait (Class) implements Wait (Interface)
		//So WebDriverWait is also FluentWait because its child of FluentWait class
		//Wait interface is having method - until method
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.tips/index.php?route=account/login");
	
		By emailid = By.id("input-email11"); //org.openqa.selenium.TimeoutException and  org.openqa.selenium.NoSuchElementException
		
		//org.openqa.selenium.TimeoutException--> By.id: input-email11 (tried for 10 second(s) with 500 milliseconds interval
		//500 millisweconds is the pooling time
		By password = By.id("input-password");
		By loginBtn = By.xpath("\\input[@value='Login']");
		
//		waitForElementrPresent(emailid,10).sendKeys("test@gmail.com");//Explicit Wait
		waitForElementVisible(emailid,10).sendKeys("test@gmail.com");//Explicit Wait
		getElement(password).sendKeys("test@123");
		getElement(loginBtn).click();
	
		//Explicit Wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//Duration is Selenium 4 feature
//		//Create WebElement with explicit wait concept
//		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailid));
//		ele.sendKeys("test@gmail.com");
//		driver.findElement(password).sendKeys("test@123");
//		driver.findElement(loginBtn).click();
	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	//Selenium is looking for WebElement in DOM but it might not be visible on page
	
	public static WebElement waitForElementrPresent(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));//Duration is Selenium 4 feature
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility 
	 * means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public static WebElement waitForElementVisible(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));//Duration is Selenium 4 feature
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
