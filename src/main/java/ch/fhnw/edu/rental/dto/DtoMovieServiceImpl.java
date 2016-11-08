package ch.fhnw.edu.rental.dto;

import ch.fhnw.edu.rental.mappers.DtoMapper;
import ch.fhnw.edu.rental.services.MovieService;
import ch.fhnw.edu.rental.services.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DtoMovieServiceImpl implements DtoMovieService {

    @Autowired
    private MovieService movieService;

    @Autowired
    DtoMapper mapper;

    public void DtoMovieService(){
        movieService = new MovieServiceImpl();
    }


    @Override
    public List<MovieDto> getAllMovies() {
        return movieService.getAllMovies().stream().map(mapper::movieToMovieDto).collect(Collectors.toList());
    }

    @Override
    public MovieDto getMovieById(Long id) {
        return mapper.movieToMovieDto(movieService.getMovieById(id));
    }

    @Override
    public Long saveOrUpdateMovie(MovieDto movie) {
        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        movieService.deleteMovie(movieService.getMovieById(id));
    }
}
