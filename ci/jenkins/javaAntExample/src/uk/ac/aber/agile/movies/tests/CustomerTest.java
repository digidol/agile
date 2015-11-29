package uk.ac.aber.agile.movies.tests;

import static org.junit.Assert.*;

import uk.ac.aber.agile.movies.Customer;
import uk.ac.aber.agile.movies.Movie;
import uk.ac.aber.agile.movies.Rental;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

private Customer customer; 
	
	@Before 
	public void setup() { 
		customer = new Customer("Jo"); 
	}
	
	@Test 
	public void shouldBeInitialisedWithSpecifiedName() { 
		assertEquals("Incorrect Name", "Jo", customer.getName()); 
	}
	
	@Test 
	public void shouldGenerateStatementForZeroItems() { 
		String statement = "Rental Record for Jo\n\tNo items rented.\n" + 
				  "Amount owed is 0.0\nYou earned 0 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement());
	}
	
	@Test
	public void shouldGenerateStatementForOneNewReleaseRentalForOneDay() { 
		Movie movie = new Movie("The Immitation Game", Movie.NEW_RELEASE); 
		
		Rental rental = new Rental(movie, 1);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tThe Immitation Game\t3.0\n" + 
		  "Amount owed is 3.0\nYou earned 1 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForOneNewReleaseRentalForTwoDays() { 
		Movie movie = new Movie("The Immitation Game", Movie.NEW_RELEASE); 
		
		Rental rental = new Rental(movie, 2);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tThe Immitation Game\t6.0\n" + 
		  "Amount owed is 6.0\nYou earned 2 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	} 
	
	@Test
	public void shouldGenerateStatementForOneChildrensRentalForTwoDays() { 
		Movie movie = new Movie("Arthur Christmas", Movie.FAMILY); 
		
		Rental rental = new Rental(movie, 2);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tArthur Christmas" + 
		  "\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForOneChildrensRentalForThreeDays() { 
		Movie movie = new Movie("Arthur Christmas", Movie.FAMILY); 
		
		Rental rental = new Rental(movie, 3);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tArthur Christmas" + 
		  "\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForOneChildrensRentalForMoreThanThreeDays() { 
		Movie movie = new Movie("Arthur Christmas", Movie.FAMILY); 
		
		Rental rental = new Rental(movie, 4);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tArthur Christmas" + 
		  "\t2.5\nAmount owed is 2.5\nYou earned 1 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForOneRegularRental() { 
		Movie movie = new Movie("The Artist", Movie.REGULAR); 
		
		Rental rental = new Rental(movie, 2);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tThe Artist\t2.0\n" + 
		  "Amount owed is 2.0\nYou earned 1 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForOneRegularRentalForMoreThanTwoDays() { 
		Movie movie = new Movie("The Immitation Game", Movie.REGULAR); 
		
		Rental rental = new Rental(movie, 3);
		customer.addRental(rental); 
		
		String statement = "Rental Record for Jo\n\tThe Immitation Game\t3.5\n" + 
		  "Amount owed is 3.5\nYou earned 1 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test
	public void shouldGenerateStatementForMultipleMovies() { 
		Movie newReleaseMovie = new Movie("The Immitation Game", Movie.NEW_RELEASE); 
		Movie childrensMovie = new Movie("Frozen", Movie.FAMILY);
		Movie regularMovie = new Movie("Skyfall", Movie.REGULAR);
		
		customer.addRental(new Rental(newReleaseMovie, 2)); 
		customer.addRental(new Rental(childrensMovie, 1)); 
		customer.addRental(new Rental(regularMovie, 1)); 
		
		String statement = "Rental Record for Jo\n\tThe Immitation Game\t6.0\n" +
		  "\tFrozen\t1.5\n" + 
		  "\tSkyfall\t2.0\n" + 
		  "Amount owed is 9.5\nYou earned 4 frequent renter points";
		assertEquals("Incorrect statement", statement, customer.getStatement()); 
	}
	
	@Test 
	public void shouldGenerateHtmlStatementForZeroItems() { 
		String statement = "<h1>Rental Record for Jo</h1><p class=\"item\">No items rented.</p>" + 
				  "<p>Amount owed is 0.0</p><p>You earned 0 frequent renter points</p>";
		assertEquals("Incorrect statement", statement, customer.getHtmlStatement());
	}
	
	@Test
	public void shouldGenerateHtmlStatementForMultipleMovies() { 
		Movie newReleaseMovie = new Movie("The Immitation Game", Movie.NEW_RELEASE); 
		Movie childrensMovie = new Movie("Frozen", Movie.FAMILY);
		Movie regularMovie = new Movie("Skyfall", Movie.REGULAR);
		
		customer.addRental(new Rental(newReleaseMovie, 2)); 
		customer.addRental(new Rental(childrensMovie, 1)); 
		customer.addRental(new Rental(regularMovie, 1)); 
		
		String statement = "<h1>Rental Record for Jo</h1><p class=\"item\">The Immitation Game - 6.0</p>" +
		  "<p class=\"item\">Frozen - 1.5</p>" + 
		  "<p class=\"item\">Skyfall - 2.0</p>" + 
		  "<p>Amount owed is 9.5</p><p>You earned 4 frequent renter points</p>";
		assertEquals("Incorrect statement", statement, customer.getHtmlStatement()); 
	}

}
