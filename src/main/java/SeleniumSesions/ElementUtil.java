package SeleniumSesions;

import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	
	private WebDriver driver;
	
	//Use constructor to get webdriver method
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	// If we make the methods as static we need to make driver as static
	//If we make driver as static then we cannot do parallel executions using multiple threads
	//So we never create WebDriver as static in our framework
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public By getBy(String locatorType,String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
			
		case "classname":
			locator = By.className(locatorValue);
			break;
			
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
			
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
			
		case "LinkTest":
			locator = By.linkText(locatorValue);
			break;
			
		case "PartialLinkTest":
			locator = By.partialLinkText(locatorValue);
			break;

		case "tagname":
			locator = By.tagName(locatorValue);
			break;
			
		default:
			break;
		}
		
		return locator;
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	// Check if WebElement is present on screen
	public boolean isElementPresent(By locator) {
		if(getElements(locator).size()>0){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public List<String> getLinksTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e : eleList) {
			String text = e.getText();
			if(!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		
		return eleTextList;
	}
	
	public List<String> getElementAttributeList(By locator,String attribute) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for(WebElement e :eleList) {
			String attrVal = e.getAttribute(attribute);
			eleAttrList.add(attrVal);
			System.out.println(attrVal);
		}
		return eleAttrList;
	}
	
	
//##################################DropDown utils#################################
	
	//Preferred
	public void doSelectByVisibleText(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(value);
	}
	
	//Not preferable - Index might change
	public void doSelectByIndex(By locator,int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}
	
	//Preferred
	public void doSelectByValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}
	
	public List<String> doGetDropDownOptions(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsValueList = new ArrayList<String>();
		System.out.println(optionsList.size());
		for(WebElement e:optionsList) {
			String text = e.getText();
//			System.out.println(text);
			optionsValueList.add(text);
		}
		
		return optionsValueList;
	}

	
	//INTERVIEW QUESTION
	//Select value from dropdown without using select methods
	public void doSelectDropDownValue(By locator,String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for(WebElement e : optionsList) {
			String text = e.getText();
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	//------------------------------Actions Utils -----------------------------

	public void selectSubMenu(By parentMenu,By childMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		getElement(childMenu).click();
	}
	public void selectSubMenul3(By parentMenu,By childMenu,By subChildMenu) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu).click();
	}
	
	public void selectSubMenul4(By parentMenu,By childMenu1,By subChildMenu2,By subChildMenu3) throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(parentMenu)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(childMenu1)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(subChildMenu2)).perform();
		Thread.sleep(2000);
		getElement(subChildMenu3).click();
	}
	
	public void getRightClickOptions(By rightClick,By RghtClickOptions,String value) {
		WebElement rightClickEle = getElement(rightClick);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();//context click is overloaded method	
		//Collect right click options
		List<WebElement> itemList = driver.findElements(RghtClickOptions);
		System.out.println(itemList.size());
		for(WebElement e:itemList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public  List<String> getRightClickOptionsList(By rightClick,By RghtClickOptions) {
		WebElement rightClickEle = getElement(rightClick);
		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();//context click is overloaded method	
		List<String> rightClickItems = new ArrayList<String>();
		//Collect right click options
		List<WebElement> itemList = driver.findElements(RghtClickOptions);
		System.out.println(itemList.size());
		for(WebElement e:itemList) {
			String text = e.getText();
			System.out.println(text);
			rightClickItems.add(text);
			}
		return rightClickItems;
		}

	public void doContextClick(By locator) {
		getElement(locator).click();
	}
	
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}
	
	public void doActionsSendkeys(By locator,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator),value).perform();
	}

	//#######################################wait methods ###################################################
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	//Selenium is looking for WebElement in DOM but it might not be visible on page
	
	public WebElement waitForElementrPresent(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));//Duration is Selenium 4 feature
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility 
	 * means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeout
	 * Polling Time is default 500 milliseconds
	 * @return
	 */

	public WebElement waitForElementVisible(By locator,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));//Duration is Selenium 4 feature
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//##########################Overloaded Wait methods###############################################
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does notnecessarily mean that the element is visible.
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * Polling Time is default 500 milliseconds
	 * @return
	 */
	
	//Selenium is looking for WebElement in DOM but it might not be visible on page
	
	public WebElement waitForElementrPresent(By locator,int timeout , int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible.Visibility 
	 * means that the element is not only displayed but also has a height and width that isgreater than 0.
	 * @param locator
	 * @param timeout
	 * @param pollingTime
	 * @return
	 */

	public WebElement waitForElementVisible(By locator,int timeout,int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout),Duration.ofMillis(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	

	//#######################################Alert Utils ########################################
	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent()); // No need of SwitchTo - Until has started returning alerts and not Webelements
	}
	
	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public void getAlertText(int timeOut) {
		waitForAlert(timeOut).getText();
	}

	//###########################Frame Utils ##############################################
	
	public WebDriver waitForFrame(int timeOut,By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		
	}
	
	public WebDriver waitForFrameByIndex(int timeOut,int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
		
	}
	
	public WebDriver waitForFrameByString(int timeOut,String frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		
	}
	
	public WebDriver waitForFrameByElement(int timeOut,WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
		
	}

	
	public void clickWhenReady(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void clickElementWhenReady(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(getElement(locator))).click();
	}


	public void printAllElements(By locator,int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator,10);
		for(WebElement e: eleList) {
			System.out.println(e.getText());
		}
	}
	
	public List<String> getElementsTextListWithWait(By locator,int timeOut) {
		List<WebElement> eleList = waitForElementsToBeVisible(locator,10);
		List<String> eleTextList = new ArrayList<String>();
		for(WebElement e: eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}
	
	public List<WebElement>  waitForElementsToBeVisible(By locator,int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));		
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));		
	}

	//######################################Custom Wait Methods #############################################
	public WebElement retryingElement(By locator,int timeOut) {
		WebElement element = null;
		int attempts = 1;
		while(attempts< timeOut) {
			try {
				element = getElement(locator);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found in attempt " + attempts + " for locator " + locator);
				try {
					Thread.sleep(500);  //Default interval time
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Static wait used in dynamic wait
			}
			attempts++;
		}
		
		if(element==null) {
			try {
				throw new Exception("ELEMENT NOT FOUND EXCEPTION");
			}
			catch(Exception e) {
				System.out.println("Element is not found exception tried for " + timeOut + 
						"with intervals of : 500 ms");
			}
		}
		return element;
	}
	
	public WebElement retryingElement(By locator,int timeOut, int intervalTime) {
		WebElement element = null;
		int attempts = 1;
		while(attempts< timeOut) {
			try {
				element = getElement(locator);
				break;
			}
			catch(NoSuchElementException e) {
				System.out.println("Element is not found in attempt " + attempts + " for locator " + locator);
				try {
					Thread.sleep(intervalTime);  //Custom interval time
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //Static wait used in dynamic wait
			}
			attempts++;
		}
		
		if(element==null) {
			try {
				throw new Exception("ELEMENT NOT FOUND EXCEPTION");
			}
			catch(Exception e) {
				System.out.println("Element is not found exception tried for " + timeOut + 
						" with intervals of : " + intervalTime + "ms");
			}
		}
		return element;
	}
	
	//########################################Page Load method ###################################
	
	public void waitForPageLoad(int timeOut) {
		long endTime = System.currentTimeMillis() + timeOut;
		while(System.currentTimeMillis()<endTime) {			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String state = js.executeScript("return document.readyState").toString();
			System.out.println(state);
			if(state.equals("complete")) {
				break;
			}
		}
	}
	
	//##############################   Fluent Wait utils ###############################################
	public WebElement waitForElementPresentWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class,ElementNotInteractableException.class);//Max 2 eceptions we can ignore
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public WebElement waitForElementVisibilityWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public WebDriver waitForFrameWithFluentWait(By locator,int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchFrameException.class);
		
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	public Alert waitForAlertWithFluentWait(int timeOut,int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoAlertPresentException.class);
		
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	
	//###############################Add other WebDriverWait Utils as FluentWait Utils ###################################################
}
