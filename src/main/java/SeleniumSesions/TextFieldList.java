package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextFieldList {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//INTERVIEW QUESTION
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		ElementUtil eleUtil = new ElementUtil(driver);
		
		//input[@type='text' or @type='email' or @type='tel' or @type='password']
		//input[@class='form-control']
		List<WebElement> textFieldList =
		driver.findElements(By.xpath("//input[@type='text' or @type='email' or @type='tel' or @type='password']"));
		int fieldCount = textFieldList.size();
		System.out.println(fieldCount);
		
		for(WebElement e:textFieldList) {
			e.sendKeys("testing");
		}
	}

}
