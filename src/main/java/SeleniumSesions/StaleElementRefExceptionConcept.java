package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementRefExceptionConcept {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//WebElement is staled - rotten
		//Earlier it was present but now its not present
		
	//Element e1 is present in DOM
		//refreshed page
		//e1.click --> but e1 is created before refresh and is staled - Its a stale element
		
		// refresh , back , forwad actions will create stale element exceptions
				
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.tips/index.php?route=account/login");
	
		By emailid = By.id("input-email"); //org.openqa.selenium.TimeoutException and  org.openqa.selenium.NoSuchElementException
		By password = By.id("input-password");
		By loginBtn = By.xpath("\\input[@value='Login']");
		
		WebElement login_ele = driver.findElement(emailid);  //DOM V1  // WebElent ID is dependent on DOM that is used to perform actions in DOM
		login_ele.sendKeys("test@gmail.com");
		Thread.sleep(4000);
		//refresh page 
		driver.navigate().refresh();
		login_ele = driver.findElement(emailid);  //DOM V2  handling stale element exception // new id is created for new DOM V2
		login_ele.sendKeys("anu@gmail.com");
		//org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
		//DOM is changed
		
		// So we use By locators technique - We create webelements at runtime
		
		
		//PageFactory @FindBy loads all webelements deprecated - in C# - Is going to be deprecated in Java also
		
	}
}
