package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.repository.LeagueRepository;
import com.BackendSergi.domain.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAllWithRelations();
    }

    public Optional<Team> findById(long id) {
        return teamRepository.findById(id);
    }

    public Optional<Team> findByName(String name) {
        return teamRepository.findByTeamName(name);
    }

    public List<Team> findAllByOrderTrophiesDesc() {
        return teamRepository.findAllByOrderByTrophiesDesc();
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public void delete(Team team) {
        teamRepository.delete(team);
    }
    public void deleteById(long id) {
        teamRepository.deleteById(id);
    }
}
