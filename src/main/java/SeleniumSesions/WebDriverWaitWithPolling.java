package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitWithPolling {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.tips/index.php?route=account/login");
		
		By emailid = By.id("input-email1"); 
		By password = By.id("input-password");
		By loginBtn = By.xpath("\\input[@value='Login']");
		
		//IMP INTERVIEW QUESTION
		//Default polling time is 500 milliseconds or 0.5 seconds
		waitForElementrPresent(emailid, 10, 2000);//5 iterations since polling time is 2 seconds
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * * @param pollingTime
	 * @return
	 */
	
	//Selenium is looking for WebElement in DOM but it might not be visible on page
	
	public static WebElement waitForElementrPresent(By locator,int timeout , int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility 
	 * means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeout
	 * @return
	 */

	public static WebElement waitForElementVisible(By locator,int timeout,int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}
