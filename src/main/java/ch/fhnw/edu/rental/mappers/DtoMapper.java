package ch.fhnw.edu.rental.mappers;

import ch.fhnw.edu.rental.dto.MovieDto;
import ch.fhnw.edu.rental.dto.RentalDto;
import ch.fhnw.edu.rental.dto.UserDto;
import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.model.Rental;
import ch.fhnw.edu.rental.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface DtoMapper {

	@Mapping(source = "rentals", target = "rentalIds")
	UserDto userToUserDto(User user);

	@Mapping(source = "user.id", target = "userId")
	@Mapping(source = "movie.id", target = "movieId")
	RentalDto rentalToRentalDto(Rental rental);

	MovieDto movieToMovieDto(Movie movie);
	
	default Long rentalToLong(Rental r) {
		return r.getId();
	}

}
