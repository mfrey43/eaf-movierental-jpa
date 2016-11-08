package ch.fhnw.edu.rental.dto;

public class RentalDto {
	private long id;
	private int days;
	private long userId;
	private long movieId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String toString() {
		return String.format("RentalDTO(%s, %s, %s, %s)", id, days, userId, movieId);
	}
}
