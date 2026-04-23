package com.ProyectoSergi.Proyecto.controller;


import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.League;
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

    public LeagueController(LeagueService leagueService, GameService gameService) {
        this.leagueService = leagueService;
        this.gameService = gameService;
    }

    @GetMapping("")
    public String league(Model model) {
        List<League> leagues = leagueService.findAllCustomOrder();

        Map<Game, List<League>> leaguesByGame = leagues.stream()
                .collect(Collectors.groupingBy(League::getGame, LinkedHashMap::new, Collectors.toList()));
        model.addAttribute("leaguesByGame", leaguesByGame);
        return "lists/listCompetition";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("league", new League());
        model.addAttribute("games", gameService.findAll());
        return "forms/formCompetition";
    }

    @PostMapping("/save")
    public String saveLeague(@ModelAttribute League league) {
        leagueService.createLeague(league);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateLeague(Model model, @PathVariable Integer id) {
        Optional<League> leagues = leagueService.findById(id);
        if (leagues.isPresent()) {
            model.addAttribute("league", leagues.get());
            model.addAttribute("games", gameService.findAll());
            return "forms/formCompetition";
        }else{
        return "redirect:lists/listCompetition";
    }
    }

    @GetMapping("/delete/{id}")
    public String deleteLeague(@PathVariable Integer id) {
        leagueService.delete(id);
        return "redirect:lists/listCompetition";
    }
}
