package SeleniumSesions;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver; //Default value is null
	
	/**
	 * This method is used to initialise the driver
	 * @param browserName
	 * @return WebDriver
	 */
	
	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser name is " + browserName);
		if(browserName.equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\saran\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\saran\\SeleniumDrivers\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Please pass the correct browser name " + browserName);
		}
		return driver;
	}
	
	public void launchURL(String url) {
		if(url==null) {
			System.out.println("Please pass the correct url");
			return;
		}
		if(url.contains("https")||url.contains("http")) {
			System.out.println("Please pass the correct url");
			driver.get(url);
		}
		else {
			driver.close();	
			try {
				throw new Exception("InvalidURLException");
			}
			catch(Exception e){
				System.out.println("Please pass correct url http/https");			
			}
		}
	}
	
	//Overloaded method
	public void launchURL(URL url) {
		driver.navigate().to(url);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageURL() {
		return driver.getCurrentUrl();
	}
	
	public void closeBrowser() {
		driver.close();
	}
}
