package com.BackendSergi.domain.config;

import ch.qos.logback.core.encoder.Encoder;
import com.BackendSergi.domain.entity.Role;
import com.BackendSergi.domain.entity.User;
import com.BackendSergi.domain.repository.RoleRepository;
import com.BackendSergi.domain.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (roleRepository.count() == 0) {
            roleRepository.save(new Role(Role.RoleName.ROLE_USER));
            roleRepository.save(new Role(Role.RoleName.ROLE_ADMIN));
        }

        if(userRepository.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("admin@mail.com");

            Role adminRole = roleRepository.findByRoleName(Role.RoleName.ROLE_ADMIN)
                    .orElseThrow(() -> new RuntimeException("Error: El Rol ADMIN no fue encontrado."));
            admin.setRole(Set.of(adminRole));

            userRepository.save(admin);
            System.out.println("admin creado: admin / admin");
        }
    }


}
