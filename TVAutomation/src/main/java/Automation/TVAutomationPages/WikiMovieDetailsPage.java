package Automation.TVAutomationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikiMovieDetailsPage {

	WebDriver driver;
	
	/**
	 * Constructor for Wiki Movie Details Page with the parameter of driver
	 * 
	 * @param driver
	 */
	public WikiMovieDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Gets the Movie Release Date text from the Wiki Movie Details Page
	 * 
	 * @category Extraction
	 * @return String
	 */
	public String getMovieReleaseDate() {
		return driver.findElement(PageElements.MOVIE_RELEASE_DATE.by).getText();
	}
	
	/**
	 * Gets the Movie Country text from the Wiki Movie Details Page
	 * 
	 * @category Extraction
	 * @return String
	 */
	public String getMovieCountry() {
		return driver.findElement(PageElements.MOVIE_COUNTRY.by).getText();
	}

	/**
	 * Page Elements for the Wiki Movie Details Page
	 * 
	 * @author Prudhvi
	 */
	private enum PageElements {
		MOVIE_RELEASE_DATE(By.xpath("//table[@class='infobox vevent']//tr//th/div[text()='Release date']/parent::th/following-sibling::td")),
		MOVIE_COUNTRY(By.xpath("//table[@class='infobox vevent']//tr//th[text()='Country']/following-sibling::td"));
		
		By by;
		
		PageElements(By by) {
			this.by=by;
		}
	}
}
