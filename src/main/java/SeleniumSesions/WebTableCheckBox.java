package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableCheckBox {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		Thread.sleep(3000);

////a[contains(text(),'Joe.Root')]/parent::td/preceding-sibling::td/child::input[@type='checkbox']
		selectUserName("Joe.Root");
		selectUserName("John.Smith");
	}
	
	public static void selectUserName(String userName) {
		driver.findElement(By.xpath("//a[contains(text(),'"+userName+"')]/parent::td/preceding-sibling::td/child::input[@type='checkbox']")).click();
	}
}
