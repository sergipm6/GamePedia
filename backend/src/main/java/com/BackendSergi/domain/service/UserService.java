package com.BackendSergi.domain.service;

import com.BackendSergi.domain.entity.User;
import com.BackendSergi.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    public void delete(User user) {
        userRepository.delete(user);
    }
    public void save(User user) {
        userRepository.save(user);
    }
}
