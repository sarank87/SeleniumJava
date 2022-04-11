package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	
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
	
		By emailid = By.id("input-email"); //org.openqa.selenium.TimeoutException and  org.openqa.selenium.NoSuchElementException
		
		//org.openqa.selenium.TimeoutException--> By.id: input-email11 (tried for 10 second(s) with 500 milliseconds interval
		//500 millisweconds is the pooling time
		By password = By.id("input-password");
		By loginBtn = By.xpath("\\input[@value='Login']");
		
		//Top Casting
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class);
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(emailid)).sendKeys("tom@gmail.com");
		waitForElementPresentWithFluentWait(emailid,10,2).sendKeys("tom@gmail.com");
		
		//Using WebDriver wait we can do everything that fluent wait does -- there is no difference actually
		//There is no individual methods in WebDriverWait class
		//Refer official java Selenium code
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2));
		wait.ignoring(NoSuchElementException.class);
	}

	public static WebElement waitForElementPresentWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class,ElementNotInteractableException.class);//Max 2 eceptions we can ignore
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static WebElement waitForElementVisibilityWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
