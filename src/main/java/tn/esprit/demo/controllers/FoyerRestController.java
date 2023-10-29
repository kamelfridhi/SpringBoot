package tn.esprit.demo.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.demo.entities.Foyer;
import tn.esprit.demo.services.IFoyerServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("foyer")
@RestController
public class FoyerRestController {
    private final IFoyerServices foyerServices;

    @GetMapping("/all")
    public List<Foyer> getAllFoyer(){
        return foyerServices.getAllFoyer();
    }

    @PostMapping("/add")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.ajouterFoyer(f);
    }

    @PostMapping("/update")
    public Foyer updateFoyer(@RequestBody Foyer f){
        return foyerServices.updateFoyer(f);
    }

    @DeleteMapping ("/delete/{idFoyer}")
    public void deleteFoyer(@PathVariable Long idFoyer){
        foyerServices.supprimerFoyer(idFoyer);
    }

}
