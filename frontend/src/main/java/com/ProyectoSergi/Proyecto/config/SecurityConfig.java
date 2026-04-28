package com.ProyectoSergi.Proyecto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
public class SecurityConfig {

        private UserDetailsService userService;
        private PasswordEncoderConfig passwordEncoderConfig;
        private CustomSuccessHandler customSuccessHandler;

    public SecurityConfig(UserDetailsService userService, PasswordEncoderConfig passwordEncoderConfig,  CustomSuccessHandler customSuccessHandler) {
        this.userService = userService;
        this.passwordEncoderConfig = passwordEncoderConfig;
        this.customSuccessHandler = customSuccessHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .userDetailsService(userService)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/login/**",
                                "/styles.css",
                                "/templates/**",
                                "/*.css", "/*.js",
                                "/webjars/**",
                                "/templateFragments/**",
                                 "/index").permitAll()
                        .requestMatchers("/forms/**","/admin/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .successHandler(customSuccessHandler)
                        .permitAll())

                .rememberMe(remember -> remember
                        .tokenValiditySeconds(2419200))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/"));


        return http.build();
    }

}
