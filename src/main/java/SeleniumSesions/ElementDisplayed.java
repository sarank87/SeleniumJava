package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementDisplayed {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");	
		ElementUtil eleUtil = new ElementUtil(driver);
		
		//IsDisplayed
		By emailID = By.id("input-email");
//		boolean flag = driver.findElement(emailID).isDisplayed();
//		System.out.println(flag);
		
		//No Such Element found exception - when findelement is not able to find element
		//ElementNotFoundException - Its not a Selenium exception
		if(eleUtil.doIsDisplayed(emailID)) {
			eleUtil.doSendKeys(emailID, "test@gmail.com");
		}
		
		//IsEnabled
		boolean flag = driver.findElement(emailID).isEnabled();
		System.out.println(flag);
		
	}

}
