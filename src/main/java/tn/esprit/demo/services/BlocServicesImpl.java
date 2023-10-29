package tn.esprit.demo.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Bloc;
import tn.esprit.demo.repositories.IBlocRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class BlocServicesImpl implements IBlocServices {
    IBlocRepository blocRepo ;

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
}
