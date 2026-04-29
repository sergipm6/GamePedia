package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.*;
import com.BackendSergi.domain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("admin")
public class AdminController {

    private UserService userService;
    private GameService gameService;
    private LeagueService leagueService;
    private PlayerService playerService;
    private PositionService positionService;
    private TeamService teamService;
    private TrainerService trainerService;

    public AdminController(UserService userService, GameService gameService, LeagueService leagueService,
                           PlayerService playerService, PositionService positionService,
                           TeamService teamService, TrainerService trainerService) {
        this.userService = userService;
        this.gameService = gameService;
        this.leagueService = leagueService;
        this.playerService = playerService;
        this.positionService = positionService;
        this.teamService = teamService;
        this.trainerService = trainerService;
    }

    // ── Dashboard ──────────────────────────────────────────
    @GetMapping("")
    public String dashboard(Model model) {
        model.addAttribute("games", gameService.findAll());
        model.addAttribute("leagues", leagueService.findAll());
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("teams", teamService.findAll());
        return "private/dashboard";
    }

    // ── Games ──────────────────────────────────────────────
    @GetMapping("/newGame")
    public String showGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "forms/formGames";
    }

    @PostMapping("/saveGame")
    public String saveGame(@ModelAttribute Game game,
                           @RequestParam(value = "positionNames", required = false)
                           List<String> positionNames) {

        if (positionNames != null && !positionNames.isEmpty()) {
            List<Position> positions = positionNames.stream()
                    .map(name -> {
                        Position p = new Position();
                        p.setPositionName(name);
                        p.setGame(game);
                        return p;
                    })
                    .collect(Collectors.toList());
            game.setPositions(positions);
        } else {
            game.setPositions(new ArrayList<>());
        }

        gameService.save(game);
        return "redirect:/games";
    }

    @GetMapping("/editGame/{id}")
    public String editGame(@PathVariable Long id, Model model) {
        gameService.findById(id).ifPresent(game -> model.addAttribute("game", game));
        return "forms/formGames";
    }

    @GetMapping("/deleteGame/{id}")
    public String deleteGame(@PathVariable Long id) {
        gameService.deleteById(id);
        return "redirect:/games";
    }

    // ── Leagues ────────────────────────────────────────────
    @GetMapping("/newLeague")
    public String showLeagueForm(Model model) {
        model.addAttribute("league", new League());
        model.addAttribute("games", gameService.findAll());
        return "forms/formCompetition";
    }

    @PostMapping("/saveLeague")
    public String saveLeague(@ModelAttribute League league) {
        leagueService.createLeague(league);
        return "redirect:/admin";
    }

    @GetMapping("/editLeague/{id}")
    public String editLeague(@PathVariable Long id, Model model) {
        leagueService.findById(id).ifPresent(league -> model.addAttribute("league", league));
        model.addAttribute("games", gameService.findAll());
        return "forms/formCompetition";
    }

    @GetMapping("/deleteLeague/{id}")
    public String deleteLeague(@PathVariable Long id) {
        leagueService.delete(id);
        return "redirect:/admin";
    }

    // ── Teams ──────────────────────────────────────────────
    @GetMapping("/newTeam")
    public String showTeamForm(Model model) {
        model.addAttribute("team", new Team());
        model.addAttribute("games", gameService.findAll());
        model.addAttribute("leagues", leagueService.findAll());
        return "forms/formTeams";
    }

    @PostMapping("/saveTeam")
    public String saveTeam(@ModelAttribute Team team) {
        teamService.save(team);
        return "redirect:/admin";
    }

    @GetMapping("/editTeam/{id}")
    public String editTeam(@PathVariable Long id, Model model) {
        teamService.findById(id).ifPresent(team -> model.addAttribute("team", team));
        model.addAttribute("games", gameService.findAll());
        model.addAttribute("leagues", leagueService.findAll());
        return "forms/formTeams";
    }

    @GetMapping("/deleteTeam/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
        return "redirect:/admin";
    }

    // ── Players ────────────────────────────────────────────
    @GetMapping("/newPlayer")
    public String showPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("positions", positionService.getAll());
        model.addAttribute("games", gameService.findAll());
        return "forms/formJugadores";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute Player player) {
        playerService.createPlayer(player);
        return "redirect:/admin";
    }

    @GetMapping("/editPlayer/{id}")
    public String editPlayer(@PathVariable Long id, Model model) {
        playerService.findById(id).ifPresent(player -> model.addAttribute("player", player));
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("positions", positionService.getAll());
        model.addAttribute("games", gameService.findAll());
        return "forms/formJugadores";
    }

    @GetMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable Long id) {
        playerService.deleteByid(id);
        return "redirect:/admin";
    }

    // ── Trainers ───────────────────────────────────────────
    @GetMapping("/newTrainer")
    public String showTrainerForm(Model model) {
        model.addAttribute("trainer", new Trainer());
        return "forms/formTrainer";
    }

    @PostMapping("/saveTrainer")
    public String saveTrainer(@ModelAttribute Trainer trainer) {
        trainerService.save(trainer);
        return "redirect:/admin";
    }

    @GetMapping("/editTrainer/{id}")
    public String editTrainer(@PathVariable Long id, Model model) {
        trainerService.findTrainerById(id).ifPresent(trainer -> model.addAttribute("trainer", trainer));
        return "forms/formTrainer";
    }

    @GetMapping("/deleteTrainer/{id}")
    public String deleteTrainer(@PathVariable Long id) {
        trainerService.delete(id);
        return "redirect:/admin";
    }
}