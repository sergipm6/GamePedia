package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findByTeamName(String name);
    Optional<Team> findById(Long id);
    List<Team> findAllByOrderByTrophiesDesc();
    @Query("SELECT t FROM Team t LEFT JOIN FETCH t.game LEFT JOIN FETCH t.league LEFT JOIN FETCH t.trainer")
    List<Team> findAllWithRelations();
}
