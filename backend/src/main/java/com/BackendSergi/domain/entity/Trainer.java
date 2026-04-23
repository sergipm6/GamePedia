package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "trainer_table")
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;

    public Trainer() {}
    public Trainer( String trainerName, String trainerCountry, Integer trainerAge, Team team) {
        this.trainerName = trainerName;
        this.trainerCountry = trainerCountry;
        this.trainerAge = trainerAge;
        this.team = team;
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
}
