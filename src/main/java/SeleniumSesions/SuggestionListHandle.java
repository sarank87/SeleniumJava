package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionListHandle {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Directly click on SuggestionList element
		//ul - Unordered List
		//ol - Ordered List
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com");
		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[@class='ac_results']//li[contains(text(),'Casual Dresses > Printed')]"))
		.click();
		
	}
	
	//Assignment - Do the same thing in google .com using single element
	//Assignment - In automationpractise - retrieve it using list and for loops as we did in google.com
	// for loop is always preferred
	//return list of suggestions list<String> and print it in console - It will take input the search query
}
