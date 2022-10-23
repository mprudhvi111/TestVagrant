package Automation.TVAutomationPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImdbMovieDetailsPage {

	WebDriver driver;
	/**
	 * Constructor for Imdb Movie Details Page with the parameter of driver 
	 * 
	 * @param driver
	 */
	public ImdbMovieDetailsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * Gets the Movie Release Date text from the Imdb Movie Details Page
	 * 
	 * @category Extraction
	 * @return String
	 */
	public String getMovieReleaseDate() {
		return driver.findElement(PageElements.MOVIE_RELEASE_DATE.by).getText().split("\\(")[0].trim();
	}
	
	/**
	 * Gets the Movie Country text from the Imdb Movie Details Page
	 * 
	 * @category Extraction
	 * @return String
	 */
	public String getMovieCountry() {
		return driver.findElement(PageElements.MOVIE_COUNTRY.by).getText();
	}
	
	/**
	 * Page Elements for the Imdb Movie Details Page
	 * 
	 * @author Prudhvi
	 */
	private enum PageElements {
		MOVIE_RELEASE_DATE(By.xpath("//a[contains(text(),'Release date')]/following-sibling::div")),
		MOVIE_COUNTRY(By.xpath("//span[contains(text(),'Country of origin')]/following-sibling::div"));
		
		By by;
		
		PageElements(By by) {
			this.by=by;
		}
	}
}
