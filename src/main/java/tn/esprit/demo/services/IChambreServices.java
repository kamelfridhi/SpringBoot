package tn.esprit.demo.services;

import tn.esprit.demo.entities.Chambre;

import java.util.List;

public interface IChambreServices {
    Chambre ajouterChambre(Chambre ch);
    Chambre updateChambre(Chambre ch);
    void supprimerChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getAllChambres();
}
