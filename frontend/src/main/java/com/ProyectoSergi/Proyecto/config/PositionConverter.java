package com.ProyectoSergi.Proyecto.config;

import com.BackendSergi.domain.entity.Position;
import com.BackendSergi.domain.repository.PositionRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PositionConverter implements Converter<String, Position> {

    private final PositionRepository positionRepository;

    public PositionConverter(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public Position convert(String id) {
        if (id == null || id.isBlank()) return null;
        return positionRepository.findById((long) Integer.parseInt(id)).orElse(null);
    }
}
