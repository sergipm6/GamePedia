package com.ProyectoSergi.Proyecto.config;

import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.repository.LeagueRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LeagueConverter implements Converter<String, League> {

    private final LeagueRepository leagueRepository;

    public LeagueConverter(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public League convert(String id) {
        if (id == null || id.isBlank()) return null;
        return leagueRepository.findById(Long.parseLong(id)).orElse(null);
    }
}