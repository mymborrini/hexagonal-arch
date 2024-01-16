package dev.skynet.alpha.application.services;

import dev.skynet.alpha.application.dto.NewMovie;
import dev.skynet.alpha.application.mapper.MovieMapper;
import dev.skynet.alpha.application.remote.MovieDao;
import dev.skynet.alpha.exceptions.ItemAlreadyExistsException;
import dev.skynet.alpha.exceptions.MissingBeanException;
import dev.skynet.alpha.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

  private final Optional<MovieDao> movieDaoOp;

  public MovieService(Optional<MovieDao> movieDaoOp) {
    this.movieDaoOp = movieDaoOp;
  }

  public MovieDao getMovieDao() {
    return movieDaoOp.orElseThrow(() -> new MissingBeanException("MovieDao bean not found"));
  }

  public List<Movie> findAllMovies(){
    return getMovieDao().findAllMovies();
  }

  public Movie insertNewMovie(NewMovie newMovie){
    Optional<Movie> moviePersisted = getMovieDao().findByTitle(newMovie.title());
    if (moviePersisted.isPresent()) {
      throw new ItemAlreadyExistsException("A movie with title %s already exists", newMovie.title());
    }

    return getMovieDao().save(MovieMapper.MAPPER.movie(newMovie));

  }


}

