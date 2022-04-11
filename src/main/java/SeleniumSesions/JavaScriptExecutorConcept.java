package SeleniumSesions;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Alerts creation
		//scroll
		//Highlight elements
		//get inner text of entire DOM/ page - getpage source displays entire DOM including tag names
		// title of page
		//refresh browser page
		// highlight webelemnt
		//flash webelement
		//Scroll 
		//Scroll till particular webelement
		//Infinite loading / Lazy View loading
		//click
		//sendkeys
		
		// title is part of head and is not part of body
		// findelement searches inside body and not in head - INTERVIEW QUESTION
		//driver.getTitle method internally calls JavaScript Executor - document.title methos

		//JavaScriptExecutor interface availble in Java will help to execute JavaScript
		// The interface has ExecuteMethod
		
		//RemoteWebDriver class is implementing JavaScriptExecutor interface
		
		
		//Alerts is used for debugging purposes in scripts
		
		//Browsers understands only javascripts
		//So selenium method internally calls Javascript methods
		//How many ways we can get title of the page - 2 - getTitle() and Document.title
		
		//Javascript is injected into browser code
		//equivalent to driver.naviagte().refreshs
		
		//Imp objects - Document , History , Navigation
		
		
		//when normal click , Actions click does not work  - clicks on element - End User - As a tester we use it
		//then We use jS click - JS click is injecting click on element - not end user behaviour- not preferable
		// So JSclick is not preferable
		
		//document.value@ - We can pass xpath in JSExecutor
		//See Days3 coding challenge by NaveenAutomationLabs
		
		
		
	}
}
