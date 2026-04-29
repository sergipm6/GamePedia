package com.ProyectoSergi.Proyecto.controller;


import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.service.GameService;
import com.BackendSergi.domain.service.LeagueService;
import com.BackendSergi.domain.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/games")
public class GameController {

    private GameService gameService;
    private LeagueService leagueService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    //Get
    @GetMapping("")
    public String games(Model model){
        model.addAttribute("games", gameService.findAll());
        return "/lists/listGames";
    }
    @GetMapping("/{id}")
    public String team(@PathVariable Long id, Model model){
        Optional<Game> game = gameService.findById(id);
        if(game.isPresent()){
            model.addAttribute("game", game.get());
            return "cards/cardGame";
        }
        return  "/lists/listGames";
    }


}
