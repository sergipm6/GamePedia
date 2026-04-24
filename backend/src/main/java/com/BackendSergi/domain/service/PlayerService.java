package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Player;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.repository.LeagueRepository;
import com.BackendSergi.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    public List<Player> findByPlayerName(String playerName) {
        return playerRepository.findByPlayerName(playerName);
    }
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
    public Optional<Player> findById(Long id) {
        return playerRepository.findById(id);
    }
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
    public void delete(Player player) {
        playerRepository.delete(player);
    }
    public void deleteByid(Long id) {
        playerRepository.deleteById(id);
    }
    public List<Player> findByTeam(String teamName) {
        return playerRepository.findAllByTeamTeamName(teamName);
    }
}
