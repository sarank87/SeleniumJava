package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabHandle {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https:www.amazon.com");
		String parentWindowID = driver.getWindowHandle();//returns specific window ID
		System.out.println(driver.getTitle());
		//New feature added
		driver.switchTo().newWindow(WindowType.WINDOW); //SELENIUM 4 METHOD
		driver.get("https:www.google.com");
		//driver is in google now
		System.out.println(driver.getTitle());
		driver.close(); //Close child window
		
		
		//back to parent window
		driver.switchTo().window(parentWindowID);
		System.out.println(driver.getTitle());//NoSuchWindowException because driver is closed
		
	}

}
