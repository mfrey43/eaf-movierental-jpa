package ch.fhnw.edu.rental.dto;

import ch.fhnw.edu.rental.mappers.DtoMapper;
import ch.fhnw.edu.rental.model.Movie;
import ch.fhnw.edu.rental.model.Rental;
import ch.fhnw.edu.rental.model.User;
import ch.fhnw.edu.rental.services.MovieService;
import ch.fhnw.edu.rental.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DtoUserServiceImpl implements DtoUserService {

    @Autowired
    DtoMapper mapper;

    @Autowired
    UserService userService;

    @Autowired
    MovieService movieService;

    @Override
    public UserDto getUserById(Long id) {
        return mapper.userToUserDto(userService.getUserById(id));
    }

    @Override
    public UserDto save(UserDto user) {
        userService.save(userService.getUserById(user.getId()));
        return user;
    }

    @Override
    public void deleteUser(UserDto user) {
        userService.deleteUser(userService.getUserById(user.getId()));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers().stream().map(mapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public List<UserDto> getUsersByName(String name) {
        return userService.getUsersByName(name).stream().map(mapper::userToUserDto).collect(Collectors.toList());
    }

    @Override
    public RentalDto rentMovie(UserDto user, MovieDto movie, int days) {
        User _user = userService.getUserById(user.getId());
        Movie _movie = movieService.getMovieById(movie.getId());
        Rental rental = userService.rentMovie(_user, _movie, days);
        return mapper.rentalToRentalDto(rental);
    }

    @Override
    public void returnMovie(UserDto user, MovieDto movie) {
        User _user = userService.getUserById(user.getId());
        Movie _movie = movieService.getMovieById(movie.getId());
        userService.returnMovie(_user, _movie);
    }
}
