package SeleniumSesions;

import org.openqa.selenium.By;

public class Custom_Xpath_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//xpath is address of an element in the DOM
		
		//URL - "https://demo.opencart.com/index.php?route=account/login"
		
		//Formaule - //htmlTag[@attribute='vale']
		//Ex- //input[@id='input-email']
		//Ex - //input[@id]
		//Ex - //input[@type='submit']
		//Ex - //input[@type='submit' and @value='Login']
		//Ex - //input[@type='submit' or @value='Login']
		//Ex - //input[@type='text' and @name='email']
		// Ex - Placeholder - //input[@type='text' and @placeholder='E-Mail Address']
		//Ex - //*[@id]   -- all attributes where id is available
		//Ex - //*[@id='input-email'] - Not preferable to use * because if we use * the search scope is more for xpaths
		// With specific tags - its faster
		
		//Ex -  DYNAMIC IDs
//		<input id = "test_123">
//		<input id = "test_456">
//		<input id = "test_789">
		
		//For Dynamic xpaths we use some functions like contains
		// Ex - //input[contains(@id,'Test_')
		//Ex - //input[contains(@id,'email')]
		
		//contains with multiple attributes
		//htmlTag[contains(@attr1,'value1') and contains(@attr,'value2)]
		//Ex - //input[contains(@id,'email') and contains(@placeholder,'E-Mail')]
		//Ex - //input[contains(@id,'email') and contains(@placeholder,'E-Mail') and contains(@name,'email')]
		
		//One attr with conatins and other without contains
		//input[contains(@id,'email') and @type='text']
		//Ex - //input[@type='text' and contains(@id,'email')]
		//Ex - //input[contains(@id,'password')]
		//Attribute should start with @
		
		//Ex - //a[@class='list-group-item']  -- We use findelements
		//xpaths on basis of text method and text is not attribyte
		//EX - //htmlTag[text()='value']
		//Ex - //a[text()='Register']
		//Ex - //a[text()='My Account']
		//Ex - //h2[text()='Returning Customer'] - BEST Example
		
		//Amazon Link
		//"https://www.amazon.com/"
		//htmlTag[text()='value' and @attr = 'value']
		// We can reverse the sequence also
		//contains and text method 
		//htmlTag[contains(text(),'value')]
		//Ex - //a[contains(text(),'Gift') and contains(@href,'gift-cards')]
		
		//start-with method
		//Ex - //a[starts-with(text(),'Gift')]
		//Ex - //input[starts-with(@id,'input')]   // We can use with attributes also
		
		
		//ends-with method - Its deprecated with latest xpath engine
		//use contains instead of ends-with
		
		//indexing
		
		//Ex- (//input[@class='form-control'])[2]  - Make sure to use captcha group or ()
		By emailID = By.xpath("(//input[@class='form-control'])[1]");
		By password = By.xpath("(//input[@class='form-control'])[2]");
	
		//position function
		//Ex - (//input[@class='form-control'])[position()=1]
		// Position and index start with 1 in DOM concept and npot with 0
		// / for direct childs and // for indirect childs
		// Ex - (//div[@class='navFooterLinkCol navAccessibility'])[1]//a
		
		
		// last function - works for any html tag and text
		//Ex - (//input[@type='text' or @type='email' or @type='tel' or @type='password'])[last()]
		
		//Amazon .com footer - last column last value shpould be Help
		// Ex - ((//div[@class='navFooterLinkCol navAccessibility'])[last()]//a)[last()]
		// For 3rd column
		// Ex - ((//div[@class='navFooterLinkCol navAccessibility'])[last()-1]//a)[last()]
		
		//All links starting with Amazon give me last element
		//Ex - (//a[starts-with(text(),'Amazon')])[last()-1]
		
		//Child class
		//Ex - (//div[@class='form-group'])[1]/input[contains(@id,'email')]
		//Ex - //ul[@class='footer-nav']/li/a   single slash is for direct child
		//Ex - //ul[@class='footer-nav']//a  double slash is for both direct and indirect childs
	
		
		//https://app.hubspot.com/login?hubs_signup-url=www.hubspot.com/&hubs_signup-cta=homepage-nav-login&_ga=2.161522428.154566394.1646275137-392642779.1646275137
		//Ex - //form[@id='hs-login']/div  - 8
		//Ex - //form[@id='hs-login']//div  - 20
		
		//Ex - //Ex - //form[@id='hs-login']/child:div
		//Ex - //Ex - //form[@id='hs-login']//child:div
		
		
		//MISSING - CHECK VIDEO
		
		//Go to immediate parent	
		//Ex - //input[@id='username']/..
		//Alternate way - //input[@id='username']/parent::div
		//Backward traversing - //input[@id='username']/../../../..
		//Immediate parent - //input[@id='username']/parent::div
		
		//This gives all the ancestor parents 
		////input[@id='username']/ancestor::div  - returns all 8 grand parents
	}

}
