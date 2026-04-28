    package com.ProyectoSergi.Proyecto.controller;

    import com.BackendSergi.domain.service.GameService;
    import com.BackendSergi.domain.service.PlayerService;
    import com.BackendSergi.domain.service.TeamService;
    import com.BackendSergi.domain.service.TrainerService;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.ResponseBody;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

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

        //Buscador
        @GetMapping("/api/search")
        @ResponseBody
        public List<Map<String, String>> searchDatabase(@RequestParam("q") String query){
            List<Map<String, String>> results = new ArrayList<>();

            if(query == null || query.trim().isEmpty()){
                return results;
            }

            String lowerQuery = query.toLowerCase();

            gameService.findByGameNameContainingIgnoreCase(
                    lowerQuery).forEach(game -> {
                Map<String, String> map = new HashMap<>();
                map.put("name", game.getGameName());
                map.put("gameGenre", game.getGameGenre());
                map.put("type", "Juego");
                map.put("url", "/games/" + game.getGameId());
                results.add(map);
            });

            teamService.findByTeamNameContainingIgnoreCase(lowerQuery).forEach(team -> {
                Map<String, String> map = new HashMap<>();
                map.put("name", team.getTeamName());
                map.put("type", "Equipo");
                map.put("url", "/teams/" + team.getTeamId());
                results.add(map);
            });

            playerService.findByPlayerNameContainingIgnoreCase(lowerQuery).forEach(player -> {
                Map<String, String> map = new HashMap<>();
                map.put("name", player.getPlayerName());
                map.put("type", "Jugador");
                map.put("url", "/players/" + player.getPlayerId());
                results.add(map);
            });

            trainerService.findByTrainerNameContainingIgnoreCase(lowerQuery).forEach(trainer -> {
                Map<String, String> map = new HashMap<>();
                map.put("name", trainer.getTrainerName());
                map.put("type", "Entrenador");
                map.put("url", "/trainers/" + trainer.getTrainerId());
                results.add(map);
            });

            return results.size() > 10 ? results.subList(0, 10) : results;
        }


    }
