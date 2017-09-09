package uptakeAutomation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageObjects.MainPageElements;
import pageObjects.BeyondPageElements;

public class NavigationExercise {
	private static ChromeDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		File file = new File("D:/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		
		//This will store all preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
	
		//This will switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);
	
		//Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
		
		driver.get("https://uptake.com/");
		driver.manage().window().maximize();
		
		MainPageElements.navigationLink(driver, "Newsroom").click();
		MainPageElements.assertWeAreOnTheRightPage(driver, "newsroom");
		System.out.println("PASS: We are on the newsroom page.");
		
		MainPageElements.navigationMainPage(driver).click();
		MainPageElements.assertWeAreOnTheRightPage(driver, "home");
		System.out.println("PASS: We are on the home page.");
		
		MainPageElements.navigationLink(driver, "Beyond.Uptake").click();
		ArrayList<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(browserTabs.get(1));
		BeyondPageElements.assertWeAreOnTheBeyondHomePage(driver);
		System.out.println("PASS: We are on the beyond home page.");		
		
		driver.quit();
	}
}
