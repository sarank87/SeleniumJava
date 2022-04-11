package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("http://londonfreelance.org/courses/frames/index.html");
//		driver.switchTo().frame(2);//starts from 0 index
		
//		driver.switchTo().frame("main");//By id or name
		
		//Frame is webelement having its own DOM -- We need to switch to frames
		//Frame is not W3C recommended
		//Frames are used for security - No one can access frames
		//Actually we can accessit but we need the frame details
		driver.switchTo().frame(driver.findElement(By.name("main"))); // Using WebElement
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
	
		//We can have frame inside a frame - rare case
		
		//parent frame - Selenium 4 feature
//		driver.switchTo().parentFrame(); //It will interact with parent frame
		
		//Come out of frame
		driver.switchTo().defaultContent(); //select the first frame or main document of DOM
		
		
		//Salesforce UI -- Will have multiple frames
		//NoSuchFrameExceptiuon - If the frame is not present
		//We can use wait concepts - if frame is loaded after sometime
		
		//INTERVIEW QUESTION - Can I handle any random popups
		//--We cannot handle it
		//QA env - We have to disable advertisement popups
		
	}

}
