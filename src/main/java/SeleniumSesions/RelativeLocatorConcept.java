package SeleniumSesions;

//Static import for with  -- IMPORTANT
import static org.openqa.selenium.support.locators.RelativeLocator.with;

// If we dont do static we have to write RelativeLocator.with and the code will look ugly
// So we do static import


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Selenium 4 features
		// Using With feature
		//Can onl;y go to nearest periphery
		//Very useful in webtables 
		//Alternate for complex webtable xpath traversing
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.aqi.in/dashboard/canada");
		
		WebElement ele = driver.findElement(By.linkText("Saint-John, Canada"));
		
		//Right
		String index = driver.findElement(with(By.tagName("p")).toRightOf(ele)).getText();
		System.out.println(index);
		
		//Left
		String rank = driver.findElement(with(By.tagName("p")).toLeftOf(ele)).getText();
		System.out.println(rank);
		
		//Below
		String city = driver.findElement(with(By.tagName("p")).below(ele)).getText();
		System.out.println(city);
		
		//Above
		String cityAbove = driver.findElement(with(By.tagName("p")).above(ele)).getText();
		System.out.println(cityAbove);
		
		String nearText = driver.findElement(with(By.tagName("p")).near(ele)).getText();
		System.out.println(nearText); // nearest tag is p prints text of p which is same  text

		//Above the webelement it will give all list names
		List<WebElement> aboveList = driver.findElements(with(By.tagName("a")).above(ele));
		for(WebElement e: aboveList) {
			System.out.println(e.getText());
		}
		
		//Open Cart demo register page
//		go to left of Yes and left side of No radio button
		
		
	}

}
