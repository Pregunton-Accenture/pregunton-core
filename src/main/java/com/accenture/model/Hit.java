package com.accenture.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = { "player" })
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hits")
public class Hit implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "guess")
  private String guess;

  @Column(name = "is_correct")
  private Boolean isCorrect;

  @Column(name = "published")
  private LocalDateTime published;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_player")
  @JsonIgnore
  private Player player;

}
