package com.BackendSergi.domain.entity;
import jakarta.persistence.*;


@Entity
@Table(name = "players")
public class  Player {

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column(name = "username")
    private String username;

    @Column(name = "age")
    private Integer age;

    @Column(name = "country")
    private String country;


    @Column(name = "player_name")
    private String playerName;

    @Column(name = "player_email")
    private String playerEmail;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Player() {}

    public Player(int playerId, String username, String playerName, String playerEmail, Position position, Team team,  Game game, Integer age, String country, String imageUrl) {
        this.playerId = playerId;
        this.username = username;
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.team = team;
        this.position = position;
        this.game = game;
        this.age = age;
        this.country = country;
        this.imageUrl = imageUrl;
    }
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public String getPlayerEmail() {
        return playerEmail;
    }
    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }
    public Position getPosition() {return position;}
    public void setPosition(Position position) {
        this.position = position;
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
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}