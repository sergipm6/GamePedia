package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.Role;
import com.BackendSergi.domain.entity.User;
import com.BackendSergi.domain.repository.RoleRepository;
import com.BackendSergi.domain.repository.UserRepository;
import com.BackendSergi.domain.service.UserService;
import com.BackendSergi.domain.service.UserServiceImpl;
import com.ProyectoSergi.Proyecto.config.PasswordEncoderConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.Set;

@Controller
public class LoginController {

    private final UserServiceImpl userServiceIm;
    private final PasswordEncoderConfig passwordEncoderConfig;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public LoginController(UserServiceImpl userServiceIm, PasswordEncoderConfig passwordEncoderConfig,  UserRepository userRepository, RoleRepository roleRepository) {
        this.userServiceIm = userServiceIm;
        this.passwordEncoderConfig = passwordEncoderConfig;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login/register")
    public String register() {
        return "newUser";
    }

    @PostMapping("/login/register")
    public String register(@RequestParam String username,
                          @RequestParam String password,
                          @RequestParam String email) {

        if (userRepository.existsByUsername(username)) {
            return "redirect:/login?userExists";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoderConfig.passwordEncoder().encode(password));
        user.setEmail(email);
        userServiceIm.saveNewUser(user);
        return "redirect:/login?registered";
    }

}