package uk.ac.aber.agile.movies.tests;

import static org.junit.Assert.*;

import uk.ac.aber.agile.movies.Movie;

import org.junit.Test;

public class MovieTest {

	@Test
	public void shouldBeInitialisedWithCorrectTitleAndPriceCode() {
		Movie movie = new Movie("Gravity", Movie.NEW_RELEASE);
		assertEquals("Incorrect title", "Gravity", movie.getTitle());
		assertEquals("Incorrect price code", Movie.NEW_RELEASE, movie.getPriceCode());
	}
	
	@Test 
	public void shouldSetAndGetTitle() { 
		Movie movie = new Movie("Gravity", Movie.NEW_RELEASE);
		movie.setTitle("Skyfall");
		assertEquals("Incorrect title", "Skyfall", movie.getTitle()); 
	}
	
	@Test 
	public void shouldSetAndGetPriceCode() { 
		Movie movie = new Movie("Gravity", Movie.NEW_RELEASE);
		movie.setPriceCode(Movie.REGULAR);
		assertEquals("Incorrect title", Movie.REGULAR, movie.getPriceCode()); 
	}


}
