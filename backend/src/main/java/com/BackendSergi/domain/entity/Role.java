package com.BackendSergi.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false, name = "role_name")
    private RoleName roleName;

    public enum RoleName {
        ROLE_USER,
        ROLE_ADMIN
    }



    public Role() {}
    public Role(RoleName roleName) {
        this.roleName = roleName;
    }
    public RoleName getRoleName() {
        return roleName;
    }
    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
