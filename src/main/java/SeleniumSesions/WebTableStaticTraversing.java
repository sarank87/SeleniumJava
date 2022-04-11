package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableStaticTraversing {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		//Press F8 under Sources in Console to freeze the pane - Debugger will be paused
		// This is for tooltip
//		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
//		Thread.sleep(3000);
		
		//tr - table row
		//th - table header
		//td - table data
		
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		
//		int rowCount = driver.findElements(By.xpath("//table[@id='customers'])//tr")).size();
//		int colCount = driver.findElements(By.xpath("//table[@id='customers'])//th")).size();

		By rowCount = By.xpath("//table[@id='customers'])//tr");
		By colCount = By.xpath("//table[@id='customers'])//th");
		String before_xpath = "//*[@id=\"customers\"]/tbody/tr[";
		String after_xpath = "]/td[1]";
		for(int i = 2;i<=getRowCount(rowCount);i++) {
			String xpath = before_xpath + i + after_xpath;
//			System.out.println(xpath);
			String text = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(text);
		}
	
		
		//ASSIGNMENT - Bigbasket - Print all options through nested loops
	}
	
	public static int getRowCount(By locator) {
		return driver.findElements(locator).size();
	}
	
	public static int getColCount(By locator) {
		return driver.findElements(locator).size();
	}
}
