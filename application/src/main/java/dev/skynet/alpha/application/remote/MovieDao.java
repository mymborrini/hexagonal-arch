package dev.skynet.alpha.application.remote;

import dev.skynet.alpha.model.Movie;
import lombok.NonNull;

import java.util.*;

public interface MovieDao {

  List<Movie> findAllMovies();

  Optional<Movie> findByTitle(@NonNull String title);

  Movie save(@NonNull Movie movie);
}
