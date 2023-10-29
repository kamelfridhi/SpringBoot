package tn.esprit.demo.services;

import tn.esprit.demo.entities.Etudiant;

import java.util.List;

public interface IEtudiantServices {
    Etudiant ajouterEtudiant(Etudiant et);
    Etudiant updateEtudiant(Etudiant et);
    void supprimerEtudiant(long idEtudiant);
    Etudiant getEtudiant(long idEtudiant);
    List<Etudiant> getAllEtudiants();
}
