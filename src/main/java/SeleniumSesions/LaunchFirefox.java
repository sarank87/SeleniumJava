package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//How to start Selenium server
		System.setProperty("webdriver.gecko.driver","C:\\Users\\saran\\SeleniumDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		//Launch Server
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		
	}
	
	//Safari do not have any exe driver files - It works only on MAC machines
	//Selenium starts the Selenium Server for Safari  -- We need to Allow Remote Automatiopn
	//Then only it will work

}
