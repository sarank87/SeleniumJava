package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropDownHandle {
	
	//Single , Multi and All Selection logics

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(3000);
		
		By choices = By.xpath("//span[@class='comboTreeItemTitle']");
		
		selectChoice(choices,"choice 1");//Single Selection
		
		//Multiple Selection
//		selectChoice(choices,"choice 1","choice 2","choice 6 2 2","choice 7");
		
		//Select All selections
		selectChoice(choices,"ALL");
		
		//ASSIGNMENT - Create deselect method - deselect All methods
		
//		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
//	
//		for(WebElement e : choiceList) {
//			String text = e.getText();
//			System.out.println(text);
//			if(text.equals("Choice 1")) {
//				e.click();
//			}
//		}
	}
	
	public static void selectChoice(By locator,String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);
				for(int i = 0;i<value.length;i++) {
					if(text.equals(value[i])) {
						e.click();
						break;
					}
				}
			}
		}
		else {
			//All selection logic
			try {
				for(WebElement e : choiceList) {
					e.click();				
					//Element not interactable error - element is in DOM but not in UI
				}
			}
				catch(ElementNotInteractableException e) {
					System.out.println("All choices are over...");
				}
			}

		}
	}
