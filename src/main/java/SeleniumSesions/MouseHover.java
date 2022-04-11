package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		
		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();
		driver.get("http://mrbool.com/");
		
		WebElement contentEle = driver.findElement(By.className("menulink"));
		Actions act = new Actions(driver); //Actions we pass driver In Select we pass webelement
		act.moveToElement(contentEle).perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("COURSES")).click(); //COURSES is displayed in UI while DOM has Courses
		//We have to use COURSES - whatever is displayed on UI
//		driver.findElement(By.linkText("Courses")).click();//NoSuchElementException
		
		//ASSIGNMENT - Spicejet - Click on Add Ons
		//Bigbasket  - Bakery- Bread- Items- Level 3 sub menu - We have to do 2 mouse hovers
	
		By contentFile = By.className("menulink");
		By courses = By.linkText("COURSES");
		selectSubMenu(contentFile, courses);
		
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void selectSubMenu(By parentMenu,By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	public static void selectSubMenul3(By parentMenu,By childMenu,By subChildMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();
	}
	
	public static void selectSubMenul4(By parentMenu,By childMenu1,By subChildMenu2,By subChildMenu3) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(subChildMenu2)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu3).click();
	}
	
	
}
