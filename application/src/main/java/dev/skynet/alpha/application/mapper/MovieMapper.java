package dev.skynet.alpha.application.mapper;

import dev.skynet.alpha.application.dto.NewMovie;
import dev.skynet.alpha.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {

  MovieMapper MAPPER = Mappers.getMapper(MovieMapper.class);
  Movie movie(NewMovie newMovie);

}
