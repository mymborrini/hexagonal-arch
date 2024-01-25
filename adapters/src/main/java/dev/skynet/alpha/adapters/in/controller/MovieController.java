package dev.skynet.alpha.adapters.in.controller;

import dev.skynet.alpha.application.dto.NewMovie;
import dev.skynet.alpha.application.services.MovieService;
import dev.skynet.alpha.model.Movie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }


  @GetMapping
  public List<Movie> findAllMovies(){
    log.info("Application latest version v1");
    return movieService.findAllMovies();
  }


  @PostMapping
  public void insertNewMovie(@RequestBody NewMovie newMovie){
    movieService.insertNewMovie(newMovie);
  }


}
