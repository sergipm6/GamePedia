package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.Player;
import com.BackendSergi.domain.service.CommentService;
import com.BackendSergi.domain.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/players")
public class PlayerController {

    private PlayerService playerService;
    private CommentService commentService;

    public PlayerController(PlayerService playerService, CommentService  commentService) {
        this.playerService = playerService;
        this.commentService = commentService;
    }

    //Read
    @GetMapping("")
    public String players(Model model){
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players);
        return "lists/listPlayers";
    }

   @GetMapping("/{id}")
    public String player(@PathVariable Long id, Model model){
        Optional<Player> player = playerService.findById(id);

        if(player.isPresent()){
            model.addAttribute("player", player.get());
            model.addAttribute("comments", commentService.getComments("player", id));
            return "cards/cardPlayer";
        }

        return  "lists/listPlayers";
   }
}
