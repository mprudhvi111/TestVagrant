package Automation.TVAutomationTests;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	
	/**
	 * Launches the chrome driver and the website
	 *  
	 * @throws IOException
	 */
	@BeforeMethod
	public void launch() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();

	}
	
	/**
	 * Closes the browser window
	 */
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}
