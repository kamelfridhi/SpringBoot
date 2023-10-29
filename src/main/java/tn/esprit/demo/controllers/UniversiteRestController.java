package tn.esprit.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import tn.esprit.demo.entities.Universite;
import tn.esprit.demo.services.IBlocServices;
import tn.esprit.demo.services.IUniversiteServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("universite")
@RestController
public class UniversiteRestController {

    private final IUniversiteServices universiteService;

    @GetMapping("/all")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversite();
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u){
        return universiteService.ajouterUniversite(u);
    }

    @PostMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u){
        return universiteService.updateUniversite(u);
    }

    @DeleteMapping ("/delete/{idUniversite}")
    public void deleteUniversite(@PathVariable Long idUniversite){
        universiteService.supprimerUniversite(idUniversite);
    }

}
