package tn.esprit.demo.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.entities.Chambre;
import tn.esprit.demo.entities.Foyer;
import tn.esprit.demo.repositories.IBlocRepository;
import tn.esprit.demo.repositories.IChambreRepository;
import tn.esprit.demo.repositories.IFoyerRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class BlocServicesImpl implements IBlocServices {
    IBlocRepository blocRepo ;
    IFoyerRepository foyerRepository;
    IChambreRepository chambreRepository;

    @Override
    public Bloc ajouterBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepo.save(b);
    }

    @Override
    public void supprimerBloc(long idBloc) {
        blocRepo.deleteById(idBloc);
    }

    @Override
    public Bloc getBloc(long idBloc) {
        return blocRepo.findById(idBloc).orElse(null);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return (List<Bloc>) blocRepo.findAll();
    }

    @Transactional
    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Bloc b = blocRepo.findByNomBloc(nomBloc);
        for(Long id : numChambre){
            Chambre c = chambreRepository.findById(id).orElse(null);
            c.setBlocchambre(b);
        }
        return b;
    }
    @Transactional
    @Override
    public Bloc affecterBlocAFoyer(String nomBloc, String nomFoyer) {
        Bloc b = blocRepo.findByNomBloc(nomBloc);
        Foyer f = foyerRepository.findByNomFoyer(nomFoyer);
        b.setFoyer(f);
        return b;
    }
}
