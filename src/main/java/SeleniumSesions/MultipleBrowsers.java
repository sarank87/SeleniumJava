package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//IllegalStateException error if we font give the driver path
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https:\\www.google.com");
		
		String parentWindowID = driver.getWindowHandle();
		
		//Switching the domain
		
//		WebDriver driver1 = new ChromeDriver();
//		driver1.get("https:\\www.amazon.com");
//		driver1.close();
		
		//.to is not used for different domain navigations
		driver.navigate().to("https:\\www.amazon.com");//Move from one page to another page within same domain or webapp - Recommended
		
		//Use same driver - open a new tab
		//New feature in Selenium 4
		//W3C compliant
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https:\\www.amazon.com");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
