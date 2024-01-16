package dev.skynet.alpha.adapters.out.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class MovieE {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String title;
  private String description;

  @Column(name = "director_name")
  private String directorName;

  @Version
  private Integer version;

}
