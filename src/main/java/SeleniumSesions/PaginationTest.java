package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class PaginationTest {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(4000);
		
		int pageCount = 1;
		while(true) {
			if(driver.findElements(By.xpath("//td[text()='Ranchi']")).size()>0) {
				selectCity("Bengaluru");
				System.out.println("Page is loaded");
				System.out.println("Page Count is " + pageCount);
				break;
			}
			else {
				//Pagination logic
				WebElement next = driver.findElement(By.linkText("Next"));
				if(next.getAttribute("class").contains("disabled")) {
					System.out.println("Pagination is over ..record is not found");
					//is Enbled might not work - so safer to use this
					break;
				}
				else {
					next.click();
					Thread.sleep(2000);
					pageCount++;
				}
			}
		}
		
	}
	
	public static void selectCity(String cityName) {
		driver.findElement(By.xpath("//td[text()='" + cityName + "']//preceding-sibling::td/child::input[@type='checkbox']"))
		.click();
	}
	
	public static void selectCity1(String cityName) {
		WebElement ele = driver.findElement(By.xpath("//td[text()='" + cityName + "']"));
		driver.findElement(with(By.xpath("//input[@type='checkbox']")).toLeftOf(ele)).click();
	}
		
	

}
