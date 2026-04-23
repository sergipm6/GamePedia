package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.Player;
import com.BackendSergi.domain.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    //Read
    @GetMapping("")
    public String players(Model model){
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "players";
    }

    //Create
    @PostMapping("/newPlayer")
    public String newPlayer(@ModelAttribute Player player){
        playerService.createPlayer(player);
        return "redirect:/players";
    }

    //Delete
    @GetMapping("/delete/{id}")
    public String deletePlayer(@PathVariable Long id){
        playerService.deleteByid(id);
        return "redirect:/players";
    }

    //Update
    @GetMapping("/update/{id}")
    public String updatePlayer(@PathVariable Long id, Model model){
        playerService.findById(id).ifPresent(player -> {
            model.addAttribute("player", player);
        });
        return "formPlayer";
    }
}
