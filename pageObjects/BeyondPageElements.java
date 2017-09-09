package pageObjects;

import org.openqa.selenium.chrome.ChromeDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class BeyondPageElements {
	
	public static void assertWeAreOnTheBeyondHomePage(ChromeDriver driver) {
		 
		String url = driver.getCurrentUrl();
		try {
			Assert.assertEquals(true, url.equals("https://beyond.uptake.com/") || url.equals("https://beyond.uptake.com/index.html"));
		} catch (AssertionError ex) {
			System.out.println("FAIL! The exception was: " + ex.getMessage());
			driver.quit();
		}
	}
}
