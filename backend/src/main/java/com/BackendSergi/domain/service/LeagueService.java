package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<League> findAll() {
        return leagueRepository.findAll();
    }

    public Optional<League> findById(Integer id) {
        return leagueRepository.findByLeagueId(id);
    }

    public Optional<League> findByLeagueName(String leaguename) {
        return leagueRepository.findByLeagueName(leaguename);
    }

    public List<League> findAllCustomOrder() {
        return leagueRepository.findAllCustomOrder();
    }

    public League createLeague(League league) {
        return leagueRepository.save(league);
    }


    public void delete(Integer id) {
        leagueRepository.deleteByLeagueId(id);
    }

}
