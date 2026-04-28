package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.entity.Trainer;
import com.BackendSergi.domain.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
    public Optional<Trainer> findTrainerById(Long id) {
        return trainerRepository.findById(id);
    }
    public List<Trainer> findAllTrainers() {
        return trainerRepository.findAll();
    }
    public void assignTeamToTrainer(Long trainerId, Team team) {
        Trainer trainer = trainerRepository.findById(trainerId).orElseThrow();

        trainer.setTeam(team);
        team.setTrainer(trainer);

        trainerRepository.save(trainer);
    }

    public List<Trainer> findByTrainerNameContainingIgnoreCase (String trainerName) {
        return trainerRepository.findByTrainerNameContainingIgnoreCase(trainerName);
    }

    public List<Trainer> findByTrainerName(String trainerName) {
        return trainerRepository.findByTrainerName(trainerName);
    }
    public Trainer save(Trainer trainer) {
        return trainerRepository.save(trainer);
    }
    public void delete(Long id){
        trainerRepository.deleteById(id);
    }



}
