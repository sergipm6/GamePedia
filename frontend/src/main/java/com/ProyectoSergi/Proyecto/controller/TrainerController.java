package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.Trainer;
import com.BackendSergi.domain.repository.TrainerRepository;
import com.BackendSergi.domain.service.CommentService;
import com.BackendSergi.domain.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("trainers")
public class TrainerController {

    private TrainerService trainerService;
    private CommentService commentService;


    public TrainerController(TrainerService trainerService,  CommentService commentService) {
        this.trainerService = trainerService;
        this.commentService = commentService;
    }

    //Read
    @GetMapping("")
    public String personal(Model model){
        model.addAttribute("trainers", trainerService.findAllTrainers());
        return "lists/listTrainers";
    }

    @GetMapping("/{id}")
    public String showCard(@PathVariable Long id, Model model){
        trainerService.findTrainerById(id).ifPresent(trainer ->
                model.addAttribute("trainer", trainer));
                model.addAttribute("comments", commentService.getComments("trainer", Long.valueOf(id)));
        return "cards/cardTrainer";
    }



}
