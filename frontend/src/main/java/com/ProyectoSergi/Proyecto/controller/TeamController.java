package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.service.CommentService;
import com.BackendSergi.domain.service.GameService;
import com.BackendSergi.domain.service.LeagueService;
import com.BackendSergi.domain.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;
    private final GameService gameService;
    private final LeagueService leagueService;
    private final CommentService commentService;

    public TeamController(TeamService teamService,  GameService gameService, LeagueService leagueService,  CommentService commentService) {
        this.teamService = teamService;
        this.gameService = gameService;
        this.leagueService = leagueService;
        this.commentService = commentService;
    }


    @GetMapping("")
    public String listTeams(Model model) {
        List<Team> allTeams = teamService.findAllByOrderTrophiesDesc();

        Map<Game, List<Team>> teamsByTrophies = allTeams.stream()
                .filter(t -> t.getGame() != null && t.getGame().getGameName() != null)
                .sorted((a,b) -> {
                    Integer t1 = a.getTrophies() != null ? a.getTrophies() : 0;
                    Integer t2 = b.getTrophies() != null ? b.getTrophies() : 0;
                    return t2.compareTo(t1);
                })
                        .collect(Collectors.groupingBy(Team::getGame,
                                LinkedHashMap::new,
                                Collectors.toList()));


        model.addAttribute("teamsByTrophies", teamsByTrophies);
        return "lists/listTeams";

    }

    @GetMapping("/{id}")
    public String team(@PathVariable Long id, Model model){
       Optional<Team> team = teamService.findById(id);
        if(team.isPresent()){
            model.addAttribute("team", team.get());
            model.addAttribute("game", team.get().getGame());
            model.addAttribute("leagues", team.get().getLeagues());
            model.addAttribute("trainer",  team.get().getTrainer());
            model.addAttribute("comment", commentService.getComments("TEAM", id));
            return "cards/cardTeam";
        }
        return  "redirect:/";
    }



}