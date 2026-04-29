package com.ProyectoSergi.Proyecto.config;

import com.BackendSergi.domain.repository.GameRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.BackendSergi.domain.entity.Game;

@Component
public class GameConverter implements Converter<String, Game> {
     private final GameRepository gameRepository;

     public GameConverter(GameRepository gameRepository) {
         this.gameRepository = gameRepository;
     }

     @Override
     public Game convert(String id) {
         if (id == null || id.isBlank()) return null;
         return gameRepository.findById(Long.parseLong(id)).orElse(null);
        }
}
