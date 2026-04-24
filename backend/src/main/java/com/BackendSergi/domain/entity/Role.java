package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rolId;

    @Column(unique = true,  nullable = false)
    private String rolName;

    public Role() {}
    public Role(String rolName) {
        this.rolName = rolName;
    }
    public String getRolName() {
        return rolName;
    }
    public void setRolName(String rolName) {
        this.rolName = rolName;
    }
    public Long getRolId() {
        return rolId;
    }
    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }
}
