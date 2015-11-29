package uk.ac.aber.agile.movies;

import java.util.ArrayList;

/** 
 * This class is a reworked version of the example code in 
 * Refactoring, by Martin Fowler. This follows the code in the book 
 * very closely, but updates this to more recent Java constructs. 
 * 
 * This version represents one of the possible solutions. It mostly 
 * follows the refactorings in the book, but uses ExtractMethod to 
 * remove some duplication in the two methods to generate a statement.  
 * 
 * @author Martin Fowler
 * @author Neil Taylor (nst@aber.ac.uk) Ammendments for exercise.
 */
public class Customer {

	private String name;
	
	private ArrayList<Rental> customerRentals = new ArrayList<Rental>(); 
	
	public Customer(String name) { 
		this.name = name; 
	}
	
	public void addRental(Rental arg) { 
	   customerRentals.add(arg); 	
	}
	
	public String getName() { 
		return name; 
	}
	
	public String getStatement() { 
		
		String result = "Rental Record for " + getName() + "\n";
		
		if(customerRentals.size() == 0) { 
			result += "\tNo items rented.\n";
		} else {
			for (Rental rental : customerRentals) {
				result += "\t" + rental.getMovie().getTitle() + "\t"
						+ String.valueOf(rental.getCharge()) + "\n";
			}
		}
		
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned " + 
		           String.valueOf(getFrequentRenterPoints()) +
		           " frequent renter points"; 		
		return result; 
	}
	
    public String getHtmlStatement() { 
		
		String result = "<h1>Rental Record for " + getName() + "</h1>";
		
		if(customerRentals.size() == 0) { 
			result += "<p class=\"item\">No items rented.</p>";
		} else {
			for (Rental rental : customerRentals) {
				result += "<p class=\"item\">" + 
						rental.getMovie().getTitle() + " - "
						+ String.valueOf(rental.getCharge()) + "</p>";
			}
		}
		
		result += "<p>Amount owed is " + String.valueOf(getTotalAmount()) + "</p>";
		result += "<p>You earned " + 
           String.valueOf(getFrequentRenterPoints()) +
           " frequent renter points" + "</p>";
		
		return result;
	}
    
    private double getTotalAmount() {
		int amount = 0; 
		for(Rental rental : customerRentals) { 
		   amount += rental.getCharge();
		}
		return amount; 
	}
	
	private int getFrequentRenterPoints() {
		int points = 0; 
		for(Rental rental : customerRentals) { 
		   points += rental.getFrequentRenterPoints();
		}
		return points; 
	}
}
