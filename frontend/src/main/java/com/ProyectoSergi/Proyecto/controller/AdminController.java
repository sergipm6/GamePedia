package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.*;
import com.BackendSergi.domain.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    public AdminController(UserService userService, GameService gameService, LeagueService leagueService, PlayerService playerService, PositionService positionService, TeamService teamService, TrainerService trainerService) {
        this.userService = userService;
        this.gameService = gameService;
        this.leagueService = leagueService;
        this.playerService = playerService;
        this.positionService = positionService;
        this.teamService = teamService;
        this.trainerService = trainerService;
    }


    @GetMapping("")
    public String dashboard(Model model) {
        model.addAttribute("games", gameService.findAll());
        model.addAttribute("leagues", leagueService.findAll());
        model.addAttribute("players", playerService.findAll());
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("players", playerService.findAll());
        return "private/dashboard";
    }

    //Métodos para games

    //Show form
    @GetMapping("/newGame")
    public String ShowGameForm(Model model) {
        model.addAttribute("game", new Game());
        return "forms/formGames";
    }

    //Post
    @PostMapping("/saveGame")
    public String newGame(@ModelAttribute Game game){
        gameService.save(game);
        return  "redirect:/games";
    }

    //Delete
    @GetMapping("/deleteGame/{id}")
    public String deleteGame(@PathVariable Integer id){
        gameService.deleteById(id);
        return "redirect:/games";
    }

    //Update
    @GetMapping("/editGame/{id}")
    public String updateGame(Model model, @PathVariable Integer id){
        gameService.findById(id).ifPresent(game->{
            model.addAttribute("game", game);
        });
        return "forms/formGames";
    }

    //Métodos para competiciones

    //Show form
    @GetMapping("/newLeague")
    public String showLeagueForm(Model model) {
        model.addAttribute("league", new League());
        model.addAttribute("games", gameService.findAll());
        return "redirect:forms/formCompetition";
    }

    //Create
    @PostMapping("/saveLeague")
    public String saveLeague(@ModelAttribute League league) {
        leagueService.createLeague(league);
        return "lists/listCompetition";
    }

    //Update
    @GetMapping("/updateLeague/{id}")
    public String updateLeague(Model model, @PathVariable Integer id) {
        Optional<League> leagues = leagueService.findById(id);
        if (leagues.isPresent()) {
            model.addAttribute("league", leagues.get());
            model.addAttribute("games", gameService.findAll());
            return "forms/formCompetition";
        }else{
            return "lists/listCompetition";
        }
    }

    //Delete
    @GetMapping("/deleteLeague/{id}")
    public String deleteLeague(@PathVariable Integer id) {
        leagueService.delete(id);
        return "redirect:lists/listCompetition";
    }

    //Métodos para equipos

    //Show form
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
        return "redirect:/teams";
    }

    @GetMapping("/deleteTeam/{id}")
    public String deleteTeam(@PathVariable Long id) {
        teamService.deleteById(id);
        return "redirect:/teams";
    }

    @GetMapping("/updateTeam/{id}")
    public String updateTeam(@PathVariable Long id, Model model) {
        teamService.findById(id).ifPresent(team -> {
            model.addAttribute("team", team);
        });
        return "forms/formTeams";
    }

    //Métodos para jugadores

    //Show form
    @GetMapping("/newPlayer")
    public String showPlayerForm(Model model) {
        model.addAttribute("player", new Player());
        model.addAttribute("teams", teamService.findAll());
        model.addAttribute("positions", positionService.getAll());
        return "forms/formJugadores";
    }

    //Create
    @PostMapping("/savePlayer")
    public String newPlayer(@ModelAttribute Player player){
        playerService.createPlayer(player);
        return "redirect:/players";
    }

    //Delete
    @GetMapping("/deletePlayer/{id}")
    public String deletePlayer(@PathVariable Long id){
        playerService.deleteByid(id);
        return "redirect:/players";
    }

    //Update
    @GetMapping("/updatePlayer/{id}")
    public String updatePlayer(@PathVariable Long id, Model model){
        playerService.findById(id).ifPresent(player -> {
            model.addAttribute("player", player);
        });
        return "formPlayer";
    }

    //Métodos para entrenador

    //Show form
    @GetMapping("/newTrainer")
    public String showTrainerForm(Model model) {
        model.addAttribute("trainer", new Trainer());
        return "forms/formTrainer";
    }

    //Create
    @PostMapping("/saveTrainer")
    public String newTrainer(@ModelAttribute Trainer trainer){
        trainerService.save(trainer);
        return "redirect:/trainers";
    }

    //Delete
    @GetMapping("/deleteTrainer/{id}")
    public String deleteTrainer(@PathVariable Long id){
        trainerService.delete(id);
        return "redirect:/trainers";
    }

    //Update
    @GetMapping("/updateTrainer/{id}")
    public String updateTrainer(Model model, @PathVariable Long id){
        trainerService.findTrainerById(id).ifPresent(trainer ->{
            model.addAttribute("trainer", trainer);
        });
        return "redirect:/trainers";
    }

}

