package com.ProyectoSergi.Proyecto.controller;


import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.League;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.service.CommentService;
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
    private CommentService commentService;

    public GameController(GameService gameService, LeagueService leagueService, CommentService commentService) {
        this.gameService = gameService;
        this.leagueService = leagueService;
        this.commentService = commentService;
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
            model.addAttribute("comments", commentService.getComments("GAME", id));
            return "cards/cardGame";
        }
        return  "/lists/listGames";
    }


}
