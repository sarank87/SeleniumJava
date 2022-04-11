package SeleniumSesions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getAttribute {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com");
		ElementUtil eleUtil = new ElementUtil(driver);
		
		String hrefvalue = driver.findElement(By.linkText("Women")).getAttribute("href");
//		System.out.println(hrefvalue);
		
//		eleUtil.getElementAttributeList(By.tagName("a"), "href");
//		System.out.println(eleUtil);
		
		
		By images = By.tagName("img");
		System.out.println(eleUtil.getElements(images).size());
		List<String> srcList = eleUtil.getElementAttributeList(images, "src");
		List<String> altList = eleUtil.getElementAttributeList(images, "alt");
	}

}
