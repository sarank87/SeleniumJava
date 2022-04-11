package SeleniumSesions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsAlertPopup {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//We can give alert('This is my script') in Console tab on browser to replicate alers
		//prompt('Enter amounbt') to replicate prompt to enter amount - Ok and Cancel options available
//		https://mail.rediff.com/cgi-bin/login.cgi
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		
		//We will get NoAlertPresentException in below LOC if there is no alert present		
		//Alert only works for Javascript popups
		Alert alert = driver.switchTo().alert(); //Alert is interface
		
		String text = alert.getText();
		System.out.println(text);
//		alert.sendKeys("testing"); //For popups
		alert.accept(); //Clicks on Ok button it can be any button like Yes Cancel etc
//		alert.dismiss();//Clicks on Cancel button - Clicks on Escape button
		
		//ASSIGNMENT - Herokuapp 
	}

}
