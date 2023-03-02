package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entites.Equipe;
import com.esprit.kaddem.services.interfaces.IEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeRestController {
        IEquipeService equipeService;
        // http://localhost:8081/kaddem/equipe/retrieve-all-equipes
        @GetMapping("/retrieve-all-equipes")
        public List<Equipe> getEquipes() {
            List<Equipe> listEquipes = equipeService.retrieveAllEquipes();
            return listEquipes;
        }

    // http://localhost:8081/kaddem/equipe/retrieve-equipe/8
    @GetMapping("/retrieve-equipe/{equipe-id}")
    public Equipe retrieveEquipe(@PathVariable("equipe-id") Integer equipeId) {
        return equipeService.retrieveEquipe(equipeId);
    }

    // http://localhost:8089/kaddem/equipe/add-equipe
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe e) {
        Equipe equipe = equipeService.addEquipe(e);
        return equipe;
    }
    // http://localhost:8081/kaddem/equipe/remove-equipe/8
  @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Equipe e) {
        equipeService.deleteEquipe(e);
    }
    // http://localhost:8081/kaddem/equipe/modify-equipe
    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe e) {
        return equipeService.updateEquipe(e);
    }
}
