    package com.ProyectoSergi.Proyecto.controller;

    import com.BackendSergi.domain.service.GameService;
    import com.BackendSergi.domain.service.PlayerService;
    import com.BackendSergi.domain.service.TeamService;
    import com.BackendSergi.domain.service.TrainerService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("")
    public class MainController {

        private TeamService teamService;
        private GameService gameService;
        private PlayerService playerService;
        private TrainerService trainerService;

        public MainController(TeamService teamService, GameService gameService, PlayerService playerService, TrainerService trainerService) {
            this.teamService = teamService;
            this.gameService = gameService;
            this.playerService = playerService;
            this.trainerService = trainerService;

        }

        //Index
        @GetMapping("")
        public String index(Model model) {
            model.addAttribute("totalTeams", teamService.findAll().size());
            model.addAttribute("totalPlayers", playerService.findAll().size());
            model.addAttribute("totalGame", gameService.findAll().size());
            model.addAttribute("totalTrainers", trainerService.findAllTrainers().size());
            return "index";
        }


    }
