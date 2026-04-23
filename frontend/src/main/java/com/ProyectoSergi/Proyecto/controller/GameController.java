package com.ProyectoSergi.Proyecto.controller;


import com.BackendSergi.domain.entity.Game;
import com.BackendSergi.domain.entity.Team;
import com.BackendSergi.domain.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/games")
public class GameController {

    private GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    //Get
    @GetMapping("")
    public String games(Model model){
        model.addAttribute("games", gameService.findAll());
        return "/lists/listGames";
    }


    //Post
    @PostMapping("/newGame")
    public String newGame(@ModelAttribute Game game){
        gameService.save(game);
        return  "redirect:/games";
    }

    //Delete
    @GetMapping("/delete/{id}")
    public String deleteGame(@PathVariable Long id){
        gameService.deleteById(id);
        return "redirect:/games";
    }

    //Update
    @PutMapping("/edit/{id}")
    public String updateGame(Model model, @PathVariable Long id){
        gameService.findById(id).ifPresent(game->{
            model.addAttribute("game", game);
        });
        return "redirect: forms/formGames";
    }
}
