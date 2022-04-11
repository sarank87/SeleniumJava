package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BrowserUtil brUtil = new BrowserUtil();
		WebDriver driver = brUtil.launchBrowser("chrome"); // Multiple references can point to same object
		brUtil.launchURL("https://demo.opencart.com/index.php?route=account/login");
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(driver.getCurrentUrl());
		
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		ElementUtil eleUtil = new ElementUtil(driver);
		eleUtil.doSendKeys(emailId, "test@gmail.com");
		eleUtil.doSendKeys(password, "test@123");
		
		brUtil.closeBrowser();
	}
}
