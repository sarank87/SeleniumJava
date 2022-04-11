package SeleniumSesions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class customCSSSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//id--> #id 
		//  #input-email
		//class --> .class 
		//   .form-control
		
		//  #input-email.form-control
		//  .form-control#input-email
		
		//.c1.c2.c3.cn
		//.nav-unput.nav-progressive.attribute
		
		//input#input-email
		//input.form-control
		//input.form-control#input-email
		//a.btn-orange.contact-ohrm
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		
		
		//https://www.orangehrm.com/contact-sales/
		//Contact Sales button
		//By.ClassName -- We have to pass only 1 uinique class name
		// In xpaths we can use multiple classes
		By ele = By.cssSelector("");

		
		//Hubspot.com login
		//https://app.hubspot.com/login/
		//class --> form-control private-form__control login-email
		By.className("form-control private-form__control login-email");//will not work
		By.xpath("//input[@class='form-control private-form__control login-email']");//Valid
		By.className("login-email");//Valid
		By.cssSelector("form-control.private-form__control.login-email");//Valid
		By.cssSelector("input.login-email");//Valid
		
		//Login button
		//uiButton private-button private-button--primary private-button--default m-bottom-4 login-submit private-button--non-link
		
		//button.login-submit
		//xpath - entire class we have to pass
		By.xpath("//button[contains(@class,'login-submit')]");//Valid
		By.xpath("//button[@class='login-submit']");//Not Valid
		
		//htmlTag[attr='value]
		By.cssSelector("input[type='submit']"); //CSS Selector
		By.xpath("input[@type='submit']");//xpath
		
		
		//htmlTag[attr='value][attr2='value'][attr3='val']
		//input[type='submit'[value='login'] //CSSSelector
		//input[@type='submit and value='login'] //xpath
		
		//Open Cart
		//input[id*='email']  --> * is for contains
//		input[id^='input'] -->   ^ is starts-with
		
		//Hubspot login button
		//button[class*='submit']
		
		//button[data-test-id^='password']
		//ends with is $
		//button[data-test-id$='button']
		
		// * - Contains ^ - starts with $ - ends with in CSS selector
		
		//Parent to child in CSSSelector
		// > is used for direct child
		// div.private-form__input-wrapper>input#username  -- > Direct child elements
		
		// Indirect child elements - Yes if we remove > - it will be direct + indirect child elements
		// div.private-form__input-wrapper input#username   --> Direct + indirect child elements
		
		//Freshworks .com footers
		//https://www.freshworks.com/?tactic_id=3419392&utm_source=Google-Adwords&utm_medium=FWorks-Search-Brand&utm_campaign=FWorks-Search-Worldwide-Brand&utm_term=freshworks&device=c&ad_pos=&gclid=Cj0KCQiA95aRBhCsARIsAC2xvfzNvEhr4nl9TDg6QwPGihWo_FG7o9ZDQYp9C5rg-wOxuwbn2zNxWDUaAiQmEALw_wcB
		// ul.footer-nav>li>a
		
		//hubspot.com login
		//form#hs-login div  --> return 20 elements - direct + indirect childs	
		//form#hs-login > div  --> returns 8 elements - only direct childs
		
		
		//Child to parent in xpaths Yes but not in CSSSelectors
		// NA
		// There is no backward compatibility from child to parent in CSS Selector
		
		
		//Open Cart
		//following sibling - forward traversing
		// + IS USED FOR FOLLOWING SIBLING
		//label.control-label + input#input-email
		
		//Preceding sibling - Not allowed in CSS Selector - Backward traversing is not allowed
		
		//not in css
		
		//hubspot
		//Email class - form-control private-form__control login-email
		// Password class - form-control private-form__control login-password m-bottom-3
		
		//input.form-control.private-form__control.login-password.m-bottom-3
		
		// Use :not to exclude one webelement
		//input.form-control.private-form__control:not(#username)
		
		//Registration screen
		//input.form-control:not(.input-lg) --> We are excluding search fields
		
		
		//comma in css - not available in xpaths
		// we can include multiple elements using , delimiters
		//Hubspot login page
		//input#username,input#password,button#loginBtn,button#ssoBtn,input#remember
		//input#username,input#password,button#loginBtn,button#ssoBtn,input#remember,a[class='google-sign-in']
		int count =
		driver.findElements(By.cssSelector("input#username,input#password,button#loginBtn,button#ssoBtn,input#remember")).size();
		
		//Freshwork page
	
		// There is not methods or functions like text
		// We cannot use text() on CSSSelectors - Another limitations
		// No text support in CSS
		// So CSS not recommended for capturing headers
		
		//Indexing is available in CSSSelectors
		//nth-of-type
		// ul.footer-nav li:nth-of-type(5) > a   --> Freshworks footer
		
		// In Browser DOM is loaded first and then the page
		// xpath engnes V6 V8 versions
		// xpath engines in IE is very very slow and will be performance impacted
		//Chrome xpath engine is fasters - So it depends on browsers
		
								//xpaths                                     //CSSSelector
//1. Syntax            			Hard											Simple
//2. Backward compatibility     possible										Not Available
//3. performance				same - depends on browsers           same-depends on browsers
//4. comma , not 				NA									 		Available
//5. text						Available										NA
//6. sibling					Available								Only forward-sibling
//7. index						better functions						available but not simple
//8. dynamic elements			Available								Available

	//INTERVIEW - We are using both but mostly we are using xpaths since our apps is having multiple webtables
		// and webtables handling is better in xpaths	
		
	// practically will prefer xpaths
	//We can use xpaths tools like Selectorhubs
		
		
		//Playwright - performance is better use websocket protocol and not https protocol
		//Connection is retained once established
		//Cypress is slower than Selenium and Selenium is slower than Playwirght
		// Selenium follows W3C and is very strong than playwright
		//Java , Javascript , Python , Ruby -- for Playwright	
		
		// Playwright is google team - now owned by Microsoft - have eliminated all Cypress limitations
	}
}
