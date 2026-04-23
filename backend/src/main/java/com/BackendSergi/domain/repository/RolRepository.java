package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    List<Rol> findByRolName(String name);
}
