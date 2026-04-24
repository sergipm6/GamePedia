package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_image_url")
    private String gameImageUrl;

    @Column(name = "game_description", columnDefinition = "TEXT")
    private String gameDescription;

    @Column(name = "game_genre")
    private String gameGenre;

    @Column(name = "game_developer")
    private String gameDeveloper;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "main_competitions")
    private String mainCompetitions;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "game_leagues",
            joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "league_id", referencedColumnName = "league_id")
    )
    private Set<League> leagues;

    @Column(name = "peak_players")
    private String peakPlayers;


    public Game() {}

    public Game(String gameName, String gameImageUrl) {
        this.gameName = gameName;
        this.gameImageUrl = gameImageUrl;
    }

    public Game(String gameName, String gameImageUrl, String gameDescription,
                String gameGenre, String gameDeveloper, Integer releaseYear,
                String mainCompetitions, String peakPlayers, Set<League> leagues) {
        this.gameName = gameName;
        this.gameImageUrl = gameImageUrl;
        this.gameDescription = gameDescription;
        this.gameGenre = gameGenre;
        this.gameDeveloper = gameDeveloper;
        this.releaseYear = releaseYear;
        this.mainCompetitions = mainCompetitions;
        this.peakPlayers = peakPlayers;
        this.leagues = leagues;
    }


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameImageUrl() {
        return gameImageUrl;
    }

    public void setGameImageUrl(String gameImageUrl) {
        this.gameImageUrl = gameImageUrl;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public String getGameDeveloper() {
        return gameDeveloper;
    }

    public void setGameDeveloper(String gameDeveloper) {
        this.gameDeveloper = gameDeveloper;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMainCompetitions() {
        return mainCompetitions;
    }

    public void setMainCompetitions(String mainCompetitions) {
        this.mainCompetitions = mainCompetitions;
    }

    public String getPeakPlayers() {
        return peakPlayers;
    }

    public void setPeakPlayers(String peakPlayers) {
        this.peakPlayers = peakPlayers;
    }

    public Set<League> getLeagues() {
        return leagues;
    }

    public void setLeagues(Set<League> leagues) {
        this.leagues = leagues;
    }
}