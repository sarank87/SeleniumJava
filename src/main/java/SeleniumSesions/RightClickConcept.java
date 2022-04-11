package SeleniumSesions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//Right Click on specific webelemtn
		//Right click is context click
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickEle = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act = new Actions(driver);
		//There is not right click method in Selenium
		//We have context click 
		act.contextClick(rightClickEle).perform();//context click is overloaded method
	
		//Collect right click options
		List<WebElement> itemList = driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']//span"));
		System.out.println(itemList.size());
		for(WebElement e:itemList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("Copy")) {
				e.click();
				break;
			}
		}
		
		By rightClick = By.xpath("//span[text()='right click me']");
		By rightClickOptions = By.xpath("//ul[@class='context-menu-list context-menu-root']//span");
		getRightClickOptions(rightClick,rightClickOptions,"Copy");
		
		//ASSIGNMENT - Collect categories for each menu in big basket - Big basket
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void getRightClickOptions(By rightClick,By RghtClickOptions,String value) {
		WebElement rightClickEle = getElement(rightClick);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();//context click is overloaded method	
		//Collect right click options
		List<WebElement> itemList = driver.findElements(RghtClickOptions);
		System.out.println(itemList.size());
		for(WebElement e:itemList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public static List<String> getRightClickOptionsList(By rightClick,By RghtClickOptions) {
		WebElement rightClickEle = getElement(rightClick);
//		Actions act = new Actions(driver);
//		act.contextClick(rightClickEle).perform();//context click is overloaded method	
		List<String> rightClickItems = new ArrayList<String>();
		//Collect right click options
		List<WebElement> itemList = driver.findElements(RghtClickOptions);
		System.out.println(itemList.size());
		for(WebElement e:itemList) {
			String text = e.getText();
			System.out.println(text);
			rightClickItems.add(text);
			}
		return rightClickItems;
		}
	
	public static void doContextClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(getElement(locator)).perform();//context click is overloaded method		Actions act = new Actions(driver);
	}

}
