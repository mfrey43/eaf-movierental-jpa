package ch.fhnw.edu.rental.persistence;

import java.util.List;

import ch.fhnw.edu.rental.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByTitle(String title);
}
