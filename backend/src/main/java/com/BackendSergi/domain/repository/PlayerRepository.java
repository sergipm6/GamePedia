package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.Player;
import com.BackendSergi.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

     List<Player> findByPlayerEmail(String playeremail);
     List<Player> findByPlayerName(String playerName);
     List<Player> findAllByTeamTeamName(String teamName);

}