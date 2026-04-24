package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Position;
import com.BackendSergi.domain.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    public Position getById(Long id) {
        return positionRepository.findById(id).orElse(null);
    }

    public Position getByName(String name) {
        return positionRepository.findByPositionName(name).stream().findFirst().orElse(null);
    }

    public void save(Position position) {
        positionRepository.save(position);
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
