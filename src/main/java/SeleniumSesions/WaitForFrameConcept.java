package SeleniumSesions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFrameConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("http://londonfreelance.org/courses/frames/index.html");
		By frameLocator = By.name("main");
		driver = waitForFrame(5,frameLocator);//driver.switchTo.frame
		
		String header = driver.findElement(By.xpath("/html/body/h2")).getText();
		System.out.println(header);
		driver.switchTo().defaultContent();//comes back to default frame or first frame

	}
	
	public static WebDriver waitForFrame(int timeOut,By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
	}
	
	public static WebDriver waitForFrameByIndex(int timeOut,int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		
	}
	
	public static WebDriver waitForFrameByString(int timeOut,String frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
	}
	
	public static WebDriver waitForFrameByElement(int timeOut,WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		
	}

}
