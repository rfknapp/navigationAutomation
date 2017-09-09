package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class MainPageElements {
	private static WebElement element = null;
	private static List<WebElement> elements;
	
	public static WebElement navigationLink(ChromeDriver driver, String linkText) {
		element = driver.findElement(By.xpath("//a[text()='" + linkText + "']"));		
		
		return element;
	}
	
	public static WebElement navigationMainPage(ChromeDriver driver) {
		element = driver.findElement(By.cssSelector(".mainLogo"));		
		
		return element;
	}
	
	@SuppressWarnings("deprecation")
	public static void assertWeAreOnTheRightPage(ChromeDriver driver, String pageName) {
		 
		elements = driver.findElements(By.id("pageName"));
		
		try {
			Assert.assertEquals(0, elements.size());
		} catch (AssertionError ex) {
			System.out.println("FAIL! The exception was: " + ex.getMessage());
			driver.quit();
		}
	}
}
