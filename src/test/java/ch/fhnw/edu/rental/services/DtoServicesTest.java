package ch.fhnw.edu.rental.services;

import ch.fhnw.edu.rental.dto.*;
import ch.fhnw.edu.rental.model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(properties={"gui=false"})
@Transactional
public class DtoServicesTest {
	
	@Autowired
	private DtoMovieService movieService;

	@Autowired
	private DtoUserService userService;

	@Autowired
	private DtoRentalService rentalService;
	
	private Calendar currentDate;
	
	@Before
	public void setUp() {
		currentDate = Calendar.getInstance();
	    // Zero out the hour, minute, second, and millisecond
	    currentDate.set(Calendar.HOUR_OF_DAY, 0);
	    currentDate.set(Calendar.MINUTE, 0);
	    currentDate.set(Calendar.SECOND, 0);
	    currentDate.set(Calendar.MILLISECOND, 0);
	}

	@Test
	public void testGetAllMovies() {
		List<MovieDto> movies = movieService.getAllMovies();
		assertEquals(5, movies.size());

		movies.forEach(System.out::println);
	}

	@Test
	public void testGetAllRentals() {
		List<RentalDto> rentals = rentalService.getAllRentals();
		Assert.assertEquals(3, rentals.size());

		rentals.forEach(System.out::println);
	}

	@Test
	public void testGetAllUsers() {
		List<UserDto> users = userService.getAllUsers();
		assertEquals(4, users.size());

		users.forEach(System.out::println);
	}

}
