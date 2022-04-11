package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. total links on page
		//2. print the text of each element
		//3. exclude blank text
		//ArrayList is order based collection

		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		ElementUtil eleUtil = new ElementUtil(driver);
//		List<WebElement> linksList = driver.findElements(By.tagName("a"));
//		System.out.println("Total Links is " + linksList.size());
//		
////		for(WebElement e : linksList) {
////			String text = e.getText();
////			if(!text.isEmpty()) {
////				System.out.println(text);
////			}
////			
////		}
//		
//		for(int i=0 ;i<linksList.size();i++) {
//			String text = linksList.get(i).getText(); // Need to use get(i) for index based index
//			if(!text.isEmpty()) {
//			System.out.println(text);
//			}
//		}
		
		By links = By.tagName("a");
		System.out.println("Total Links : " + eleUtil.getElements(links).size());
		
		List<String> eleTextList = eleUtil.getLinksTextList(links);
		
		System.out.println(eleTextList.size());
		System.out.println(eleTextList.contains("Sell"));
		
	}

}
