package SeleniumSesions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Selenium - Its just a library which automates UI browsers
	// not a test automation test tool
	//perform user actions - click , sendkeys , app,url,captures values from UI
	//Tool : No
	//Library :Yes
	//supports multiple languages  : java , python , c# , ruby , JS , Php , GO
	//supports multiple browsers  : FF,chrome , safari , opera edge ,IE
	//platform - MAC , Linux , Windows
	//Open Source : source code is public
	//it can be customized : selenium + extra  --> new automation library
	//Free License - no payment
	//No Desktop application - WinApp , UFT , TestComplete
	// No Mobile Native app : Appium , TestProject , WebDriver IO
	//performance testing is not recommended
	//security testing - No
	//cannot test anything : other libraries to test the application
	// testNG/jUnit , Mocha , Chai , Jasmine , Pytest , Unitest , PHP UNIT , NUNIT
	// no test report : other libraries  : Allure , Extent , TestNG report
	//generate logs : UI actions logs , custom logs (log4j)
	// no hardware testing : No
	//API Testing : NO
	//Infrastructure setup : NO - Selenium GRID is there - run test cases on different machines , remote , cloud , dockers
	//Custom Selenium Grids - Selenoid , Zelenium , Dockerized GRID - Free Grids
	//GRID vendors : BrowserStack , SauceLabs , LambdaTest -- Padi Vendors
	
	//Different components of Selenium
	//IDE - Integrated Development Environment
	//1. Selenium IDE - record and play plugin on FF/Ch
	//2. RC - remote Control - Selenium 1 - supports Java , C# - have concept of Selenium Sever
	//Limitations - not able to handle popus not W3C compatible
	//depreciatd
	//3. WebDriver  + RC --> Selenium WebDriver : Selenium 2
	// Selenium 2.X --> Selenium 3.X (3.141.59 --2018 most stable- Used JSON Wire protocol)--> Selenium 4.X (W3C compliant)
	//W3C - WorldWide Compliance
	//4.X is now more compliant with browsers since browsers are W3C compliant
	//4.Selenium GRID - run test cases on different machines , remote , AWS , Cloud , Docker
	
	//Selenium + java : 70 to 80 %
	//Selenium + javascript
	//Selenium + Python
	
	//Selenium is JAR written in Java

public class WebDriverBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\saran\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
		//INTERVIEW QUESTION - Java concepts used
		//Top Casting
		//ChromeDrivwer class object can be referred by parent WebDriver reference variable
		//WebDriver Interface is implemented in RemoteWebDriver child class
		//WebDriver interface has methods like title(),URL,getPageSource(), close , quit etc
		//Parent of WebDriver interface is SearchContext interface
		//SearchContext has 2 methods - findElement and FindElements -- overidden by WebDriver interface
		//RemoteWebDriver implements findElement and FindElements
		//Remote WebDriver had child classes - Chromium which has child class ChromeDriver
		// Similarly RemoteWebDriver has child classes FirefoxDriver , SafariDriver , EdgeDriver , Edge Driver
		//RemoteWebDriver is used for remote executions - We pass desired capabilities
		
		
		WebDriver driver = new ChromeDriver(); //Launch Chrome browser if driver path is set  -- Opens browser
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		//Validation point / checkpoint / act versus exp result
		if(title.equals("Google")) {
			System.out.println("correct title");
		}
		else {
			System.out.println("Incorrect Title");
		}
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl().contains("google"));
		
		System.out.println(driver.getPageSource()); //Print Page source DOM
		
		//Automation Steps + Validation Points  /Checkpoints / act vs expected result / assertions
		//Automation Testing
		
		driver.quit();		
		//All browsers opened will have message - Chrome is being controlled by automated test software
	}
}
