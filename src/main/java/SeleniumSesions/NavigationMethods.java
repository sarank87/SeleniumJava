package SeleniumSesions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationMethods {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		//CTRL + SHIFT + O to impot all libraries
		WebDriver driver = new ChromeDriver();
		driver.get("https:\\www.google.com");
		System.out.println(driver.getTitle());
		driver.navigate().to("https:\\www.amazon.com");	
		System.out.println(driver.getTitle());
		//Back and Forward button
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();
		System.out.println(driver.getTitle());
		
		//Interview
		//navigate() methods are to(),bakc(),forward(),refresh();
		
		//Interview Question
		//Difference between get() and navigate().to() method
		//Both are same - synonyms
		//navigate().to() internally calls the get() method
		//Both maintains browser history - we can do forward and back
		//Only difference is syntax
		//to() method is overloaded method
//		driver.navigate().to(new URL("https:\\www.amazon.com")); -- This is not synonym with driver.get
		// This is the only difference We can use new URL only in navigate().to() method
		//		System.out.println(driver.getTitle());
		
		
		//Can we use new URL with get() method
		//get method is not overloaded method - we cannot use
		
		driver.quit();
		//RemoteNavigation is implementing Navigation interface
	}
}
