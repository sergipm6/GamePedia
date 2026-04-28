package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository  extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(Role.RoleName rolename);
}

