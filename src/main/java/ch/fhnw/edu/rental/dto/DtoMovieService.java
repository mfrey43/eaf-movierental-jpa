package ch.fhnw.edu.rental.dto;

import java.util.List;

public interface DtoMovieService {
    List<MovieDto> getAllMovies();
    MovieDto getMovieById(Long id);
    Long saveOrUpdateMovie(MovieDto movie);
    void deleteMovie(Long id);
}
