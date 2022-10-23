package Automation.TVAutomationPages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiHomePage {
	
	WebDriver driver;
	
	/**
	 * Constructor for Wiki Home Page with the parameter of driver
	 * 
	 * @param driver
	 */
	public WikiHomePage(WebDriver driver) {
		this.driver=driver;
	}

	/**
	 * Populates the Wiki Home Page
	 * 
	 * @category Service
	 * @param movieName
	 * @throws IOException
	 */
	public void populateHomepage(String movieName) throws IOException {     		
		launchWikiHomePage();
		typeMovieName(movieName);
		clickSearch();
	}
	
	/**
	 * Launches the Wiki Home Page
	 * 
	 * @category Action
	 */
	public void launchWikiHomePage() {
		
		driver.get("https://en.wikipedia.org/");

	}
	
	/**
	 * Types the movie name into the search box
	 * 
	 * @category Action
	 * @param movieName
	 */
	public void typeMovieName(String movieName) {
		driver.findElement(PageElements.SEARCH_BOX.by).sendKeys(movieName);
	}
	
	/**
	 * Clicks the search button on the Wiki Home page
	 * 
	 * @category Action
	 */
	public void clickSearch() {	
		driver.findElement(PageElements.SEARCH_BUTTON.by).click();
	}
	
	/**
	 * Page Elements for the Wiki Home Page
	 * 
	 * @author Prudhvi
	 */
	private enum PageElements {
		
		SEARCH_BOX(By.xpath("//input[@class='vector-search-box-input']")),
		SEARCH_BUTTON(By.id("searchButton"));
		
		By by;

		PageElements(By by) {
			this.by=by;
		}
				
	}

}
