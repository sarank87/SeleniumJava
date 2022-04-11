package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitlyWaitConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Script need to wait fo app to load , elements to be visible etc
		// Thrwad.Sleep is static wait and is not good
		
//		Static wait
		Thread.sleep(10000); //10secs but is element is avaiable in 2 secs then we are logging 8 secs
		
		
		//Dynamic Wait
		//Implicit wait
		//Global wait 
		//Applicable for all elements
		//applied for default
		//timeout = 10 secs --> 2 secs --> 8 secs ignored
				
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.tips/index.php?route=account/login");
		
		driver.findElement(By.id("input-email11")).sendKeys("test@gmail.com");
		//Waits for 10 secs before throwing the erro
		driver.findElement(By.id("input-password")).sendKeys("test@1234");
		
		
		//We can override implicit wait
		//Home Page elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Click on logout
		//user in login
		//timeout is 5secs but we need 10 seconds
		//Again we have to override
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Navigate to Registration page
		//slow page - needs 15 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//handle elements e 9 , e10
		//Go to Home page
		//Again we have to override waits
		//Repeatedly call waits and override the wait time
		
		//Product page - npo wait needed
		//Apply no wait
		//Nullify implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		//All elements wait time will be 0 secs
	
		//Need mechanism where we can wait for specific time at webelement level
		//implicit wait works only for webelements
		//implicit wait does not work for non-webelements like alerts , URL , title
		// We avoid implicit wait in framework design - Selenium advises not use implicit wait
		
		//Explicit wait available in form of Webdriver wait and fluent wai
		
		
		
	}

}
