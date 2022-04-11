package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElementandFindElementsException {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		// FreshWorks.com
		driver.get("https://www.freshworks.com/");
//		driver.findElement(By.linkText("Customer1111"));//No Such Element exception
		
		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav11']//a"));
		System.out.println(footerList.size()); //0 -- returns empty list if no matching element is returned
	
		if(footerList.size()>0) {
			//perform action
			System.out.println("Footers are present on page");
			for(WebElement e : footerList) {
				String text = e.getText();
				System.out.println(text);
			}
		}
		
		//WebElement i present on screen - alternative to Is Displayed method
		if(driver.findElements(By.linkText("Customers")).size() > 0) {
			System.out.println("Customer link is present on the screen");
		}
		
		//InvalidSelector Exception - When we pass invalid xpaths - invalid xpath syntax is passed
		//NoSuchElement Exception - by driver.findByElement
		//IllegalStateException - when we dont give setporperty for WebDriver
		//ElementNotInteractableException
		//StaleElementException
		//ElementNotFoundException - We dont have in Selenium 
		//NoSuchSessionException - driver.quit and close
		//TimeOutException - Waits
		//NoAlertException
		//NpFrameException
		//NoWindowException
		
		boolean flag = driver.findElement(By.linkText("Customer1111")).isDisplayed();
		System.out.println(flag);//No SuchElementException is displayed and not false
	}
}
