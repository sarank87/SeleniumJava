package SeleniumSesions;

import java.net.MalformedURLException;
import java.net.URL;

public class AmazonTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		BrowserUtil br = new BrowserUtil();
		br.launchBrowser("chrome");
//		br.launchURL("www.amazon.com");
		br.launchURL(new URL("https:\\www.amazon.com"));
		String title = br.getPageTitle();
		System.out.println(title);
		if(title.contains("Amazon")) {
			System.out.println("Correct title");
		}
		else {
			System.out.println("Incorrect title");
		}
		System.out.println(br.getPageURL());
		br.closeBrowser();
		
	}

}
