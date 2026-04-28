package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.Role;
import com.BackendSergi.domain.entity.User;
import com.BackendSergi.domain.repository.RoleRepository;
import com.BackendSergi.domain.repository.UserRepository;
import com.BackendSergi.domain.entity.Role.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public User saveNewUser(User user) {

        Role userRole = roleRepository.findByRoleName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: El Rol USER no fue encontrado."));

        user.setRole(Set.of(userRole));

        return userRepository.save(user);
    }

}
