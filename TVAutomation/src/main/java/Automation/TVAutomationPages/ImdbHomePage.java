package Automation.TVAutomationPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImdbHomePage {

	WebDriver driver;
	
	/**
	 * Constructor for Imdb Home Page with the parameter of driver
	 * 
	 * @param driver
	 */
	public ImdbHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	/**
	 * Populates the Imdb Home Page
	 * 
	 * @category Service
	 * @param movieName
	 */
	public void populateImdbHomePage(String movieName) {
		launchImdbHomePage();
		typeMovieName(movieName);
		clickMovieLink(movieName);
	}
	
	/**
	 * Launches the Imdb Home Page
	 * 
	 * @category Action
	 */
	public void launchImdbHomePage() {
		driver.get("https://www.imdb.com/");
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
	 * Clicks the corresponding movie link from the list of suggestions
	 * 
	 * @category Action
	 * @param movieName
	 */
	public void clickMovieLink(String movieName) {
		
		List<WebElement> l = driver.findElements(PageElements.MOVIE_LINKS.by);
		
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getText().contains(movieName))
			{
				l.get(i).click();
				break;
			}
		}
	}
	
	/**
	 * Page Elements for Imdb Home Page
	 * 
	 * @author Prudhvi
	 */
	private enum PageElements {
		SEARCH_BOX(By.id("suggestion-search")),
		MOVIE_LINKS(By.xpath("//ul[@role='listbox']//li//a//div//div"));

		By by;
		
		PageElements(By by) {
			this.by = by;
		}
	}
}
