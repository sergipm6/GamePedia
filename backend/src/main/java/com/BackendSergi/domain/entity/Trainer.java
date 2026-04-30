package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "trainer_name")
    private String trainerName;

    @Column(name = "trainer_country")
    private String trainerCountry;

    @Column(name = "trainer_age")
    private Integer trainerAge;

    @Column (name = "image_url")
    private String imageUrl;

    @OneToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Trainer() {}
    public Trainer( String trainerName, String trainerCountry, Integer trainerAge, Team team, Game game,  String imageUrl) {
        this.trainerName = trainerName;
        this.trainerCountry = trainerCountry;
        this.trainerAge = trainerAge;
        this.team = team;
        this.game = game;
        this.imageUrl = imageUrl;
    }

    public Integer getTrainerId() {
        return id;
    }
    public void setTrainerId(Integer id) {
        this.id = id;
    }
    public String getTrainerName() {
        return trainerName;
    }
    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    public String getTrainerCountry() {
        return trainerCountry;
    }
    public void setTrainerCountry(String trainerCountry) {
        this.trainerCountry = trainerCountry;
    }
    public Integer getTrainerAge() {
        return trainerAge;
    }
    public void setTrainerAge(Integer trainerAge) {
        this.trainerAge = trainerAge;
    }
    public Team getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }
    public Game getGame() {
        return game;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
