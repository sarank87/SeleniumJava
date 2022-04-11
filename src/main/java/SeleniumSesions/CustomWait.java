package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//INTERVIEW QUESTION
		//Valid use case of Thread.sleep
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // Timeoutfor page load is 20secs // Throw exception if page is not loaded withing 20 seconds
//		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.get("https://www.flipkart.com/");
		waitForPageLoad(10);  // perform specific action once page is loaded
		By emailid=By.id("input-email11");
//		retryingElement(emailid,10).sendKeys("test@gmail.com");
		retryingElement(emailid,10,2000).sendKeys("test@gmail.com");
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);		
	}
	
	public static WebElement retryingElement(By locator,int timeOut) {
		WebElement element = null;
		int attempts = 1;
		while(attempts< timeOut) {
			try {
				element = getElement(locator);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found in attempt " + attempts + " for locator " + locator);
				try {
					Thread.sleep(500);  //Default interval time
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Static wait used in dynamic wait
			}
			attempts++;
		}
		
		if(element==null) {
			try {
				throw new Exception("ELEMENT NOT FOUND EXCEPTION");
			}
			catch(Exception e) {
				System.out.println("Element is not found exception tried for " + timeOut + 
						"with intervals of : 500 ms");
			}
		}
		return element;
	}
	
	public static WebElement retryingElement(By locator,int timeOut, int intervalTime) {
		WebElement element = null;
		int attempts = 1;
		while(attempts< timeOut) {
			try {
				element = getElement(locator);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found in attempt " + attempts + " for locator " + locator);
				try {
					Thread.sleep(intervalTime);  //Custom interval time
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Static wait used in dynamic wait
			}
			attempts++;
		}
		
		if(element==null) {
			try {
				throw new Exception("ELEMENT NOT FOUND EXCEPTION");
			}
			catch(Exception e) {
				System.out.println("Element is not found exception tried for " + timeOut + 
						" with intervals of : " + intervalTime + "ms");
			}
		}
		return element;
	}
	
	public static void waitForPageLoad(int timeOut) {
		long endTime = System.currentTimeMillis() + timeOut;
		while(System.currentTimeMillis()<endTime) {			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = js.executeScript("return document.readyState").toString();
			System.out.println(state);
			if(state.equals("complete")) {
				break;
			}
		}
	}
}
