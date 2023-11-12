package tn.esprit.demo.services;

import tn.esprit.demo.entities.Foyer;

import java.util.List;

public interface IFoyerServices {
    Foyer ajouterFoyer(Foyer foyer);
    Foyer updateFoyer(Foyer foyer);
    void supprimerFoyer(Long idFoyer);
    Foyer getFoyer(Long idFoyer);
    List<Foyer> getAllFoyer();

    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, long idUniversite) ;
}
