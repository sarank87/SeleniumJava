package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlertConcept {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Page Load is getting deprecated

		//INTERVIEW - Why we are not using implicitly wait 
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
//		driver.switchTo().alert(); //org.openqa.selenium.NoAlertPresentException
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent()); // No need of SwitchTo - Until has started returning alerts and not Webelements
		System.out.println(alert.getText());
		alert.accept();
		
		//This is NA in Implicit Wait
		
		
		// In Cypress and Playwright inbuilt wait is available
		//We need not create wait explicitly in Cypress and Playwright 
		//Selenium does not provide auto mechanism of waits
	}

	public static Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent()); // No need of SwitchTo - Until has started returning alerts and not Webelements
	}
	
	public static void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public static void getAlertText(int timeOut) {
		waitForAlert(timeOut).getText();
	}
}
