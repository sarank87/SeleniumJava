package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saran\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); //Launch Chrome browser if driver path is set  -- Opens browser
		driver.get("https://www.google.com");//Session ID - 08c50a9f5719b7946a501f43adbca987
		//Use debud mode to capture session id
		String title = driver.getTitle();
		System.out.println(title);
//		driver.quit();//08c50a9f5719b7946a501f43adbca987
		driver.close(); // Session ID is invalid after we close the browser
//		System.out.println(driver.getTitle()); //Now session id is null - thats why we get exception
//		NoSuchSessionException - Both for close and quit we get the message
//		Session ID is null. Using WebDriver after calling quit()? -- This is for quit
//org.openqa.selenium.NoSuchSessionException: invalid session id  -- This is for close
		//F6 to Step Over
		
		//Re-initialization of driver
		//Launch browser again to avoid errors - a new session id is created
		driver = new ChromeDriver(); 
		driver.get("https://www.google.com");//New Session ID is created
		//Use debud mode to capture session id
		title = driver.getTitle();
		System.out.println(title);
	}

}
