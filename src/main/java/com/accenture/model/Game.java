package com.accenture.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "games")
public class Game implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "master_id")
  private Long MasterId;

  @Column(name = "code")
  private String code;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(name = "hit")
  private String hit;

  @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
  private Set<Rule> rules;

  @ManyToMany(cascade = {
      CascadeType.MERGE,
      CascadeType.DETACH
  })
  @JoinTable(name = "games_players",
             joinColumns = @JoinColumn(name = "id_game", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "id_player", referencedColumnName = "id"))
  private List<Player> players;

  @ManyToMany(cascade = {
      CascadeType.MERGE,
      CascadeType.DETACH
  })
  @JoinTable(name = "games_questions",
             joinColumns = @JoinColumn(name = "id_game", referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(name = "id_question", referencedColumnName = "id"))
  private List<Question> questions;

}
