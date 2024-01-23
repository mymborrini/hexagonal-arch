package dev.skynet.alpha.adapters.out.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "movies")
@Getter
@Setter
public class MovieE {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "director_name")
  private String directorName;

  @Version
  @Column(name = "version")
  private Integer version;

  @CreationTimestamp
  @Column(name = "creation_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDatetime;

  @UpdateTimestamp
  @Column(name = "last_update_datetime")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastUpdateDatetime;

}
