package tn.esprit.demo.services;

import tn.esprit.demo.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    Universite ajouterUniversite(Universite u);
    Universite updateUniversite(Universite u);
    void supprimerUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);
    List<Universite> getAllUniversite();

    Universite findbyNomuniv(String nom);
    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite (long idFoyer, long idUniversite) ;
}
