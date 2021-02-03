package com.accenture.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@ToString(exclude = { "game" })
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "rules")
public class Rule implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name_rule")
  private String nameRule;

  @Column(name = "value")
  private String value;

  @ManyToOne(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE,
      CascadeType.DETACH,
      CascadeType.REFRESH
  })
  @JoinColumn(name = "game_id")
  private Game game;

}
