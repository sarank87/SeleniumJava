package SeleniumSesions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitFoElementsConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		//FreshWorks.com
		driver.get("https://www.freshworks.com/");
//		List<WebElement> footerList = driver.findElements(By.xpath("//ul[@class='footer-nav']//a"));
		By footerList = By.xpath("//ul[@class='footer-nav']//a");
		printAllElements(footerList,10);
		
		if(getElementsTextListWithWait(footerList,10).contains("Contact us")) {
			System.out.println("Contact Us is present");
		}

	}	
	
	public static void printAllElements(By locator,int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator,10);
		for(WebElement e: eleList) {
			System.out.println(e.getText());
		}
	}
	
	public static List<String> getElementsTextListWithWait(By locator,int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator,10);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}
	
	public static List<WebElement>  waitForElementsToBeVisible(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));		
	}
}

