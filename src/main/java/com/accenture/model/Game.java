package com.accenture.model;

import com.accenture.pojo.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {
    "players",
    "questions",
    "rules"
})
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

  @Column(name = "master")
  private String master;

  @Column(name = "code")
  private String code;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(name = "hit")
  private String hit;

  @OneToOne
  @JoinColumn(name = "rules_id")
  private Rules rules;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private GameStatus status;

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
