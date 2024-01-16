package dev.skynet.alpha.application.remote;

import dev.skynet.alpha.model.Movie;

import java.util.*;

public interface MovieDao {

  List<Movie> findAllMovies();

  Optional<Movie> findByTitle(String title);

  Movie save(Movie movie);
}
