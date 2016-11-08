package ch.fhnw.edu.rental.persistence;

import java.util.List;

import ch.fhnw.edu.rental.model.Rental;
import ch.fhnw.edu.rental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
	List<Rental> findByUser(User user);
}
