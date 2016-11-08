package ch.fhnw.edu.rental.dto;

import ch.fhnw.edu.rental.model.PriceCategory;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MovieDto {
	private long id;
	private String title;
	private Date releaseDate;
	private boolean rented;
	private PriceCategory priceCategory;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public PriceCategory getPriceCategory() {
		return priceCategory;
	}

	public void setPriceCategory(PriceCategory priceCategory) {
		this.priceCategory = priceCategory;
	}

	public String toString() {
		return String.format("MovieDTO(%s, %s, %s, %s)", id, title, releaseDate, priceCategory);
	}
}
