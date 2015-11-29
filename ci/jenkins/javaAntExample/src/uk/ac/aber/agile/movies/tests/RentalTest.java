package uk.ac.aber.agile.movies.tests;

import static org.junit.Assert.*;

import uk.ac.aber.agile.movies.Movie;
import uk.ac.aber.agile.movies.Rental;

import org.junit.Test;

public class RentalTest {

	@Test
	public void shouldBeInitialisedWithMovieAndRentedValues() {
		
		Movie movie = new Movie("Skyfall", Movie.NEW_RELEASE); 
		Rental rental = new Rental(movie, 2);
		
		assertSame("Incorrect movie", movie, rental.getMovie());
		assertEquals("Incorrect number of days rented", 2, rental.getDaysRented());
		
	}

}
