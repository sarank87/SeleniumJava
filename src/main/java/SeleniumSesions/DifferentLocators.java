package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DifferentLocators {

	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		//1 id is always unique and should  be unique - 1st recommendation
		//2Name locator -- 2nd recommendation
//		driver.findElement(By.name("email")).sendKeys("test@gmail.com");
		
		ElementUtil eleUtil = new ElementUtil(driver);
//	
//		By emailID = By.name("email");
//		eleUtil.doSendKeys(emailID, "test@gmail.com");
		
		//3. className  --Not recommendated
//		By ele = By.className("form-control");
//		driver.findElement(ele).sendKeys("Test@gmail.com");
//		
		
		//4 . xpath - Not an attribute -- 3rd Recommended
		//address of element in HTML DOM
//		driver.findElement(By.xpath("//*[@id='input-email']")).sendKeys("test@123");
//		
//		By LoginBtn = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
//		eleUtil.doClick(LoginBtn);
		
		//5. CSS selectors  --3rd Recommended
//		driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
//		driver.findElement(By.cssSelector("#input-password")).sendKeys("test@123");
		
		
		//6. Link texts only for links
		// a tag
		
//		By RegisterLink = By.linkText("Register");
//		eleUtil.doClick(RegisterLink);
		//We can also use xpaths for links
		
		//7. Partial Link Text
		//Only for links
//		By ForgottenPassword = By.partialLinkText("Forgotten");
//		eleUtil.doClick(ForgottenPassword);
		
		//8 tag name   --- HTML tag
		//gettext method is used to retieve text from a webelement
//		String text = driver.findElement(By.tagName("h2")).getText();
//		System.out.println(text);
		By header = By.tagName("h2");
		String text = eleUtil.doElementGetText(header);
		System.out.println(text);
	}

}
