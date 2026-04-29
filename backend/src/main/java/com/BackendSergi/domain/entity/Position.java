package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer positionId;

    @Column(name = "rol_name")
    private String positionName;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @OneToMany(mappedBy = "position")
    private List<Player> players;

    public Position(){}

    public Position(String positionName, Game game,  List<Player> players) {
        this.positionName = positionName;
        this.game = game;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
