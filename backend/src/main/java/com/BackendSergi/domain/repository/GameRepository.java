package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByGameNameIgnoreCase(String gameName);
    Boolean existsByGameNameIgnoreCase(String gameName);

}
