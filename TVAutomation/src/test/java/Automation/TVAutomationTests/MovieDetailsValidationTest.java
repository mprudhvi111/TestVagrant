package Automation.TVAutomationTests;

import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.Test;
import Automation.TVAutomationPages.WikiMovieDetailsPage;
import Automation.TVAutomationPages.WikiHomePage;
import Automation.TVAutomationPages.ImdbHomePage;
import Automation.TVAutomationPages.ImdbMovieDetailsPage;
import java.io.FileInputStream;
import java.io.IOException;

public class MovieDetailsValidationTest extends BaseTest {
	
	@Test
	public void testMovieDetailsValidation() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Automation\\TVAutomation\\resources\\data.properties");
		properties.load(fileInputStream);
		
		WikiHomePage wikiHomePage = new WikiHomePage(driver);
		wikiHomePage.populateHomepage(properties.getProperty("movie_name"));
		
		WikiMovieDetailsPage wikiMovieDetailsPage = new WikiMovieDetailsPage(driver);
		String wikiReleaseDate = wikiMovieDetailsPage.getMovieReleaseDate();
		String wikiCountry = wikiMovieDetailsPage.getMovieCountry();
		String [] wikiMovieReleaseDate = wikiReleaseDate.split(" ");
		
		ImdbHomePage imdbHomePage = new ImdbHomePage(driver);
		imdbHomePage.populateImdbHomePage(properties.getProperty("movie_name"));
		
		ImdbMovieDetailsPage imdbMovieDetailsPage = new ImdbMovieDetailsPage(driver);
		String imdbReleaseDate = imdbMovieDetailsPage.getMovieReleaseDate();
		String imdbCountry = imdbMovieDetailsPage.getMovieCountry();
		String [] imdbMovieReleaseDate = imdbReleaseDate.split(" ");
		imdbMovieReleaseDate[1]=imdbMovieReleaseDate[1].split(",")[0];
		
		Assert.assertEqualsNoOrder(wikiMovieReleaseDate, imdbMovieReleaseDate, "Release date is not matching");
		Assert.assertEquals(wikiCountry, imdbCountry, "Country is not matching");
		
	}
	
}
