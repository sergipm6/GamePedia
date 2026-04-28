package com.BackendSergi.domain.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.jpa.repository.JpaRepository;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table (name = "leagues")
public class League {

    @Id
    @Column(name = "league_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leagueId;

    @Column(name = "league_name")
    private String leagueName;

    @Column(name = "league_description", columnDefinition = "TEXT")
    private String leagueDescription;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean international;

    @Column(name = "image_url")
    private String imageUrl;


    @ManyToMany(mappedBy = "leagues")
    private List<Team> teams;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;


    public League(String leagueName, String leagueDescription, Game game, Boolean international, String imageUrl) {
        this.leagueName = leagueName;
        this.leagueDescription = leagueDescription;
        this.game = game;
        this.international = international;
        this.imageUrl = imageUrl;
    }

    public League() {
    }

    public Long getLeagueId() {
        return leagueId;
    }
    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
    public String getLeagueName() {
        return leagueName;
    }
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }
    public String getLeagueDescription() {
        return leagueDescription;
    }
    public void setLeagueDescription(String leagueDescription) {
        this.leagueDescription = leagueDescription;
    }
    public List<Team> getTeams() {
        return teams;
    }
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public Boolean getInternational() {
        return international;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public Boolean isInternational() {
        return international != null && international;
    }
    public void setInternational(Boolean international) {
        this.international = international;
    }
}