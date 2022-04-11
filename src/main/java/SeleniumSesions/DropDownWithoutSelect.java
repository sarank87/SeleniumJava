package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownWithoutSelect {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial");
		
		//wE CAN USE sENDkEYS ALSO TO SELECT DROPDOWN VALUE - NOT PREFERABLE
		//will not work always
		driver.findElement(By.id("Form_submitForm_Country")).sendKeys("India");
		
//		By country = By.id("Form_submitForm_Country");
//		By state = By.id("Form_submitForm_State");
	
		//xpath - / direct child //direct and indircect options
		
		//Without using Select class
		List<WebElement> countryList = driver.findElements(By.xpath("//select[@id='Form_submitForm_Country']/option"));
		for(WebElement e : countryList) {
			String text = e.getText();
			if(text.equals("India")) {
				e.click();
				break;
			}
		}
	
	}

}
