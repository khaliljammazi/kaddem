package com.esprit.kaddem.controllers;

import com.esprit.kaddem.entites.Universite;
import com.esprit.kaddem.services.UniversiteServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")

public class UniversiteController {
    UniversiteServiceImpl universiteService;


    // http://localhost:8081/kaddem/universite/retrieve-all-universites
    @RequestMapping("/retrieve-all-universites")
    public List<Universite> getUniversites() {
        List<Universite> listUniversites = universiteService.retrieveAllUniversites();
        return listUniversites;
    }

    // http://localhost:8081/kaddem/universite/retrieve-universite/5
    @RequestMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Integer universiteId) {
        return universiteService.retrieveUniversite(universiteId);
    }

    // http://localhost:8089/kaddem/universite/add-universite
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite u) {
        Universite universite = universiteService.addUniversite(u);
        return universite;
    }
    // http://localhost:8081/kaddem/universite/remove-universite/5
    @DeleteMapping("/remove-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Universite u) {
        universiteService.deleteUniversite(u);
    }

    // http://localhost:8081/kaddem/universite/modify-universite
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite u) {
        return universiteService.updateUniversite(u);
}



}
