package com.ProyectoSergi.Proyecto;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // <--- ESTO permite que Postman funcione
                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/cards/**", "/lists/**", "/index", "/templateFragments/**",
//                                "/static/**", "/login").permitAll()
//                        .requestMatchers("/forms/**").hasAnyRole("ADMIN")
                        .anyRequest().permitAll() // <--- ESTO permite entrar sin contraseña mientras desarrollas
                )
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/private", true)
//                        .permitAll())
//
//                .rememberMe(remember -> remember
//                        .tokenValiditySeconds(2419200))
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/"))
                .httpBasic(Customizer.withDefaults());


        return http.build();
    }
}
