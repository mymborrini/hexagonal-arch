package dev.skynet.alpha.adapters.out.repositories;

import dev.skynet.alpha.adapters.out.entities.MovieE;
import dev.skynet.alpha.adapters.out.mapper.MovieEMapper;
import dev.skynet.alpha.application.remote.MovieDao;
import dev.skynet.alpha.model.Movie;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieDaoImpl implements MovieDao {

  private final MovieERepository movieERepository;

  public MovieDaoImpl(MovieERepository movieERepository) {
    this.movieERepository = movieERepository;
  }


  @Override
  public List<Movie> findAllMovies() {
    List<MovieE> allMovies = movieERepository.findAll();
    return MovieEMapper.MAPPER.movie(allMovies);
  }

  @Override
  public Optional<Movie> findByTitle(@NonNull String title) {

    Optional<MovieE> movieEByTitle = movieERepository.findByTitle(title);

    return movieEByTitle.map(MovieEMapper.MAPPER::movie);
  }

  @Override
  public Movie save(@NonNull Movie movie) {
    return MovieEMapper.MAPPER.movie(movieERepository.save(MovieEMapper.MAPPER.movieE(movie)));
  }
}
