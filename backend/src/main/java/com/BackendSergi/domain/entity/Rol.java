package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolId;

    @Column(name = "rol_name")
    private String rolName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id",  nullable = false)
    private Game game;

    public Rol(){}

    public Rol(String rol_name, Game game) {
        this.rolName = rol_name;
        this.game = game;
    }

    public Integer getRol_id() {
        return rolId;
    }

    public void setRol_id(Integer rol_id) {
        this.rolId = rol_id;
    }

    public String getRol_name() {
        return rolName;
    }

    public void setRol_name(String rol_name) {
        this.rolName = rolName;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
