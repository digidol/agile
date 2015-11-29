package uk.ac.aber.agile.movies;

public class Movie {

	public static final int FAMILY = 2; 
	public static final int REGULAR = 1; 
	public static final int NEW_RELEASE = 0; 
	
	private String title; 
	private int priceCode; 
	
	public Movie(String title, int priceCode) { 
		this.title = title; 
		this.priceCode = priceCode; 
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
}

