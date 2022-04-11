package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPopup {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		//We pass username and password in the URL
		//Authentication popups are not JS - They are browsers
		//This will not work when username and password contains @
		//CDP - Selenium 4 is the alternate way to handle authentication popups 
		//CDP - Chrome Dev Protocols 
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");		
	}
}
