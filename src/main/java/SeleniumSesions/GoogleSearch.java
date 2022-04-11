package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Naveen Automation Lab");
		Thread.sleep(3000);
		List<WebElement> suggestionList =
		driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']//span"));
		for(WebElement e: suggestionList) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains("interview questions")){
				e.click();
				break;
			}
					
		}
	}
	//Assignment = Do same thing in automationpractise.com
}
