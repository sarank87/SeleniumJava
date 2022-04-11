package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownHandling {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		
//		WebElement country = driver.findElement(By.id("Form_submitForm_Country"));
//		Select select = new Select(country);
//		//select and option tags are available
////		select.selectByIndex(5);	
//		select.selectByVisibleText("India"); // This is text value and not attribute value
////		select.selectByValue("Brazil"); // This is value of value attribute value
//	
//		Thread.sleep(2000);
//		
//		WebElement state = driver.findElement(By.id("Form_submitForm_State"));
//		Select select1 = new Select(state);
//		select1.selectByVisibleText("Goa");
		
		
		//Reusable method
		By country = By.id("Form_submitForm_Country");
		By state = By.id("Form_submitForm_State");
		doSelectByVisibleText(country,"India");
		Thread.sleep(2000);
		doSelectByVisibleText(state,"Goa");
		
		
	}
	
	
	//Preferred
	public static void doSelectByVisibleText(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	//Not preferable - Index might change
	public static void doSelectByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	//Preferred
	public static void doSelectByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

}
