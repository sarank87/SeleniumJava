package SeleniumSesions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableHandle {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/afghanistan-in-bangladesh-2021-22-1299826/bangladesh-vs-afghanistan-1st-t20i-1299832/full-scorecard");

		Thread.sleep(3000);
		//Generic method to pass batsman name - get his details row from the table
		
		//td is column
		//tr is row
		////a[contains(text(),'Yasir Ali')]/parent::td/following-sibling::td/span
		////a[contains(text(),'Yasir Ali')]/parent::td/following-sibling::td
		System.out.println(getWicketTakerName("Yasir Ali"));
//		System.out.println(getScoreCardList("Yasir Ali"));
		
		//https://selectorshub.com/xpath-practice-page/
	}

	public static String getWicketTakerName(String name) {
		String wicketTaker = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/following-sibling::td/span")).getText();		
		return wicketTaker;
	}
	
	public static List<String> getScoreCardList(String name) {
		List<WebElement> scoreList = driver.findElements(By.xpath("//a[contains(text(),'"+name+"')]/parent::td/following-sibling::td"));		
//		return ScoreCard;
		List<String> scoreVal = new ArrayList<String>();
		for(int i =1;i<scoreList.size();i++) {
			String score = scoreList.get(i).getText();	
			scoreVal.add(score);
		}
		return scoreVal;
	}
}
