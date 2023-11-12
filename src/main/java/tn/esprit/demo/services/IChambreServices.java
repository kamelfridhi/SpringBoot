package tn.esprit.demo.services;

import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.TypeChambre;

import java.util.List;

public interface IChambreServices {
    Chambre ajouterChambre(Chambre ch);
    Chambre updateChambre(Chambre ch);
    void supprimerChambre(long idChambre);
    Chambre getChambre(long idChambre);
    List<Chambre> getAllChambres();

    List<Chambre> getChambresParNomBloc( String nomBloc) ;
    long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) ;
    List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre( String nomFoyer,TypeChambre type) ;
    List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC);

}
