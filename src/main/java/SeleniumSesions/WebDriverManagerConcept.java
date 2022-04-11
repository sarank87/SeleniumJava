package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriverManager is a class
		//3rd party library that will manage all browser drivers
		//We need not manually download driver to our local and set the path using setproperty
		//Specific driver supports specific browsers
		//madrid person - bonigarcia - developed it
		//Supported till Selenium 4.1.0 version
		//All maven dependencies are stored in m2 folder like the executable dependencies
		
		WebDriverManager.chromedriver().setup();
		//We can choose 32 bit or 64 bit also in chromedriver()  method
		//We can work on backward compatible browsers
		WebDriverManager.chromedriver().browserVersion("89.0").setup();// It will setup Chrome v89.0 version
		WebDriver driver = new ChromeDriver();
		driver.get("http:\\www.google.com");
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
