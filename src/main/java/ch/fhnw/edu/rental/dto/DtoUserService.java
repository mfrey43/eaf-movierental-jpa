package ch.fhnw.edu.rental.dto;

import java.util.List;

public interface DtoUserService {
    UserDto getUserById(Long id);
    UserDto save(UserDto user);
    void deleteUser(UserDto user);
    List<UserDto> getAllUsers();
    List<UserDto> getUsersByName(String name);
    RentalDto rentMovie(UserDto user, MovieDto movie, int days);
    void returnMovie(UserDto user, MovieDto movie);
}
