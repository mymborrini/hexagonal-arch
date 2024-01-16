package dev.skynet.alpha.adapters.out.repositories;

import dev.skynet.alpha.adapters.out.entities.MovieE;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieERepository extends JpaRepository<MovieE, Long> {

  Optional<MovieE> findByTitle(@NonNull String title);

}
