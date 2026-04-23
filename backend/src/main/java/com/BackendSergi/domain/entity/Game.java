package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_image_url")
    private String gameImageUrl;

    public Game(){
    }

    public Game(String gameName, String gameImageUrl) {
        this.gameName = gameName;
        this.gameImageUrl = gameImageUrl;
    }
    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer game_id) {
        this.gameId = game_id;
    }

    public String getGameName(){
        return gameName;
    }
    public void setGameName(String gameName){
        this.gameName = gameName;
    }

    public String getGameImageUrl() {
        return gameImageUrl;
    }
    public void setGameImageUrl(String gameImageUrl) {
        this.gameImageUrl = gameImageUrl;
    }
}
