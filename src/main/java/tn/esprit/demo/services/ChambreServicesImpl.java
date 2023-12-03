package tn.esprit.demo.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.Foyer;
import tn.esprit.demo.entities.TypeChambre;
import tn.esprit.demo.repositories.IBlocRepository;
import tn.esprit.demo.repositories.IChambreRepository;
import tn.esprit.demo.repositories.IFoyerRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ChambreServicesImpl  implements IChambreServices{
    IChambreRepository chambreRepo;
    IBlocRepository blocRepository;
    IFoyerRepository foyerRepository;

    @Override
    public Chambre ajouterChambre(Chambre ch) {
        return chambreRepo.save(ch);
    }

    @Override
    public Chambre updateChambre(Chambre ch) {
        return chambreRepo.save(ch);
    }

    @Override
    public void supprimerChambre(long idChambre) {
        chambreRepo.deleteById(idChambre);
    }

    @Override
    public Chambre getChambre(long idChambre) {
        return chambreRepo.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return (List<Chambre>) chambreRepo.findAll();
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = new ArrayList<>();
        for(Chambre c : b.getChambres()){
            chambres.add(c);

        }
        return chambres;
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {
        Bloc b = blocRepository.findById(idBloc).orElse(null);
        int nbrchambre = 0;
        for(Chambre c : b.getChambres()){
            if (c.getTypeC()==type) {
                nbrchambre++;
            }
        }
        return  nbrchambre;
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomFoyerEtTypeChambre(String nomFoyer, TypeChambre type) {

        Foyer foyer = foyerRepository.findByNomFoyer(nomFoyer);
        List<Chambre> chambre = new ArrayList<>();
        List<Bloc> blocs = blocRepository.findByFoyer(foyer);
        for (Bloc b : blocs) {

            chambre.addAll(chambreRepo.findByTypeCAndBlocchambreAndReservations(type,b,null));
        }




        return chambre;
    }
    @Override
    public List<Chambre> getChambresParBlocEtType(long idBloc, TypeChambre typeC)
    {
        Bloc b = blocRepository.findById(idBloc).orElse(null);

        return  chambreRepo.findByBlocchambreAndTypeC(b,typeC);
    }

    @Override
    public Chambre getChambreParId(long id) {

        return chambreRepo.findById(id).orElse(null);
    }



}
