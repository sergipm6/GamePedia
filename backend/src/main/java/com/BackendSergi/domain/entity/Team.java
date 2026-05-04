package com.BackendSergi.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "team_name",  nullable = false)
    private String teamName;

    @Column(name = "team_created", updatable = false)
    private LocalDate teamCreated;

    @Column(name = "country")
    private String country;

    @Column(columnDefinition = "INT DEFAULT 0", name = "trophies")
    private Integer trophies;

    @Column(columnDefinition = "TEXT")
    private String history;

    @Column(name = "palmares")
    @ElementCollection
    private List<String> palmares = new ArrayList<>();

    @Column(name = "image_url", columnDefinition = "TEXT")
    private String imageUrl;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;

    @ManyToMany
    @JoinTable(
            name = "team_leagues",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id")
    )
    private List<League> leagues;

    @OneToOne(mappedBy = "team")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private  Game game;

    public Team() {}

    public Team(String teamName, String country, LocalDate teamCreated, Integer trophies, String history,
                List<String> palmares, String imageUrl, List<Player> players, Game game, List<League> leagues, Trainer trainer) {
        this.teamName = teamName;
        this.country = country;
        this.teamCreated = teamCreated;
        this.trophies = trophies;
        this.history = history;
        this.palmares = palmares;
        this.imageUrl = imageUrl;
        this.players = players;
        this.game = game;
        this.leagues = leagues;

    }

    public Long getTeamId() {
        return teamId;
    }
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    public String getTeamName() {
        return teamName;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public LocalDate getTeamCreated() {
        return teamCreated;
    }
    public void setTeamCreated(LocalDate teamCreated) {this.teamCreated = teamCreated;}
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
    public List<League> getLeagues() {
        return leagues;
    }
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }
    public Game getGame() {return game;}
    public void setGame(Game game) {this.game = game;}
    public String getHistory() {
        return history;
    }
    public void setHistory(String history) {
        this.history = history;
    }
    public Integer getTrophies() {
        return trophies;
    }
    public void setTrophies(int trophies) {
        this.trophies = trophies;
    }
    public List<String> getPalmares() {
        return palmares;
    }
    public void setPalmares(List<String> palmares) {
        this.palmares = palmares;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}