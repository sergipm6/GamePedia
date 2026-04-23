package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LeagueRepository extends JpaRepository<League, Long > {

    Optional<League> findByLeagueName(String name);
    Optional<League> findByLeagueId(Integer id);
    Integer deleteByLeagueId(Integer id);

    @Query("SELECT l FROM League l ORDER BY l.game.gameName ASC, l.international DESC, l.leagueName ASC")
    List<League> findAllCustomOrder();

}
