package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGElementHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		
		//svg
		//svg can be handled by xpaths only and not by css
		List<WebElement> stateList =
		driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g']//*[name()='path']"));
		
		Actions act = new Actions(driver);
		for(WebElement e:stateList) {
			act.moveToElement(e).perform();
			String name = e.getAttribute("name");
			System.out.println(name);
			if(name.equals("Maryland")) {
				act.click().perform();
				break;
			}
		}
		
		//Flipkart search button is example of Flipkart
		//xpath - //*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']
		
	}

}
