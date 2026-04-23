package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Rol;
import com.BackendSergi.domain.repository.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    private RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    public Rol getById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol getByName(String name) {
        return rolRepository.findByRolName(name).stream().findFirst().orElse(null);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    public void delete(Long id) {
        rolRepository.deleteById(id);
    }
}
