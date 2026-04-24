package com.BackendSergi.domain.repository;

import com.BackendSergi.domain.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    List<Trainer> findByTrainerName(String trainerName);
}
