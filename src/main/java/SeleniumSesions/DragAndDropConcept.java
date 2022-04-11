package SeleniumSesions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Drag and Drop is supported from element to element
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable");
		Thread.sleep(2000);
		WebElement sourceEle = driver.findElement(By.id("draggable"));
		WebElement destEle = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.clickAndHold(sourceEle).moveToElement(destEle).release().build().perform();
		act.dragAndDrop(sourceEle, destEle).perform(); //build is not mandatory
		act.dragAndDrop(sourceEle, destEle).build().perform(); //Ok
		act.dragAndDrop(sourceEle, destEle).build(); //Not ok 
		
	}

}
