package com.ProyectoSergi.Proyecto.controller;

import com.BackendSergi.domain.entity.Trainer;
import com.BackendSergi.domain.repository.TrainerRepository;
import com.BackendSergi.domain.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class TrainerController {

    private TrainerService trainerService;


    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    //Read
    @GetMapping("/trainers")
    public String personal(Model model){
        model.addAttribute("trainers", trainerService.findAllTrainers());
        return "lists/listTrainers";
    }



}
