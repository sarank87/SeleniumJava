package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDOMElementHandle {

	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Shadow DOM is inside the main DOM
		//#shadow-root open -- We can automate
		//#shadow-root close -- We cannot automate
		//Shadow DOM provides security in comparision to iframes like registration forgot password etc
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		Thread.sleep(5000);
//		driver.findElement(By.id("tea")).sendKeys("masala tea");
		//Shadow DOM is available inside iframe
		//Browser - Page -- iframe -- shadowDOM -- input
		// JS - document.querySelector("#snacktime").shadowRoot.querySelector("#tea")
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement tea = (WebElement)js.executeScript("document.querySelector('#snacktime').shadowRoot.querySelector('#tea')");
		tea.sendKeys("masala tea");
	}

}
