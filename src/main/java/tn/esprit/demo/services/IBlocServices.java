package tn.esprit.demo.services;

import tn.esprit.demo.entities.Bloc;

import java.util.List;

public interface IBlocServices {
    Bloc ajouterBloc(Bloc b);
    Bloc updateBloc(Bloc b);
    void supprimerBloc(long idBloc);
    Bloc getBloc(long idBloc);
    List<Bloc> getAllBlocs();

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc);
    public Bloc affecterBlocAFoyer( String nomBloc, String nomFoyer);


}
