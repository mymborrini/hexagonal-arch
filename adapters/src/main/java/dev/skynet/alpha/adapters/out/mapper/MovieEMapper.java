package dev.skynet.alpha.adapters.out.mapper;

import dev.skynet.alpha.adapters.out.entities.MovieE;
import dev.skynet.alpha.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieEMapper {

  MovieEMapper MAPPER = Mappers.getMapper(MovieEMapper.class);

  List<Movie> movie(List<MovieE> movieE);
  Movie movie(MovieE movieE);

  MovieE movieE(Movie movie);

}
