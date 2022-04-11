package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadPopUp {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		//type = file- Pre - requisite -- We need to ask the developers to provide that
		//Auto IT is one more way (3rd party) but not recommended
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\saran\\OneDrive\\Documents\\Test.bmp");
	}

}
