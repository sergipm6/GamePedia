package com.ProyectoSergi.Proyecto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final GameConverter gameConverter;
    private final LeagueConverter leagueConverter;
    private final PositionConverter positionConverter;

    public WebConfig(GameConverter gameConverter,  LeagueConverter leagueConverter,  PositionConverter positionConverter) {
        this.gameConverter = gameConverter;
        this.leagueConverter = leagueConverter;
        this.positionConverter = positionConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(gameConverter);
        registry.addConverter(leagueConverter);
        registry.addConverter(positionConverter);
    }
}