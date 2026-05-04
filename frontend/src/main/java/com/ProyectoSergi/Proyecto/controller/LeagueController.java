package com.ProyectoSergi.Proyecto.controller;


import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.service.CommentService;
import com.BackendSergi.domain.service.GameService;
import com.BackendSergi.domain.service.LeagueService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("leagues")
public class LeagueController {


    private LeagueService leagueService;
    private GameService gameService;
    private CommentService commentService;

    public LeagueController(LeagueService leagueService, GameService gameService, CommentService commentService) {
        this.leagueService = leagueService;
        this.gameService = gameService;
        this.commentService = commentService;
    }

    @GetMapping("")
    public String league(Model model) {
        List<League> leagues = leagueService.findAllCustomOrder();

        Map<Game, List<League>> leaguesByGame = leagues.stream()
                .collect(Collectors.groupingBy(League::getGame, LinkedHashMap::new, Collectors.toList()));
        model.addAttribute("leagues", leaguesByGame);
        model.addAttribute("comments", commentService.findAll());
        return "lists/listCompetition";
    }

    @GetMapping("/{id}")
    public String leagueDetails(@PathVariable Long id, Model model) {
        Optional<League> leagues = leagueService.findById(id);

        if (leagues.isPresent()) {
            model.addAttribute("league", leagues.get());
            model.addAttribute("comments", commentService.getComments("LEAGUE", id));
            System.out.println(leagues);
            return "cards/cardCompetition";
        }

        return "lists/listCompetition";
    }
}
