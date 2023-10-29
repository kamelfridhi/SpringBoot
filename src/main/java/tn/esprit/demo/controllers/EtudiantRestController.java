package tn.esprit.demo.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.demo.entities.Etudiant;
import tn.esprit.demo.services.IEtudiantServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("etudiant")
@RestController
public class EtudiantRestController {
    private final IEtudiantServices etudiantService;
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiants();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e){
        return etudiantService.ajouterEtudiant(e);
    }

    @PostMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return etudiantService.updateEtudiant(e);
    }

    @DeleteMapping ("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant){
        etudiantService.supprimerEtudiant(idEtudiant);
    }


}
