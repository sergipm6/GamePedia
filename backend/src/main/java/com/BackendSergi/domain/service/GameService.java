package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public List<Game> findAll(){
        return gameRepository.findAll();
    }

    public Optional<Game> findById(Long id) {
        return gameRepository.findById(id);
    }

    public List<Game> findByGameName(String gameName){
        return gameRepository.findByGameNameIgnoreCase(gameName);
    }

    public boolean existsByName(String name) {
        return gameRepository.existsByGameNameIgnoreCase(name);
    }

    public long countTotalGames() {
        return gameRepository.count();
    }

    public List<Game> findByGameNameContainingIgnoreCase(String gameName){
        return gameRepository.findByGameNameContainingIgnoreCase(gameName);
    }

    @Transactional
    public void deleteById(Long id){
         gameRepository.deleteById(id);
    }

    @Transactional
    public Game save(Game game){
        return gameRepository.save(game);
    }

}
