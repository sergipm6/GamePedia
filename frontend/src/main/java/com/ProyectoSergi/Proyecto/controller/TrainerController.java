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
        return "trainers";
    }

    //Create
    @PostMapping("/newTrainer")
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
